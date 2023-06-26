package com.example.demo;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.assertj.core.api.Assertions;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;
    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("bububu");
        user.setUsername("oioioi");
        user.setPassword("pomogite");
        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getUser_ID()).isGreaterThan(0);
    }
    @Test
    public void testListAll() {
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() {
        Long user_ID = 5L;
        Optional<User> optionalUser = repo.findById(user_ID);
        User user = optionalUser.get();
        user.setPassword("hello2000");
        repo.save(user);

        User updatedUser = repo.findById(user_ID).get();
        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("hello2000");
    }

    @Test
    public void testGet() {
        Long userId = 5L;
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete() {
        Long userId = 4L;
        repo.deleteById(userId);

        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
