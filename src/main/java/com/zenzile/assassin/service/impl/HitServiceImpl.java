package com.zenzile.assassin.service.impl;

import com.zenzile.assassin.model.Hit;
import com.zenzile.assassin.model.Member;
import com.zenzile.assassin.model.factory.AdminFactory;
import com.zenzile.assassin.model.factory.HitFactory;
import com.zenzile.assassin.repository.AdminRepository;
import com.zenzile.assassin.repository.HitRepository;
import com.zenzile.assassin.repository.MemberRepository;
import com.zenzile.assassin.service.HitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HitServiceImpl implements HitService {
    @Autowired
    private HitRepository hitRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public boolean registerHit(Hit hit) {
        Long memberId = hit.getMember().getId();
        Long adminId = hit.getAdmin().getId();

        if (validateMember(memberId) && validateAdmin(adminId)) {
            if (checkMissingFields(hit)) {
                Hit newHit = HitFactory.createHit(hit);

                hitRepository.save(newHit);

                return true;
            }
        }
        return false;
    }

    private boolean validateAdmin(Long adminId) {
        boolean isAdmin = (adminRepository.findById(adminId).isPresent());

        return isAdmin;
    }

    private boolean validateMember(Long memberId) {
        boolean isMember = (memberRepository.findById(memberId).isPresent()) ? true: false;

        return isMember;
    }

    private boolean checkMissingFields(Hit hit) {
        boolean passeValidation = true;

        if (hit.getCodename() == null ||hit.getCodename().equals("") ||
                hit.getAddress() == null ||hit.getAddress().equals("") ||
                hit.getAmount() < 1.0 ||
                hit.getAdmin() == null ||
                hit.getMember().equals("")
                )
            passeValidation = false;

        return passeValidation;
    }
}
