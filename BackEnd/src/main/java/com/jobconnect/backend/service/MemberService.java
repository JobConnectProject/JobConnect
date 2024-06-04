package com.jobconnect.backend.service;

import com.jobconnect.backend.domain.Member;
import com.jobconnect.backend.dto.MemberSignupDTO;
import com.jobconnect.backend.dto.MemberUpdateDTO;
import com.jobconnect.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member saveMember(MemberSignupDTO memberDTO) {

        Member member = Member.builder()
                .meEmail(memberDTO.getMeEmail())
                .mePw(memberDTO.getMePw())
                .meName(memberDTO.getMeName())
                .meBirth(memberDTO.getMeBirth())
                .meGender(memberDTO.getMeGender())
                .mePhone(memberDTO.getMePhone())
                .meAuthority(0)
                .meCreateAt(LocalDate.now())
                .meUpdateAt(LocalDate.now())
                .mePwUpdateAt(LocalDate.now())
                .build();

        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {

        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {

        return memberRepository.findById(id);
    }

    public Member updateMember(Long meId, MemberUpdateDTO dto) {
        Optional<Member> optionalMember = memberRepository.findById(meId);
        if(optionalMember.isPresent()) {
            Member member = optionalMember.get();
            member.updateMember(dto.getMePw(), dto.getMePhone());

            return memberRepository.save(member);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    public void deleteMember(Long id) {

        memberRepository.deleteById(id);
    }
}
