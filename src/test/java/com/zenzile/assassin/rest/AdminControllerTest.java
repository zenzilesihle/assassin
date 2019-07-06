package com.zenzile.assassin.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zenzile.assassin.AssassinApplicationTests;
import com.zenzile.assassin.model.Admin;
import com.zenzile.assassin.model.factory.AdminFactory;
import com.zenzile.assassin.repository.AdminRepository;
import com.zenzile.assassin.service.AdminService;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminControllerTest extends AssassinApplicationTests {
        /**
         * All the unit tests run in isolation
         * a change in one unit test does not affect another
         * for an example,
         *      if i'm testing read;
         *      I start with create
         *      or I'm doing delete,
         *      I start with add -> find -> delete
         * */
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;

    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mockMvc;
    ObjectMapper objectMapper;

    @Before
    @Test
    public void setUp() throws Exception {

        Assert.assertNotNull(applicationContext);

        objectMapper = new ObjectMapper();
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(applicationContext)
                .build();

        /**
         * run test endpoint
         * add admin to the database
         * want to check if database setup
         * */
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/test"))
                .andExpect((status().is(200)))
                .andExpect(jsonPath("email", is("mbali@gmail.com")));

        /**
         * delete all admins on the
         * database before run actually tests
         * */
        adminRepository.deleteAll();

    }

    @Test
    public void test1Add() throws Exception{
        Admin admin = new Admin
                .AdminBuilder("Kendrick")
                .surname("Lamar")
                .email("kendrick@yahoo.com")
                .password("k.dot-lamar")
                .build();

        Admin newAdmin = AdminFactory.createAdmin(admin);

        String mappedAdmin = objectMapper.writeValueAsString(newAdmin);

        mockMvc.perform(MockMvcRequestBuilders.post("/admin")
                .content(mappedAdmin)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("surname", is("Lamar")))
                .andExpect(jsonPath("email", is("kendrick@yahoo.com")))
                .andExpect(jsonPath("name", is("Kendrick")))
                .andExpect((status().is(201)));
    }

    @Test
    public void test2findAll() throws Exception {
        Admin admin = new Admin
                .AdminBuilder("Amanda")
                .surname("Klass")
                .email("amanda@gmail.com")
                .password("amanda0000")
                .build();
        Admin newAdmin = AdminFactory.createAdmin(admin);
        Assert.assertNotNull(adminService.registerAdmin(newAdmin));

        mockMvc.perform(MockMvcRequestBuilders.get("/admin"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void test3FindById() throws Exception {
        Admin admin = new Admin
                .AdminBuilder("Sive")
                .surname("Maka")
                .email("sive@gmail.com")
                .password("sivemaka")
                .build();
        Admin newAdmin = AdminFactory.createAdmin(admin);
        Assert.assertNotNull(adminService.registerAdmin(newAdmin));

        Long adminId = adminRepository.findAll().iterator().next().getId();
        Assert.assertNotNull("Failed to retrieve ID", adminId);

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/"+adminId+"/admin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("surname", is("Maka")))
                .andExpect(jsonPath("email", is("sive@gmail.com")))
                .andExpect(status().isOk());
    }

    @Test
    public void test4FindByEmail() throws Exception {
        Admin admin = new Admin
                .AdminBuilder("Anyrose")
                .surname("Apleni")
                .email("anyrose@gmail.com")
                .password("123453")
                .build();

        Admin newAdmin = AdminFactory.createAdmin(admin);
        Assert.assertNotNull(adminService.registerAdmin(newAdmin));

        String adminEmail = adminRepository.findAll().iterator().next().getEmail();
        Assert.assertNotNull("Failed to retrieve Email", adminEmail);

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/"+adminEmail))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is("Anyrose")))
                .andExpect(jsonPath("email", is("anyrose@gmail.com")));
    }

    @Test
    public void test5Update() throws Exception {
        Admin admin = new Admin
                .AdminBuilder("Athini")
                .surname("Ngami")
                .email("ngami@gmail.com")
                .password("1111111")
                .build();

        Admin newAdmin = AdminFactory.createAdmin(admin);
        Assert.assertNotNull(adminService.registerAdmin(newAdmin));

        Admin adminEmail = adminRepository.findAll().iterator().next();
        Assert.assertNotNull("Failed to retrieve admin", adminEmail);

        //change password
        Admin updated = new Admin.AdminBuilder(adminEmail.getName())
                .copy(adminEmail)
                .password("XXXXX")
                .build();

        String mappedAdmin = objectMapper.writeValueAsString(updated);

        mockMvc.perform(MockMvcRequestBuilders.put("/admin")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mappedAdmin))
                .andExpect(status().is(202))
                .andExpect(jsonPath("surname", is("Ngami")));
    }

    @Test
    public void test6FailAdd() throws Exception {
        /**add duplicate emails*/
        Admin admin1 = new Admin
                .AdminBuilder("Kendrick")
                .surname("Lamar")
                .email("kendrick@yahoo.com")
                .password("k.dot-lamar")
                .build();

        Admin admin2 = new Admin
                .AdminBuilder("Lucas")
                .surname("Mora")
                .email("kendrick@yahoo.com")
                .password("lukadavid")
                .build();

        Admin newAdmin1 = AdminFactory.createAdmin(admin1);
        Admin newAdmin2 = AdminFactory.createAdmin(admin2);

        String mappedAdmin1 = objectMapper.writeValueAsString(newAdmin1);
        String mappedAdmin2 = objectMapper.writeValueAsString(newAdmin2);

        mockMvc.perform(MockMvcRequestBuilders.post("/admin")
                .content(mappedAdmin1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect((status().is(201)));

        mockMvc.perform(MockMvcRequestBuilders.post("/admin")
                .content(mappedAdmin2)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect((status().is(201)));

        mockMvc.perform(MockMvcRequestBuilders.get("/admin"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect((status().is(200)));

        Admin adminEmail = adminRepository.findAll().iterator().next();
        Assert.assertEquals("kendrick@yahoo.com", adminEmail.getEmail());
        Assert.assertEquals("Lamar", adminEmail.getSurname());
        Assert.assertEquals("Kendrick", adminEmail.getName());

        Assert.assertNotEquals("Mora", adminEmail.getSurname());
        Assert.assertNotEquals("Lucas", adminEmail.getName());
    }

    @After
    public void cleanUp() {
//        adminRepository.deleteAll();

    }
}