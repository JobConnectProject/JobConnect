package com.jobconnect.backend.service;


import com.jobconnect.backend.domain.Enterprise;
import com.jobconnect.backend.dto.EnterpriseSignupDto;
import com.jobconnect.backend.repository.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    public void create(EnterpriseSignupDto dto) {
        if(enterpriseRepository.existsByEnEmail(dto.getEnEmail())){
            throw new IllegalArgumentException("Enterprise email already exists");
        }

        Enterprise enterprise = Enterprise.builder()
                .enEmail(dto.getEnEmail())
                .enPw(dto.getEnPw())
                .enRep(dto.getEnRep())
                .enBusinessNum(dto.getEnBusinessNum())
                .enPhone(dto.getEnPhone())
                .enState(dto.getEnState())
                .createdDate(dto.getCreatedDate())
                .build();

                enterpriseRepository.save(enterprise);
    }
}
