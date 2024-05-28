package com.jobconnect.backend.dto.enterprise;


import lombok.Builder;
import lombok.Getter;

@Getter
public class EnterpriseUpdateDto {

    private String enPw;
    private String enRep;
    private String enPhone;

    @Builder
    public EnterpriseUpdateDto(String enPw,String enRep, String enPhone){
        this.enPw = enPw;
        this.enRep = enRep;
        this.enPhone = enPhone;
    }
}
