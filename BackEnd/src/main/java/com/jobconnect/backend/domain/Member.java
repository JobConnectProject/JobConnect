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
    @Column(name = "me_id")
    private Long meId;

    @Column(name = "me_email", length = 30, nullable = false, unique = true)
    private String meEmail;

    @Column(name = "me_pw", length = 15, nullable = false)
    private String mePw;

    @Column(name = "me_name", length = 20, nullable = false)
    private String meName;

    @Column(name = "me_birth", nullable = false)
    private LocalDate meBirth;

    @Column(name = "me_gender", nullable = false)
    private int meGender;

    @Column(name = "me_phone", length = 13, nullable = false)
    private String mePhone;

    @Column(name = "me_authority", nullable = false)
    private int meAuthority;

    @Column(name = "me_create_at", nullable = false)
    private LocalDate meCreateAt;

    @Column(name = "me_update_at", nullable = false)
    private LocalDate meUpdateAt;

    @Column(name = "me_pw_update_at", nullable = false)
    private LocalDate mePwUpdateAt;
}
