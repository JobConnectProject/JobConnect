package com.jobconnect.backend.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Enterprise extends BaseEntity {

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

    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.REMOVE)
    private List<Job> jobList;


    @Builder
    public Enterprise(String enEmail, String enPw, String enRep, String enBusinessNum, String enPhone, Integer enState) {
        this.enEmail = enEmail;
        this.enPw = enPw;
        this.enRep = enRep;
        this.enBusinessNum = enBusinessNum;
        this.enPhone = enPhone;
        this.enState = enState;
    }

    public void updateEnterprise(String enPw, String enRep, String enPhone){
        this.enPw = enPw;
        this.enRep = enRep;
        this.enPhone = enPhone;
    }
}
