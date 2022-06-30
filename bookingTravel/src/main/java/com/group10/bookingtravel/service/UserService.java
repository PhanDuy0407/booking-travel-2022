package com.group10.bookingtravel.service;

import com.group10.bookingtravel.entity.User;
import com.group10.bookingtravel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getListUserStatus(){
        List<User> userList = new ArrayList<>();
        if(userRepository.userList().isPresent()){
            return userRepository.userList().get();
        }
        return userList;
    }
}
