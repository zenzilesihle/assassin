package com.zenzile.assassin.model.factory;

import com.zenzile.assassin.model.Member;
import com.zenzile.assassin.model.constants.UserType;

import java.util.Date;


public class MemberFactor {
    public static Member createMember(Member newMember) {
        Member factoryMember = new Member();

        factoryMember.setId(newMember.getId());
        factoryMember.setUserType(UserType.MEMBER);
        factoryMember.setName(newMember.getName());
        factoryMember.setSurname(newMember.getSurname());
        factoryMember.setGender(newMember.getGender());
        factoryMember.setEmail(newMember.getEmail());
        factoryMember.setRegistrationDate(new Date());

        return factoryMember;
    }
}
