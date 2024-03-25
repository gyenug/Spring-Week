package com.example.blogjpa.repository;

import com.example.blogjpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);  // email로 사용자 정보를 가져옴
    void deleteByEmail(String email );
}