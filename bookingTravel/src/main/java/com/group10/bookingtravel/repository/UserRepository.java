package com.group10.bookingtravel.repository;

import com.group10.bookingtravel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select distinct new com.group10.bookingtravel.entity.User(u.id,u.username,u.fullname,u.email,u.address,u.dob,u.gender,u.password,u.createdDate,u.status,u.rank,u.totalOrder) from User u where u.status = 1")
    public Optional<List<User>> userList();
}
