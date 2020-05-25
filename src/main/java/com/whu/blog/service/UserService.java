package com.whu.blog.service;

import com.whu.blog.model.User;

public interface UserService {
    User checkUser(String username,String password);

}
