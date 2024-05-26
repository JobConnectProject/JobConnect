package com.jobconnect.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자에 접근 제어자 설정
@AllArgsConstructor
@Table(name = "member") // member 테이블과 매핑
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long meId;

    @Column(length = 30, nullable = false)
    private String meEmail;

    @Column(length = 15, nullable = false)
    private String mePw;

    @Column(length = 20, nullable = false)
    private String meName;

    @Column(nullable = false)
    private LocalDate meBirth;

    @Column(nullable = false)
    private int meGender;

    @Column(length = 13, nullable = false)
    private String mePhone;

    @Column(nullable = false)
    private int meAuthority;

    @Column(nullable = false)
    private LocalDate meCreatAt;

    @Column(nullable = false)
    private LocalDate meUpdateAt;

    @Column(nullable = false)
    private LocalDate mePwUpdateAt;

}
