package com.peter.service;

import com.peter.dao.UserRepository;
import com.peter.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository usersDao;


    public User getUserById(Integer id){
        User user = usersDao.getOne(id);
        return user;
    }

    public List<User> getAllUserById() {

        return usersDao.findAll();
    }
}
