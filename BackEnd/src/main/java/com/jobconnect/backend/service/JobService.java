package com.jobconnect.backend.service;



import com.jobconnect.backend.domain.Job;
import com.jobconnect.backend.dto.JobCreateDto;
import com.jobconnect.backend.dto.JobUpdateDto;

import java.util.List;
import java.util.Optional;

public interface JobService {

    Job createJob(JobCreateDto dto);
    List<Job> getAllJobs();
    Optional<Job> getJobById(Long joNum);
    void updateJob(Long joNum, JobUpdateDto dto);
    void deletejob(Long joNum);



}
