package com.peter.dao;

import com.peter.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Override
    List<User> findAllById(Iterable<Integer> iterable);


    @Override
    User getOne(Integer integer);
}
