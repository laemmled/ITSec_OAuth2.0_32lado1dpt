package com.example.IT_Security_Keycloak;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ApiController {

    @GetMapping("/admin")
    public String adminResource(){
        return "Hello this is Admin!";
    }

    @GetMapping("/manager")
    public String managerResource(){
        return "Hello this is Manager!";
    }

    @GetMapping("/developer")
    public String developerResource(){
        return "Hello this is Developer!";
    }

    @GetMapping("/user")
    public String userResource(){
        return "Hello this is User!";
    }

    @GetMapping("/developerOnly")
    public String developerOnlyResource(){
        return "Hello this is Developer only!";
    }

    @GetMapping("/userOnly")
    public String userOnlyResource(){
        return "Hello this is User only!";
    }

}
