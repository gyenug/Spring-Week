package com.example.blogjpa;


import com.example.blogjpa.Service.UserService;
import com.example.blogjpa.domain.User;
import com.example.blogjpa.dto.AddUserRequest;
import com.example.blogjpa.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;
    @Transactional
    @Test
    public void saveTest() {
        // given:
        AddUserRequest request = new AddUserRequest("mock_email888", "mock_pw");

        // when:
        User user = userService.save(request);

        // then:
        assertThat(user.getEmail()).isEqualTo("mock_email888");
        assertThat(user.getUsername()).isEqualTo("mock_email888");
    }

    @Test
    public void existsTest() {

        boolean exists = userRepository.existsById(1L);

        System.out.println(exists);
//        org.junit.jupiter.api.Assertions.assertTrue(exists);
    }
}