package com.jobconnect.backend.repository;

import com.jobconnect.backend.domain.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnterpriseRepository extends JpaRepository<Enterprise,Long> {
    boolean existsByEnEmail(String enEmail);

    Optional<Enterprise> findByEnEmail(String enEmail);
}
