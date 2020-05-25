package com.whu.blog.dao;

import com.whu.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


//使用jpa进行数据库相关操作
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username,String password);
}
