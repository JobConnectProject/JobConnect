package com.jobconnect.backend.repository;

import com.jobconnect.backend.domain.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Enterprise,Integer> {
    boolean existsByEnEmail(String enEmail);
}
