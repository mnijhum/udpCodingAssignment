package com.nijhum.udpCodingAssignment.parent.service;


import com.nijhum.udpCodingAssignment.common.service.CommonServiceImpl;
import com.nijhum.udpCodingAssignment.parent.entity.Parent;
import com.nijhum.udpCodingAssignment.parent.repository.ParentRepository;

import org.springframework.stereotype.Service;

@Service
public class ParentServiceImpl extends CommonServiceImpl<Parent> implements ParentService<Parent>{

    private ParentRepository parentRepository;

    public ParentServiceImpl(ParentRepository parentRepository){
        this.parentRepository = parentRepository;
        this.setRepository(parentRepository);
    }

}
