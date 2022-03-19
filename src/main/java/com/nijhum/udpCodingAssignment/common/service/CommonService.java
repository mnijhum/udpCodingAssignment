package com.nijhum.udpCodingAssignment.common.service;

import com.nijhum.udpCodingAssignment.parent.repository.ParentRepository;

import java.util.List;

public interface CommonService<T> {

    List<T> get();
    T get(Long componentId);
    T save(T entity);
    T modify(Long componentId, T entity);
    void delete(Long componentId);

}
