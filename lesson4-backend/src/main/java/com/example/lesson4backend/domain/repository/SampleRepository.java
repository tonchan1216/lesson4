package com.example.lesson4backend.domain.repository;

import com.example.lesson4backend.domain.model.SampleTable;
import com.example.lesson4backend.domain.model.SampleTableKey;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface SampleRepository extends CrudRepository<SampleTable, SampleTableKey> {
}