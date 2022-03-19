package com.nijhum.udpCodingAssignment.child.model;


import com.nijhum.udpCodingAssignment.parent.entity.Parent;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Child {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long componentId;
    private String firstName;
    private String lastName;

    @ManyToOne()
    @JoinColumn(name="parentId", nullable=false)
    private Parent parent;

}
