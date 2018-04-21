package com.zenzile.assassin.model.factory;

import com.zenzile.assassin.model.Member;
import com.zenzile.assassin.model.constants.UserType;

import java.util.Date;


public class MemberFactor {
    public static Member createMember(Member newMember) {

        return new Member
                .MemberBuilder(newMember.getName())
                .surname(newMember.getSurname())
                .email(newMember.getEmail())
                .gender(newMember.getGender())
                .registrationDate(new Date())
                .userType(newMember.getUserType())
                .id(newMember.getId())
                .build();
    }
}
