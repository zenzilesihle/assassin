package com.zenzile.assassin.rest;

import com.zenzile.assassin.model.Admin;
import com.zenzile.assassin.repository.AdminRepository;
import com.zenzile.assassin.service.AdminService;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    @ResponseBody
    public Admin addAdmin(@RequestBody Admin admin){
        Preconditions.checkNotNull( admin );

        //need to handle null
        return adminService.registerAdmin(admin);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Admin> findAll(){
        Iterable<Admin> admins = adminRepository.findAll();
        List<Admin> adminList = new ArrayList<>();

        while(admins.iterator().hasNext()) {
            adminList.add(admins.iterator().next());
        }

        return adminList;
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Admin findByEmail(@PathVariable( "id" ) String email){

        return adminService.findByEmail(email);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PUT )
    @ResponseStatus(HttpStatus.OK)
    public void update( @PathVariable( "id" ) Long id, @RequestBody Admin admin ){
        Preconditions.checkNotNull(admin);
        Preconditions.checkNotNull(adminRepository.findById(admin.getId()));
        adminService.updateAdmin(admin);
    }
}
