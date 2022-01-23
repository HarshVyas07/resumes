package com.exam.examserver.Services;

import java.util.Set;

import com.exam.examserver.Model.User;
import com.exam.examserver.Model.UserRole;

public interface UserService {

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    
}
