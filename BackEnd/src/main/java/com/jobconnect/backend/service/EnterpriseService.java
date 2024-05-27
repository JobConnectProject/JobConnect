package com.jobconnect.backend.service;

import com.jobconnect.backend.domain.Enterprise;
import com.jobconnect.backend.dto.EnterpriseSignupDto;
import com.jobconnect.backend.dto.EnterpriseUpdateDto;

import java.util.List;
import java.util.Optional;

public interface EnterpriseService {

    Enterprise createEnterprise(EnterpriseSignupDto dto);
    List<Enterprise> getAllEnterprises();
    Optional<Enterprise> getEnterpriseById(Long enId);
    void updateEnterprise(Long enId, EnterpriseUpdateDto dto);
    void deleteEnterprise(Long enId);
}
