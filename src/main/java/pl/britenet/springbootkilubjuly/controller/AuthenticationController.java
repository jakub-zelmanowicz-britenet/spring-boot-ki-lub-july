package pl.britenet.springbootkilubjuly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.springbootkilubjuly.model.UserCredentials;
import pl.britenet.springbootkilubjuly.model.UserLoginData;
import pl.britenet.springbootkilubjuly.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public UserLoginData login(@RequestBody UserCredentials userCredentials) {
        return this.authenticationService.login(userCredentials);
    }

    @GetMapping("/{userToken}")
    public boolean isLogged(@PathVariable String userToken) {
        return this.authenticationService.isLogged(userToken);
    }
}
