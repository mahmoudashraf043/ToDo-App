package com.mahmoud.To_Do.Controller;

import com.mahmoud.To_Do.Dto.ChangePasswordDto;
import com.mahmoud.To_Do.Entities.User;
import com.mahmoud.To_Do.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getUser(){
        return new ResponseEntity<>(userService.getUser() , HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user) , HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) throws Exception {
        return new ResponseEntity<>(userService.deleteUser(username) , HttpStatus.OK);
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) throws Exception {
        return new ResponseEntity<>(userService.changePassword(changePasswordDto) , HttpStatus.OK);

    }


}
