package com.jobconnect.backend.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long joNum;

    @ManyToOne
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
    private LocalDateTime joRegDate;

    @Column(nullable = false)
    private LocalDateTime joUpDate;

    @Column(nullable = false)
    private Integer joViews;

    @Column(nullable = false)
    private Integer joDel;

    @Column(nullable = false)
    private Integer joSecret;

    private LocalDateTime joDeadDate;

    private LocalDateTime joEndDate;






}
