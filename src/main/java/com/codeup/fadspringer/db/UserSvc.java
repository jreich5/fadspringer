package com.codeup.fadspringer.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSvc {
    private Users usersDao;

    @Autowired
    public UserSvc(Users usersDao) {
        this.usersDao = usersDao;
    }

    public List<User> findAll() {
        Iterable<User> usersDaoAll = usersDao.findAll();
        List<User> users = new ArrayList<>();
        usersDaoAll.forEach(users::add);
        return users;
    }

    public User findOne(long id) {
        return usersDao.findOne(id);
    }

}