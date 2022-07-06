package com.group10.bookingtravel.service;

import com.group10.bookingtravel.dto.UserSearchDTO;
import com.group10.bookingtravel.dto.UserStatusDTO;
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

    public List<User> getListUserStatus(String id, String username,String rank, String status){
        List<User> userList = new ArrayList<>();
        if(id == null || id.equals("null")){
            id = "0";
        }
        if(status == null || status.equals("null")){
            status = "2";
        }
        if(username == null || username.equals("null")){
            username = "";
        }
        if(rank == null || rank.equals("null")){
            rank ="";
        }
        if(userRepository.userList(Long.valueOf(id), username, rank,Integer.valueOf(status)).isPresent()){
            return userRepository.userList(Long.valueOf(id), username, rank ,Integer.valueOf(status)).get();
        }
        return userList;
    }
    public void updateStatusUser(UserStatusDTO userStatusDTO){
        userRepository.updateStatus(userStatusDTO.getId(),userStatusDTO.getStatus());
    }

    public User getUserByUserName(String userName){
        User user = new User();
        if(userRepository.getUserByUsername(userName).isPresent()){
            return userRepository.getUserByUsername(userName).get();
        }
        return user;
    }
}
