package org.back.school.controller;
import org.back.school.model.Login;
import org.back.school.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Login login){
        Boolean authenticated = loginService.checkCredentials(login);
        return new ResponseEntity<>(authenticated, HttpStatus.OK);
    }
}
