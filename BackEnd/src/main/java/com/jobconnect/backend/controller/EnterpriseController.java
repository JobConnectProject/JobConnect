package com.jobconnect.backend.controller;

import com.jobconnect.backend.domain.Enterprise;
import com.jobconnect.backend.dto.EnterpriseSignupDto;
import com.jobconnect.backend.dto.EnterpriseUpdateDto;
import com.jobconnect.backend.service.EnterpriseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/enterprises")
public class EnterpriseController {

    private final EnterpriseService enterpriseService;


    @PostMapping("/signup")
    public ResponseEntity<String> signupEnterprise(@RequestBody EnterpriseSignupDto dto){
        enterpriseService.createEnterprise(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Enterprise signup success");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Enterprise>> showEnterprise(){
        List<Enterprise> enterpriseList = enterpriseService.getEnterpriseList();
        return ResponseEntity.ok(enterpriseList);
    }

    @PutMapping("/{enId}")
    public ResponseEntity<String> updateEnterprise(@PathVariable Long enId, @RequestBody EnterpriseUpdateDto dto){
        enterpriseService.updateEnterprise(enId,dto);
        return ResponseEntity.ok("update success");
    }

}
