package com.mahmoud.To_Do.Security;

import com.mahmoud.To_Do.Entities.User;
import com.mahmoud.To_Do.Repository.UserRepo;
import com.mahmoud.To_Do.Service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetail implements UserDetailsService {

    private final UserRepo userRepo;

    public CustomUserDetail(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);

        if(user.isEmpty()){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return user.get();
    }
}
