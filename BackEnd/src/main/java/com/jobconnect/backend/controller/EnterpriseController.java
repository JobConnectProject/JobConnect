package com.jobconnect.backend.controller;

import com.jobconnect.backend.domain.Enterprise;
import com.jobconnect.backend.dto.EnterpriseSignupDto;
import com.jobconnect.backend.service.EnterpriseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/enterprises")
public class EnterpriseController {

    private final EnterpriseService enterpriseService;


    @PostMapping("/signup")
    public ResponseEntity<String> signupEnterprise(@RequestBody EnterpriseSignupDto dto){
        enterpriseService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Enterprise signup success");
    }
}
