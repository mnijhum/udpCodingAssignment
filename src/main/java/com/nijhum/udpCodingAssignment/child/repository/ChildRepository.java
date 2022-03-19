package com.nijhum.udpCodingAssignment.child.repository;

import com.nijhum.udpCodingAssignment.child.model.Child;
import com.nijhum.udpCodingAssignment.common.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends CommonRepository<Child, Long> {

}
