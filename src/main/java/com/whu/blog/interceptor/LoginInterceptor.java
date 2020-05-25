package com.whu.blog.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       if(request.getSession().getAttribute("user") == null){
           request.setAttribute("message","没有权限，请先登录");
           response.sendRedirect("/admin");
           return false;
       }

        return true;
    }
}
