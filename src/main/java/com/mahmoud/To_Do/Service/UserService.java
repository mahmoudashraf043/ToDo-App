package com.mahmoud.To_Do.Service;

import com.mahmoud.To_Do.Dto.ChangePasswordDto;
import com.mahmoud.To_Do.Entities.User;
import com.mahmoud.To_Do.Repository.UserRepo;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final ServletContext servletContext;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public User getUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User temp = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        temp.setPassword("");
        return temp;
    }

    public String updateUser(User user) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User temp = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));;
        temp.setFirstName(user.getFirstName());
        temp.setLastName(user.getLastName());
        temp.setEmail(user.getEmail());
        userRepo.save(temp);
        return "update has been done";
    }

    public String deleteUser(String username) throws Exception {
        try {
        String temp = SecurityContextHolder.getContext().getAuthentication().getName();
        if(temp.equals(username)) {
            userRepo.delete(userRepo.findByUsername(username).orElseThrow());
        }
        return "delete has been done";
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Something went wrong please try again");
        }
    }

    public String changePassword(ChangePasswordDto changePasswordDto)throws Exception {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            User temp = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            if (!passwordEncoder.matches(changePasswordDto.getOldPassword(), temp.getPassword())) {
                throw new IllegalArgumentException("Old password does not match");
            }
            temp.setPassword(passwordEncoder.encode(changePasswordDto.getNewPassword()));
            userRepo.save(temp);
            return "change password has been done";
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Something went wrong please try again");
        }
    }
}
