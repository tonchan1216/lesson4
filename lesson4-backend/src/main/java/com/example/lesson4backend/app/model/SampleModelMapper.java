package com.example.lesson4backend.app.model;

import com.example.lesson4backend.domain.model.SampleTable;
import com.example.lesson4backend.domain.model.SampleTableKey;

public interface SampleModelMapper {

    public static SampleTable map(SampleModel sampleModel){
        return SampleTable.builder()
                .samplePartitionKey(sampleModel.getSamplePartitionKey())
                .sampleSortKey(sampleModel.getSampleSortKey())
                .sampleText(sampleModel.getSampleText())
                .build();
    }

    public static SampleTableKey mapToSampleTableKey(SampleModel sampleModel){
        return SampleTableKey.builder()
                .samplePartitionKey(sampleModel.getSamplePartitionKey())
                .sampleSortKey(sampleModel.getSampleSortKey())
                .build();
    }
}