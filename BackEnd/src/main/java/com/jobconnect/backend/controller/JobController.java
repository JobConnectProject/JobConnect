package com.jobconnect.backend.controller;



import com.jobconnect.backend.domain.Job;

import com.jobconnect.backend.dto.JobCreateDto;
import com.jobconnect.backend.dto.JobUpdateDto;
import com.jobconnect.backend.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs(){
        List<Job> jobList = jobService.getAllJobs();
        return ResponseEntity.ok(jobList);
    }

    @GetMapping("/{joNum}")
    public ResponseEntity<Optional<Job>> getJobById(@PathVariable Long joNum){
        Optional<Job> job = jobService.getJobById(joNum);
        return ResponseEntity.ok(job);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody JobCreateDto dto){
        jobService.createJob(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Job create success");
    }

    @PutMapping("/{joNum}")
    public ResponseEntity<String> updateJob(@PathVariable Long joNum, @RequestBody JobUpdateDto dto){
        jobService.updateJob(joNum,dto);
        return ResponseEntity.ok("update success");
    }

    @DeleteMapping("/{joNum}")
    public ResponseEntity<String> deleteJob(@PathVariable Long joNum){
        jobService.deletejob(joNum);
        return ResponseEntity.ok("delete success");
    }

}
