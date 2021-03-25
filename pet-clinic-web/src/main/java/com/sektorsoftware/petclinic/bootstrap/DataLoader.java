package com.sektorsoftware.petclinic.bootstrap;

import com.sektorsoftware.petclinic.model.Owner;
import com.sektorsoftware.petclinic.model.Pet;
import com.sektorsoftware.petclinic.model.PetType;
import com.sektorsoftware.petclinic.model.Specialty;
import com.sektorsoftware.petclinic.model.Vet;
import com.sektorsoftware.petclinic.service.OwnerService;
import com.sektorsoftware.petclinic.service.PetTypeService;
import com.sektorsoftware.petclinic.service.SpecialtyService;
import com.sektorsoftware.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    private Owner owner1;
    private Owner owner2;
    private Vet vet1;
    private Vet vet2;
    private PetType savedDogPetType;
    private PetType savedCatPetType;
    private Specialty savedRadiology;
    private Specialty savedSurgery;
    private Specialty savedDentistry;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {

        loadPetTypes();
        loadSpecialties();
        loadOwners();
        loadVets();
    }

    private void loadOwners() {

        owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123456789");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now().minusYears(3));
        mikesPet.setName("Roscoe");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("111222333");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now().minusYears(5));
        fionasPet.setName("Mad Cat");
        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");
    }

    private void loadVets() {

        vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }

    private void loadPetTypes() {

        PetType dog = new PetType();
        dog.setName("Dog");
        savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes...");
    }

    private void loadSpecialties() {

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        savedDentistry = specialtyService.save(dentistry);

        System.out.println("Loaded Specialties...");
    }
}
