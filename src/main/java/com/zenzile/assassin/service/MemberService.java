package com.zenzile.assassin.service;

import com.zenzile.assassin.model.Member;
import com.zenzile.assassin.model.constants.UserType;

import java.util.List;

public interface MemberService {
    Member registerMember(Member member);
    Member findByEmail(String email);
    List<Member> findByUserType(UserType userType);
}
