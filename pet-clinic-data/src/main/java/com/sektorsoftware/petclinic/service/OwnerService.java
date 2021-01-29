package com.sektorsoftware.petclinic.service;

import com.sektorsoftware.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
