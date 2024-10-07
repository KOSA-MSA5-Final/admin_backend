package com.example.demo.dtos;

import com.example.demo.domains.profile_medical.entity.Animal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalDTO {
    Long id;
    String name;
    public AnimalDTO(Animal animal) {
        this.id = animal.getId();
        this.name = animal.getName();
    }
}
