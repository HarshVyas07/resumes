package com.exam.examserver.Services;

import com.exam.examserver.Model.User;
import com.exam.examserver.Repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl  implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= this.userRepo.findByUsername(username);
        if(user==null)
        {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User Not FOund");
        }

        return user;
    }
    
}
