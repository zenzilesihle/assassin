package com.zenzile.assassin.service;

import com.zenzile.assassin.AssassinApplicationTests;
import com.zenzile.assassin.model.Admin;
import com.zenzile.assassin.repository.AdminRepository;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminServiceTest extends AssassinApplicationTests {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void test1Register() {
        Admin admin = new Admin.AdminBuilder("Sachin")
                .surname("Tendukar")
                .email("sachin@gmail.com")
                .password("sachin12345")
                .build();

        Admin savedAdmin = adminService.registerAdmin(admin);

        Assert.assertNotNull("Admin Object Is Null", savedAdmin);
        Assert.assertEquals("Emails Are Different", admin.getEmail(), savedAdmin.getEmail());
        Assert.assertEquals("Surname Are Different", admin.getSurname(), savedAdmin.getSurname());
        Assert.assertEquals("Name Are Different", admin.getName(), savedAdmin.getName());
    }

    @Test
    public void test2FindByEmail() {
        Iterable<Admin> admins = adminRepository.findAll();
        Admin selectOne = admins.iterator().next();

        String email = adminRepository.findById(selectOne.getId()).get().getEmail();
        Assert.assertNotNull(email);

        Admin emailAdmin = adminService.findByEmail(email);
        Assert.assertNotNull(emailAdmin);
        Assert.assertEquals("sachin@gmail.com", emailAdmin.getEmail());
    }

    @Test
    public void test3Update() {


        Iterable<Admin> admins = adminRepository.findAll();
        Admin selectOne = admins.iterator().next();

        Admin updateAdmin = new Admin
                .AdminBuilder(selectOne.getName())
                .copy(selectOne)
                .surname("Dhoni")
//                .password("XXXXX")
                .build();

        Admin newUpdated = adminService.updateAdmin(updateAdmin);

        System.out.println("NEW PASSWORD: "+newUpdated.getPassword());
        Assert.assertNotNull(newUpdated);
        Assert.assertEquals("ID Not The Same", selectOne.getId(), newUpdated.getId());
        Assert.assertNotEquals("Surname Still Same", selectOne.getSurname(), newUpdated.getSurname());
    }

    @Test
    public void test4Delete(){
        adminRepository.deleteAll();

        Assert.assertFalse(adminRepository.findAll().iterator().hasNext());
    }

    @After
    public void cleanUp(){

    }

    @Before
    public void setUp() {

    }
}
