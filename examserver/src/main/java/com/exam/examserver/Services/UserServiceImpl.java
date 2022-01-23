package com.exam.examserver.Services;

import java.util.Set;

import com.exam.examserver.Model.User;
import com.exam.examserver.Model.UserRole;
import com.exam.examserver.Repository.RoleRepo;
import com.exam.examserver.Repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    //create or registering user to DB
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local= this.userRepo.findByUsername(user.getUsername());    
        if(local!=null){
            System.out.println("User already there");
            throw new Exception("User alredy Exist");
        }
        else{
            for (UserRole ur : userRoles) {
                roleRepo.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local=this.userRepo.save(user);
        }
        return local;
    }

   
    
}
