package com.example.lesson4backend.app.web;

import com.example.lesson4backend.app.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BackendRestController {

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(User.builder().userId("1").userName("Taro").build());
        users.add(User.builder().userId("2").userName("Jiro").build());
        return users;
    }
}
