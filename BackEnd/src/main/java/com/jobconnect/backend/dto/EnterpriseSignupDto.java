package com.jobconnect.backend.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class EnterpriseSignupDto {

    private String enEmail;
    private String enPw;
    private String enRep;
    private String enBusinessNum;
    private String enPhone;
    private Integer enState;
    private Date createdDate = new Date();


    @Builder
    public EnterpriseSignupDto(String enEmail, String enPw, String enRep, String enBusinessNum, String enPhone, Integer enState, Date createdDate){
        this.enEmail = enEmail;
        this.enPw = enPw;
        this.enRep = enRep;
        this.enBusinessNum = enBusinessNum;
        this.enPhone = enPhone;
        this.enState = enState;
        this.createdDate = createdDate;
    }
}
