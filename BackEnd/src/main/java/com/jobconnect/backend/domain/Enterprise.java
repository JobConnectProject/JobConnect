package com.jobconnect.backend.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
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

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedDate;

    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.REMOVE)
    private List<Job> jobList;


    @Builder
    public Enterprise(String enEmail, String enPw, String enRep, String enBusinessNum, String enPhone, Integer enState, Date createdDate) {
        this.enEmail = enEmail;
        this.enPw = enPw;
        this.enRep = enRep;
        this.enBusinessNum = enBusinessNum;
        this.enPhone = enPhone;
        this.enState = enState;
        this.createdDate = createdDate;
    }
}
