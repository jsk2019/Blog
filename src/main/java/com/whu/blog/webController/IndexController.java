package com.whu.blog.webController;

import com.whu.blog.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        System.out.println("-------index-------");
        return "index";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }
}
