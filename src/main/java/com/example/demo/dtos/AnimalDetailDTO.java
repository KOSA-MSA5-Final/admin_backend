package com.example.demo.dtos;

import com.example.demo.domains.profile_medical.entity.AnimalDetail;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalDetailDTO {
    Long id;
    String name;
    AnimalDTO animalDTO;
    public AnimalDetailDTO(AnimalDetail animalDetail) {
        this.id = animalDetail.getId();
        this.name = animalDetail.getName();
        this.animalDTO = new AnimalDTO(animalDetail.getAnimal());
    }
}
