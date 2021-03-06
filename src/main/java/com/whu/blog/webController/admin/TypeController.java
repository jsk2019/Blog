package com.whu.blog.webController.admin;


import com.whu.blog.model.Type;
import com.whu.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC)
                                    Pageable pageable, Model model){
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }

    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/types-input";
    }

    @PostMapping("/types")
    public String PostType(@Valid  Type type, BindingResult result, RedirectAttributes attributes){
       Type t = typeService.getTypeByName(type.getName());
       if(t!=null){
           result.rejectValue("name","nameError","该分类已存在");
       }
        if(result.hasErrors()){
            return "admin/types-input";
        }
        Type type1=typeService.saveType(type);
        if (type1 == null){
            attributes.addFlashAttribute("message","操作失败");
            attributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/types";
    }


    @PostMapping("/types/{id}")
    public String EditPostType(@Valid  Type type, BindingResult result,@PathVariable Long id, RedirectAttributes attributes){
        Type t = typeService.getTypeByName(type.getName());
        if(t!=null){
            result.rejectValue("name","nameError","该分类已存在");
        }
        if(result.hasErrors()){
            return "admin/types-input";
        }
        Type type1=typeService.updateType(id,type);
        if (type1 == null){
            attributes.addFlashAttribute("message","更新失败");
            attributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes redirectAttributes){
        typeService.deleteType(id);
        redirectAttributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }
}
