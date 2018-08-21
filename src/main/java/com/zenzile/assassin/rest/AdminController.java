package com.zenzile.assassin.rest;

import com.zenzile.assassin.model.Admin;
import com.zenzile.assassin.model.factory.AdminFactory;
import com.zenzile.assassin.repository.AdminRepository;
import com.zenzile.assassin.service.AdminService;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus( HttpStatus.CREATED )
    @ResponseBody
    public Admin addAdmin(@RequestBody Admin admin) {
        Preconditions.checkNotNull(admin);
        return adminService.registerAdmin(admin);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus( HttpStatus.OK )
    @ResponseBody
    public Iterable<Admin> findAll(){
        Iterable<Admin> admins = adminRepository.findAll();

        return admins;
    }

    @RequestMapping( value = "/{id}/admin", method = RequestMethod.GET )
    @ResponseStatus( HttpStatus.OK )
    @ResponseBody
    public Admin findById(@PathVariable Long id  ) {
        Preconditions.checkNotNull(adminRepository.findById(id));

        return adminRepository.findById(id).get();
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    @ResponseBody
    public Admin findByEmail(@PathVariable( "email" ) String email){

        /***REVISIT
         * it doesn't find email any record, test pass though
         * */

        if(adminRepository.findAdminByEmail(email) != null)
            return adminRepository.findAdminByEmail(email).get(0);
        else {
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED )
    public Admin update(@RequestBody Admin admin ){
        Preconditions.checkNotNull(admin);
        Preconditions.checkNotNull(adminRepository.findById(admin.getId()));

        return adminService.updateAdmin(admin);
    }

    /****
     * test endpoint
     * it add one record to the database AND
     * return it to the bodyResponse
     * */

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    @ResponseBody
    public Admin admin(){
        Admin testAdmin = new Admin
                .AdminBuilder("Mbali")
                .surname("Mbali")
                .email("mbali@gmail.com")
                .password("mbali123")
                .build();

        Admin newAdmin = AdminFactory.createAdmin(testAdmin);

        adminRepository.deleteAll();

        return adminRepository.save(newAdmin);
    }
}
