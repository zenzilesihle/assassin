package com.zenzile.assassin.service.impl;

import com.zenzile.assassin.model.Admin;
import com.zenzile.assassin.model.Member;
import com.zenzile.assassin.model.constants.UserType;
import com.zenzile.assassin.model.factory.MemberFactor;
import com.zenzile.assassin.repository.MemberRepository;
import com.zenzile.assassin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member registerMember(Member member) {
        Member newMember = MemberFactor.createMember(member);

        if (checkMissingFields(member)) {
            memberRepository.save(newMember);
            return memberRepository.findById(newMember.getId()).get();
        } else
            return null;
    }

    @Override
    public Member findByEmail(String email) {
        if (null == email || email.equals(""))
            return null;
        else {
            List<Member> members = memberRepository.findMemberByEmail(email);
            return members.get(0);
        }
    }

    @Override
    public List<Member> findByUserType(UserType userType) {
        if (null == userType || userType.equals(""))
            return null;
        else {
            List<Member> members = memberRepository.findMemberByUserType(userType);
            return members;
        }
    }

    private boolean checkMissingFields(Member member) {
        boolean passeValidation = true;

        if (member.getEmail() == null || member.getEmail().equals("") ||
                member.getGender() == null || member.getGender().equals("") ||
                member.getSurname() == null || member.getSurname().equals("") ||
                member.getName() == null || member.getName().equals("") ||
                member.getUserType() == null || member.getUserType().equals("")
                )
            passeValidation = false;

        return passeValidation;
    }
}
