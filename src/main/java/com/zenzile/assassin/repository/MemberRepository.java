package com.zenzile.assassin.repository;

import com.zenzile.assassin.model.Member;
import com.zenzile.assassin.model.constants.UserType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    @Query(value = "SELECT * FROM members WHERE email = ?1", nativeQuery = true)
    List<Member> findMemberByEmail(String email);

    @Query(value = "SELECT * FROM members WHERE userType = ?1", nativeQuery = true)
    List<Member> findMemberByUserType(UserType userType);

}
