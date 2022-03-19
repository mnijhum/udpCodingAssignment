package com.nijhum.udpCodingAssignment.parent.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
