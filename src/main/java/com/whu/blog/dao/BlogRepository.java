package com.whu.blog.dao;

import com.whu.blog.model.Blog;
import com.whu.blog.model.Type;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> , JpaSpecificationExecutor<Blog> {

}
