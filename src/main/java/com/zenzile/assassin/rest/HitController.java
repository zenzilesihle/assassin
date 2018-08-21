package com.zenzile.assassin.rest;

import com.zenzile.assassin.model.Admin;
import com.zenzile.assassin.model.Hit;
import com.zenzile.assassin.model.Member;
import com.zenzile.assassin.model.constants.UserType;
import com.zenzile.assassin.model.factory.AdminFactory;
import com.zenzile.assassin.model.factory.HitFactory;
import com.zenzile.assassin.model.factory.MemberFactor;
import com.zenzile.assassin.repository.AdminRepository;
import com.zenzile.assassin.repository.HitRepository;
import com.zenzile.assassin.repository.MemberRepository;
import com.zenzile.assassin.service.HitService;
import com.zenzile.assassin.service.AdminService;
import com.zenzile.assassin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/hit")
public class HitController {
    @Autowired
    private HitRepository hitRepository;
    @Autowired
    private HitService hitService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberService memberService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRepository adminRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void addHit(@RequestBody Hit hit) {
        Optional<Member> member = memberRepository.findById(hit.getMember().getId());
        Optional<Admin> admin = adminRepository.findById(hit.getAdmin().getId());

        if (member.isPresent() || admin.isPresent())
            hitService.registerHit(hit);
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Hit test() {
        Admin admin = admin();
        Member member = member();

        Hit hit = new Hit
                .HitBuilder("Catalogue")
                .amount(300000.00)
                .address("34 Freddy Ave, Centane")
                .member(member)
                .admin(admin)
                .build();

        Hit newHit = HitFactory.createHit(hit);

        hitRepository.deleteAll();
        hitService.registerHit(newHit);

        return newHit;
    }

    private Admin admin() {
        Admin testAdmin = new Admin
                .AdminBuilder("Peter")
                .surname("Griffith")
                .email("peter@gmail.com")
                .password("peterer666")
                .build();

        Admin newAdmin = AdminFactory.createAdmin(testAdmin);

        adminRepository.deleteAll();

        return adminRepository.save(newAdmin);
    }

    private Member member() {
        Member ember = new Member
                .MemberBuilder("Morty")
                .surname("Smith")
                .email("morty@gmail.com")
                .userType(UserType.TARGET)
                .gender("Male")
                .build();

        Member newMember = MemberFactor.createMember(ember);

        memberRepository.deleteAll();

        return memberRepository.save(newMember);

//        {
//            "id":null,
//                "amount":300000.0,
//                "address":"34 Freddy Ave, Centane",
//                "codename":"Catalogue",
//                "targetStatus":"ALIVE",
//            "member":{"id":2,
//                "name":"Morty",
//                "surname":"Smith",
//                "gender":"Male",
//                "email":"morty@gmail.com",
//                "registrationDate":"2018-04-27T21:26:13.497+0000",
//                "userType":"TARGET"},
//            "admin":{"id":1,"name":"Peter",
//                "surname":"Griffith",
//                "password":"peterer666",
//                "email":"peter@gmail.com"}
//        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void deleteHit(@PathVariable Long id ) {
        Optional<Hit> hitToDelete = hitRepository.findById(id);

        if( hitToDelete.isPresent())
            hitRepository.deleteById(hitToDelete.get().getId());
        return;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateHit(@RequestBody Hit hit) {
        Optional<Hit> hitToUpdate = hitRepository.findById(hit.getId());

        if(hitToUpdate.isPresent())
            hitRepository.save(hit);
    }
}
