package com.example.lesson4backend.domain.service;

import com.example.lesson4backend.domain.model.SampleTable;
import com.example.lesson4backend.domain.model.SampleTableKey;

import java.util.List;

public interface SampleService {
    public SampleTable getSampleTable(SampleTableKey sampleTableKey);

    public List<SampleTable> getSampleTables();

    public SampleTable addSampleTable(SampleTable sampleTable);

    public SampleTable updateSampleTable(SampleTable sampleTable);

    public SampleTable deleteSampleTable(SampleTableKey sampleTableKey);
}
