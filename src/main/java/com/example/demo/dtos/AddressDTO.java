package com.example.demo.dtos;

import com.example.demo.domains.member.entity.MyLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor  // 기본 생성자 추가
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자 추가
public class AddressDTO {

    private long id;

    private String address;

    private String isPrimary;

    private String receipientName;

    private String receipientTellNum;

    public AddressDTO(MyLocation myLocation) {
        this.id = myLocation.getId();
        this.address = myLocation.getAddress();
        this.isPrimary = myLocation.getIsPrimary();
        this.receipientName = myLocation.getReceipientName();
        this.receipientTellNum = myLocation.getReceipientTellNum();
    }
}
