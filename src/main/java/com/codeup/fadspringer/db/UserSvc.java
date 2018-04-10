package com.codeup.fadspringer.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSvc {
    private Users usersDao;

    public UserSvc(Users usersDao) {
        this.usersDao = usersDao;
    }

    public boolean isLoggedIn() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null;
    }

    public User getLoggedInUser() {
        if (isLoggedIn()) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return usersDao.findByEmail(user.getEmail());
        }
        return null;
    }
}