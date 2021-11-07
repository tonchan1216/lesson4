package com.example.lesson4.domain.service;

import com.example.lesson4.domain.model.SampleTable;
import com.example.lesson4.domain.model.SampleTableKey;
import com.example.lesson4.domain.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    SampleRepository sampleRepository;

    @Override
    public SampleTable getSampleTable(SampleTableKey sampleTableKey) {
        return sampleRepository.findById(sampleTableKey).get();
    }

    @Override
    public List<SampleTable> getSampleTables() {
        List<SampleTable> sampleTables = new ArrayList<>();
        sampleRepository.findAll().iterator().forEachRemaining(sampleTables::add);
        return sampleTables;
    }

    @Override
    public SampleTable addSampleTable(SampleTable sampleTable) {
        sampleTable.setSamplePartitionKey(UUID.randomUUID().toString());
        sampleTable.setSampleSortKey("1");
        return sampleRepository.save(sampleTable);
    }

    @Override
    public SampleTable updateSampleTable(SampleTable sampleTable) {
        return sampleRepository.save(sampleTable);
    }

    @Override
    public SampleTable deleteSampleTable(SampleTableKey sampleTableKey) {
        SampleTable sampleTable = sampleRepository.findById(sampleTableKey).get();
        sampleRepository.deleteById(sampleTableKey);
        return sampleTable;
    }
}
