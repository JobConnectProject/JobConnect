package com.jobconnect.backend.service;


import com.jobconnect.backend.domain.Job;
import com.jobconnect.backend.dto.JobCreateDto;
import com.jobconnect.backend.dto.JobUpdateDto;
import com.jobconnect.backend.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class JobServiceImpl implements JobService{

    private JobRepository jobRepository;
    @Override
    public Job createJob(JobCreateDto dto) {
        Job job = Job.builder()
                .joName(dto.getJoName())
                .joTitle(dto.getJoTitle())
                .joGender(dto.getJoGender())
                .joAge(dto.getJoAge())
                .joEdu(dto.getJoEdu())
                .joType(dto.getJoType())
                .joCount(dto.getJoCount())
                .joPay(dto.getJoPay())
                .joWeek(dto.getJoWeek())
                .joTime(dto.getJoTime())
                .joAreaDetail(dto.getJoAreaDetail())
                .joSubway(dto.getJoSubway())
                .joUniversity(dto.getJoUniversity())
                .joContent(dto.getJoContent())
                .joViews(dto.getJoViews())
                .joDel(dto.getJoDel())
                .joSecret(dto.getJoSecret())
                .joDeadDate(dto.getJoDeadDate())
                .joEndDate(dto.getJoEndDate())
                .build();

        jobRepository.save(job);
        return job;
    }

    @Override
    public Optional<Job> getJobById(Long joNum) {
        return jobRepository.findById(joNum);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void updateJob(Long joNum, JobUpdateDto dto) {
        Optional<Job> optionalJob = jobRepository.findById(joNum);
        if (optionalJob.isPresent()){
            Job job = optionalJob.get();
            job.updateJob(dto.getJoTitle(),dto.getJoGender(),dto.getJoAge(),
                    dto.getJoEdu(),dto.getJoType(),dto.getJoCount(),dto.getJoPay(),
                    dto.getJoWeek(),dto.getJoTime(),dto.getJoAreaDetail(),dto.getJoSubway(),
                    dto.getJoUniversity(),dto.getJoContent(),dto.getJoViews(),dto.getJoDel(),
                    dto.getJoSecret(),dto.getJoDeadDate(),dto.getJoEndDate());

            jobRepository.save(job);
        }else{
            throw new IllegalArgumentException("게시물 없음");
        }
    }

    @Override
    public void deletejob(Long joNum) {
        jobRepository.deleteById(joNum);
    }
}
