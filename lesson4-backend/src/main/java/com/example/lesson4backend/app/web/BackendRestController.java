package com.example.lesson4backend.app.web;

import com.example.lesson4backend.app.model.User;
import com.example.lesson4backend.domain.model.SampleQueue;
import com.example.lesson4backend.domain.model.SampleTable;
import com.example.lesson4backend.domain.repository.MsgRepository;
import com.example.lesson4backend.domain.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BackendRestController {

    @Autowired
    SampleService sampleService;

    @Autowired
    MsgRepository msgRepository;

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

    @GetMapping("/batch")
    public String batch(String message){
        msgRepository.save(
                SampleQueue.builder()
                        .message(message)
                        .build());
        return "Queue accepted.";
    }
}
