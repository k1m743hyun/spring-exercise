package com.k1m743hyun.springeventexercise.repository;

import com.k1m743hyun.springeventexercise.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
