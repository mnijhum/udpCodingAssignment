package com.nijhum.udpCodingAssignment.common.service;

import com.nijhum.udpCodingAssignment.common.repository.CommonRepository;
import lombok.Setter;

import java.util.List;

@Setter
public abstract class CommonServiceImpl<T> implements CommonService<T> {

    protected CommonRepository<T, Long> repository;

    @Override
    public List<T> get(){

        return repository.findAll();

    }
    public T get(Long id){
        return repository.getById(id);
    }
    public T save(T entity){
        return  repository.save(entity);
    }

    public T modify(Long id, T entity){
        return repository.save(entity);
    }

    public void delete(Long id){

         repository.deleteById(id);
    }


}
