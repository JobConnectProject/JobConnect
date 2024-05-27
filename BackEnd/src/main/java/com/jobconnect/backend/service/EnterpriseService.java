package com.jobconnect.backend.service;


import com.jobconnect.backend.domain.Enterprise;
import com.jobconnect.backend.dto.EnterpriseSignupDto;
import com.jobconnect.backend.dto.EnterpriseUpdateDto;
import com.jobconnect.backend.repository.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    public void createEnterprise(EnterpriseSignupDto dto) {
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


    public List<Enterprise> getEnterpriseList() {
        return  enterpriseRepository.findAll();
    }

    @Transactional
    public void updateEnterprise(Long enId, EnterpriseUpdateDto dto){
        Optional<Enterprise> optionalEnterprise = enterpriseRepository.findById(enId);
        if(optionalEnterprise.isPresent()){
            Enterprise enterprise = optionalEnterprise.get();
            enterprise.updateEnterprise(dto.getEnPw(),dto.getEnRep(),dto.getEnPhone(),dto.getUpdatedDate());
            enterpriseRepository.save(enterprise);
        }else{
            throw new IllegalArgumentException("유저 없음");
        }



    }

}
