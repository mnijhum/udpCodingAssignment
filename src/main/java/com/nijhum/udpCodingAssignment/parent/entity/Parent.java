package com.nijhum.udpCodingAssignment.parent.entity;

import com.nijhum.udpCodingAssignment.child.model.Child;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Parent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long componentId;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;

}
