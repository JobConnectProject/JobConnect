package com.jobconnect.backend.controller;

import com.jobconnect.backend.domain.Member;
import com.jobconnect.backend.dto.MemberSignupDTO;
import com.jobconnect.backend.dto.MemberUpdateDTO;
import com.jobconnect.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody MemberSignupDTO memberDTO) {
        Member member = memberService.saveMember(memberDTO);

        return ResponseEntity.ok(member);
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();

        return ResponseEntity.ok(members);
    }

    @GetMapping("/{meId}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long meId) {
        Optional<Member> member = memberService.getMemberById(meId);

        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{meId}")
    public ResponseEntity<String> updateMember(@PathVariable Long meId, @RequestBody MemberUpdateDTO memberDTO) {
        memberService.updateMember(meId, memberDTO);

        return ResponseEntity.ok("Update Success");
    }

    @DeleteMapping("/{meId}")
    public ResponseEntity<String> deleteMemberById(@PathVariable Long meId) {
        memberService.deleteMember(meId);

        return ResponseEntity.ok("Delete Success");
    }
}
