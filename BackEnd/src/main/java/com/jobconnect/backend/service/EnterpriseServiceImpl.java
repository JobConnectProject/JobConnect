package com.jobconnect.backend.service;


import com.jobconnect.backend.domain.Enterprise;
import com.jobconnect.backend.dto.enterprise.EnterpriseSignupDto;
import com.jobconnect.backend.dto.enterprise.EnterpriseUpdateDto;
import com.jobconnect.backend.repository.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    @Override
    public Enterprise createEnterprise(EnterpriseSignupDto dto) {
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
                .build();

                enterpriseRepository.save(enterprise);

                return enterprise;
    }

    @Override
    public Optional<Enterprise> getEnterpriseById(Long enId){
       return enterpriseRepository.findById(enId);
    }

    @Override
    public List<Enterprise> getAllEnterprises() {
        return  enterpriseRepository.findAll();
    }

    @Override
    public void updateEnterprise(Long enId, EnterpriseUpdateDto dto){
        Optional<Enterprise> optionalEnterprise = enterpriseRepository.findById(enId);
        if(optionalEnterprise.isPresent()){
            Enterprise enterprise = optionalEnterprise.get();
            enterprise.updateEnterprise(dto.getEnPw(),dto.getEnRep(),dto.getEnPhone());
            enterpriseRepository.save(enterprise);
        }else{
            throw new IllegalArgumentException("유저 없음");
        }
    }

    @Override
    public void deleteEnterprise(Long enId){
        enterpriseRepository.deleteById(enId);
    }

}
