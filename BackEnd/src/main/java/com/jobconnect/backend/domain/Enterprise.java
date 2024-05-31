package com.jobconnect.backend.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
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

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.REMOVE)
    private List<Job> jobList;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }

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
