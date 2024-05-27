package com.jobconnect.backend.controller;

import com.jobconnect.backend.domain.Enterprise;
import com.jobconnect.backend.dto.EnterpriseSignupDto;
import com.jobconnect.backend.dto.EnterpriseUpdateDto;
import com.jobconnect.backend.service.EnterpriseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/enterprises")
public class EnterpriseController {

    private final EnterpriseServiceImpl enterpriseService;


    @PostMapping("/signup")
    public ResponseEntity<String> signupEnterprise(@RequestBody EnterpriseSignupDto dto){
        enterpriseService.createEnterprise(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Enterprise signup success");
    }

    @GetMapping("/{enId}")
    public ResponseEntity<Optional<Enterprise>> getEnterpriseById(@PathVariable Long enId){
       Optional<Enterprise> enterprise =  enterpriseService.getEnterpriseById(enId);
       return ResponseEntity.ok(enterprise);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Enterprise>> getAllEnterprises(){
        List<Enterprise> enterpriseList = enterpriseService.getAllEnterprises();
        return ResponseEntity.ok(enterpriseList);
    }

    @PutMapping("/{enId}")
    public ResponseEntity<String> updateEnterprise(@PathVariable Long enId, @RequestBody EnterpriseUpdateDto dto){
        enterpriseService.updateEnterprise(enId,dto);
        return ResponseEntity.ok("update success");
    }

    @DeleteMapping("/{enId}")
    public void deleteEnterprise(@PathVariable Long enId){
        enterpriseService.deleteEnterprise(enId);
    }

}