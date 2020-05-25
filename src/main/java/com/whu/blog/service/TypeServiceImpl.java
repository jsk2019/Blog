package com.whu.blog.service;

import com.whu.blog.NotFoundException;
import com.whu.blog.dao.TypeRepository;
import com.whu.blog.model.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeRepository typeRepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findOne(id);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type type1 = typeRepository.findOne(id);
        if (type1 == null){
            throw  new NotFoundException("不存在该类型，方法：updateType()");
        }
        BeanUtils.copyProperties(type,type1);
        return typeRepository.save(type1);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.delete(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }
}
