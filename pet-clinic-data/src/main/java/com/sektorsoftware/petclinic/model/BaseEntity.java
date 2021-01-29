package com.sektorsoftware.petclinic.model;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseEntity implements Serializable {

    private Long id;
}
