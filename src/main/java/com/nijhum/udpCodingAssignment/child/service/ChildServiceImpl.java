package com.nijhum.udpCodingAssignment.child.service;

import com.nijhum.udpCodingAssignment.child.model.Child;
import com.nijhum.udpCodingAssignment.child.repository.ChildRepository;
import com.nijhum.udpCodingAssignment.common.service.CommonServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ChildServiceImpl extends CommonServiceImpl<Child> implements ChildService<Child> {

    private ChildRepository childRepository;

    public ChildServiceImpl(ChildRepository childRepository){
        this.childRepository = childRepository;
        this.setRepository(childRepository);
    }

}