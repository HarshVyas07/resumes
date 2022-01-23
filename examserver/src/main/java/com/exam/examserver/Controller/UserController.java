package com.exam.examserver.Controller;

import java.util.HashSet;
import java.util.Set;

import com.exam.examserver.Model.Role;
import com.exam.examserver.Model.User;
import com.exam.examserver.Model.UserRole;
import com.exam.examserver.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    // create user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception{
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRole> roles= new HashSet<>();
        
        Role role= new Role();
        role.setRoleId(46L);
        role.setRoleName("Normal");

        UserRole ur= new UserRole();
        ur.setRole(role);
        ur.setUser(user);

        roles.add(ur);
        return this.userService.createUser(user, roles);
    }
}
