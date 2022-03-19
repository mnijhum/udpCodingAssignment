package com.nijhum.udpCodingAssignment.parent.repository;

import com.nijhum.udpCodingAssignment.common.repository.CommonRepository;
import com.nijhum.udpCodingAssignment.parent.entity.Parent;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends CommonRepository<Parent, Long> {

}
