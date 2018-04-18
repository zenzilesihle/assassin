package com.zenzile.assassin.repository;

import com.zenzile.assassin.model.Admin;
import com.zenzile.assassin.model.factory.AdminFactory;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminRepositoryTest {
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
    public void test4Delete() {
        Iterable<Admin> admins = adminRepository.findAll();
        Assert.assertTrue(admins.iterator().hasNext());

        adminRepository.deleteById(admins.iterator().next().getId());

        Iterable<Admin> adminsAfterDelete = adminRepository.findAll();
        Assert.assertFalse(adminsAfterDelete.iterator().hasNext());
    }

    @After
    public void cleanUp(){

    }

    @Before
    public void setUp() {

    }
}
