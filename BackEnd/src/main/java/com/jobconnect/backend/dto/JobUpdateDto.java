package com.jobconnect.backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class JobUpdateDto {

    private String joTitle;
    private Integer joGender;
    private String joAge;
    private String joEdu;
    private String joType;
    private Integer joCount;
    private String joPay;
    private String joWeek;
    private String joTime;
    private String joAreaDetail;
    private String joSubway;
    private String joUniversity;
    private String joContent;
    private Integer joViews;
    private Integer joDel;
    private Integer joSecret;
    private LocalDateTime joDeadDate;
    private LocalDateTime joEndDate;

    @Builder
    public JobUpdateDto(String joTitle, Integer joGender, String joAge, String joEdu, String joType,
                          Integer joCount, String joPay, String joWeek, String joTime, String joAreaDetail,
                          String joSubway, String joUniversity, String joContent, Integer joViews,
                          Integer joDel, Integer joSecret, LocalDateTime joDeadDate, LocalDateTime joEndDate) {

        this.joTitle = joTitle;
        this.joGender = joGender;
        this.joAge = joAge;
        this.joEdu = joEdu;
        this.joType = joType;
        this.joCount = joCount;
        this.joPay = joPay;
        this.joWeek = joWeek;
        this.joTime = joTime;
        this.joAreaDetail = joAreaDetail;
        this.joSubway = joSubway;
        this.joUniversity = joUniversity;
        this.joContent = joContent;
        this.joViews = joViews;
        this.joDel = joDel;
        this.joSecret = joSecret;
        this.joDeadDate = joDeadDate;
        this.joEndDate = joEndDate;
    }
}
