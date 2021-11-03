package com.example.lesson4backend.app.web;

import com.example.lesson4backend.app.model.SampleModel;
import com.example.lesson4backend.app.model.SampleModelMapper;
import com.example.lesson4backend.app.model.User;
import com.example.lesson4backend.domain.model.SampleTable;
import com.example.lesson4backend.domain.model.SampleTableKey;
import com.example.lesson4backend.domain.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BackendRestController {

    @Autowired
    SampleService sampleService;

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(User.builder().userId("1").userName("Taro").build());
        users.add(User.builder().userId("2").userName("Jiro").build());
        return users;
    }

    @GetMapping("/samples")
    public List<SampleTable> getSamples(){
        return sampleService.getSampleTables();
    }
}
