package com.example.lesson4.domain.repository;

import com.example.lesson4.domain.model.SampleTable;
import com.example.lesson4.domain.model.SampleTableKey;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface SampleRepository extends CrudRepository<SampleTable, SampleTableKey> {
}