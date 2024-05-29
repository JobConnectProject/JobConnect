package com.jobconnect.backend.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Job extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long joNum;

    @ManyToOne
    @JoinColumn(name = "enId", nullable = false)
    private Enterprise enterprise;

    @Column(nullable = false)
    private String joName;

    @Column(nullable = false)
    private String joTitle;

    @Column(nullable = false)
    private Integer joGender;

    @Column(nullable = false)
    private String joAge;

    @Column(nullable = false)
    private String joEdu;

    @Column(nullable = false)
    private String joType;

    @Column(nullable = false)
    private Integer joCount;

    @Column(nullable = false)
    private String joPay;

    @Column(nullable = false)
    private String joWeek;

    @Column(nullable = false)
    private String joTime;

    @Column(nullable = false)
    private String joAreaDetail;

    private String joSubway;

    private String joUniversity;

    private String joContent;

    @Column(nullable = false)
    private Integer joViews;

    @Column(nullable = false)
    private Integer joDel;

    @Column(nullable = false)
    private Integer joSecret;

    private LocalDateTime joDeadDate;

    private LocalDateTime joEndDate;

    @Builder
    public Job(String joName, String joTitle, Integer joGender, String joAge, String joEdu,
               String joType, Integer joCount, String joPay, String joWeek, String joTime, String joAreaDetail,
               String joSubway, String joUniversity, String joContent, Integer joViews, Integer joDel,
               Integer joSecret, LocalDateTime joDeadDate, LocalDateTime joEndDate) {

        this.joName = joName;
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


    public void updateJob(String joTitle, Integer joGender, String joAge, String joEdu, String joType,
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
