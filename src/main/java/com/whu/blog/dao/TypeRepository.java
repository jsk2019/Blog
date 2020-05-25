package com.whu.blog.dao;

import com.whu.blog.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type,Long> {
    Type findByName(String name);
}
