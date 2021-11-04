package com.example.lesson4backend.domain.repository;

import com.example.lesson4backend.domain.model.SampleQueue;

public interface MsgRepository {
    void save(SampleQueue sampleQueue);

}
