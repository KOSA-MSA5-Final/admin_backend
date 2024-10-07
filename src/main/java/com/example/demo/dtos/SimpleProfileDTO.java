package com.example.demo.dtos;

import com.example.demo.domains.profile_medical.entity.Profile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleProfileDTO {
    private Long id;

    private String name;

    private String pictureUrl;

    private String isCurrent;

    public SimpleProfileDTO(Profile profile) {
        this.id = profile.getId();
        this.name = profile.getName();
        this.pictureUrl = profile.getPictureUrl();
        this.isCurrent = profile.getIsCurrent();
    }
}
