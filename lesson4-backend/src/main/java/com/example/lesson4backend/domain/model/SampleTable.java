package com.example.lesson4backend.domain.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@DynamoDBTable(tableName = "MA-furutanito-sample")
public class SampleTable implements Serializable {
    @Id
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private SampleTableKey SampleTableKey;
    @DynamoDBHashKey
    private String samplePartitionKey;
    @DynamoDBRangeKey
    private String sampleSortKey;
    @DynamoDBAttribute
    private String sampleText;
}
