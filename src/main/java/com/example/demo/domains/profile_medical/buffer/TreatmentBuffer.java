package com.example.demo.domains.profile_medical.buffer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreatmentBuffer {

    private long id;

    private String name;


    private Long price;


    HospitalBuffer hospital;


    MedicalBuffer medical;

//    public void setTreatment()
}
