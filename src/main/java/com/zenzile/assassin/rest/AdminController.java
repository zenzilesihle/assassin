package com.zenzile.assassin.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String viewAdmin() {
        System.out.println("IT CAME HERE");
        return "Assassin Is Up And Running";
    }
}
