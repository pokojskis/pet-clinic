package com.sektorsoftware.petclinic.model;

import lombok.Data;

@Data
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;
}
