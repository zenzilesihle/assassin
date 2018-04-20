package com.zenzile.assassin.repository;

import com.zenzile.assassin.AssassinApplicationTests;
import com.zenzile.assassin.model.Admin;
import com.zenzile.assassin.model.factory.AdminFactory;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminRepositoryTest extends AssassinApplicationTests {
    @Autowired
    private AdminRepository adminRepository;

    private Admin admin;

    @Test
    public void test1Save() {
        admin = new Admin
                .AdminBuilder("Tiger")
                .surname("Woods")
                .email("tigerwoods@yahoo.com")
                .password("WOODS-T")
                .build();

        Admin newAdmin = AdminFactory.createAdmin(admin);

        adminRepository.save(newAdmin);
        Assert.assertTrue("Admin No Saved", adminRepository.count() > 0);

        Optional<Admin> savedAdmin = adminRepository.findById(newAdmin.getId());

        /** compare before saved and after saved*/
        Assert.assertEquals("Password Do Not Match", newAdmin.getPassword(), savedAdmin.get().getPassword());
        Assert.assertEquals("Surname Do Not Match", newAdmin.getSurname(), savedAdmin.get().getSurname());
        Assert.assertEquals("Name Do Not Match", newAdmin.getName(), savedAdmin.get().getName());
        Assert.assertEquals("Email Do Not Match", newAdmin.getEmail(), savedAdmin.get().getEmail());
        Assert.assertEquals("ID Do Not Match", newAdmin.getId(), savedAdmin.get().getId());
    }

    @Test
    public void test2FindAll() {
        Iterable<Admin> admins = adminRepository.findAll();
        Assert.assertTrue("No Admins Exists", admins.iterator().hasNext());

        Admin selectOne = admins.iterator().next();
        Assert.assertNotNull(selectOne);
    }

    @Test
    public void test3FindOneById() {
        Iterable<Admin> admins = adminRepository.findAll();
        Admin selectOne = admins.iterator().next();
        Assert.assertNotNull(selectOne);

        Long id = selectOne.getId();

        Optional<Admin> searchAdmin = adminRepository.findById(id);

        Assert.assertNotNull("Search By Id Failed", searchAdmin);
    }

    @Test
    public void test4FindByEmail() {
        List<Admin> emailAdmin = adminRepository.findAdminByEmail("tigerwoods@yahoo.com");
        List<Admin> wrongEmail = adminRepository.findAdminByEmail("WrongEmail@yahoo.c");

        Assert.assertNotNull(emailAdmin);
        Assert.assertNotNull(emailAdmin.size() == 1);
        Assert.assertTrue(wrongEmail.size() == 0);

        Assert.assertEquals("Emails Don't Match", "tigerwoods@yahoo.com", emailAdmin.get(0).getEmail());
    }

    @Test
    public void test5Delete() {
        Iterable<Admin> admins = adminRepository.findAll();
        Assert.assertTrue(admins.iterator().hasNext());

        adminRepository.deleteAll(admins);

        Iterable<Admin> adminsAfterDelete = adminRepository.findAll();

        List<Admin> deleted = new ArrayList<>();

        if (adminsAfterDelete.iterator().hasNext())
            deleted.add(adminsAfterDelete.iterator().next());

        Assert.assertTrue("Delete All admin Fail",deleted.size() == 0);
    }

    @After
    public void cleanUp(){

    }

    @Before
    public void setUp() {

    }
}
