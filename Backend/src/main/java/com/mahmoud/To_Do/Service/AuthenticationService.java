package com.mahmoud.To_Do.Service;

import com.mahmoud.To_Do.Dto.LoginRequest;
import com.mahmoud.To_Do.Dto.LoginResponse;
import com.mahmoud.To_Do.Entities.User;
import com.mahmoud.To_Do.Repository.UserRepo;
import com.mahmoud.To_Do.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest loginRequest) throws Exception {
        User user = userRepo.findByUsername(loginRequest.getUsername()).orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
        if(!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
            throw new Exception("Wrong password");
        }
    return jwtUtil.generateToken(user);
    }


    public User register(User user) throws Exception {

        try {
            if(userRepo.findByUsername(user.getUsername()).isPresent()){
                throw new Exception("Username is already in use");
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Something Went Wrong please try again");
        }
        return user;
    }
}
