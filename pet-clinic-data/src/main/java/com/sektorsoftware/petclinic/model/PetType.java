package com.sektorsoftware.petclinic.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PetType extends BaseEntity {

    private String name;
}
