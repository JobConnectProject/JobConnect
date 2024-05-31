package com.jobconnect.backend.repository;

import com.jobconnect.backend.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
