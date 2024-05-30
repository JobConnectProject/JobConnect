package com.jobconnect.backend.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class MemberUpdateDTO {

    private String mePw;
    private String mePhone;
}
