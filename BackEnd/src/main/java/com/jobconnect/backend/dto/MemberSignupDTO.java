package com.jobconnect.backend.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class MemberSignupDTO {

    private String meEmail;
    private String mePw;
    private String meName;
    private LocalDate meBirth;
    private int meGender;
    private String mePhone;
}
