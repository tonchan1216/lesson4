package com.example.lesson4backend.domain.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SampleTableKey implements Serializable {
    @DynamoDBHashKey
    private String samplePartitionKey;
    @DynamoDBRangeKey
    private String sampleSortKey;
}
