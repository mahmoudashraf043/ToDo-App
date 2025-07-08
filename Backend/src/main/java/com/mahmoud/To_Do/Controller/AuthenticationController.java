package com.mahmoud.To_Do.Controller;

import com.mahmoud.To_Do.Dto.LoginRequest;
import com.mahmoud.To_Do.Dto.LoginResponse;
import com.mahmoud.To_Do.Entities.User;
import com.mahmoud.To_Do.Security.JwtUtil;
import com.mahmoud.To_Do.Service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationService  authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid@RequestBody LoginRequest loginRequest) throws Exception {
        return new ResponseEntity<>(authenticationService.login(loginRequest), HttpStatus.OK);

    }

    @PostMapping("/Register")
    public ResponseEntity<?> register(@Valid @RequestBody User user) throws Exception {
        return new ResponseEntity<>(authenticationService.register(user) , HttpStatus.OK);
    }
}
