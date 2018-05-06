package com.zenzile.assassin.rest;

import com.zenzile.assassin.model.Member;
import com.zenzile.assassin.model.constants.UserType;
import com.zenzile.assassin.model.factory.MemberFactor;
import com.zenzile.assassin.repository.MemberRepository;
import com.zenzile.assassin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Member addMember(@RequestBody Member member) {

        return memberService.registerMember(member);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable<Member> findAllMembers() {

        return memberRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Member findById(@PathVariable("id") Long id) {
        return memberRepository.findById(id).get();
    }

    @RequestMapping(value = "/{type}/members", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Member> findById(@PathVariable("type") UserType type) {
        return memberService.findByUserType(type);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public Member updateMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }


    /**
     * test end point
     * add member to the database
     * */


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Member testAdd() {
        Member ember = new Member
                .MemberBuilder("Rick")
                .surname("Sanchez")
                .email("ricksanchez@gmail.com")
                .userType(UserType.CLIENT)
                .gender("Male")
                .build();

        Member newMember = MemberFactor.createMember(ember);

        memberRepository.deleteAll();
        return memberRepository.save(newMember);
    }

}
