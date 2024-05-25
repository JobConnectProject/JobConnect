package com.jobconnect.backend.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enId;

    @Column(nullable = false)
    private String enEmail;

    @Column(nullable = false)
    private String enPw;

    @Column(nullable = false)
    private String enRep;

    @Column(nullable = false)
    private String enBusinessNum;

    @Column(nullable = false)
    private String enPhone;

    @Column(nullable = false)
    private Integer enState;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.REMOVE)
    private List<Job> jobList;
}
