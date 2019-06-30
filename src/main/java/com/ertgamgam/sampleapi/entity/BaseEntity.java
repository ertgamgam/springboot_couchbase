package com.ertgamgam.sampleapi.entity;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;

import java.util.Date;

@Data
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;

    @Field
    private Date createdTime;

    public void onCreated(){
        this.createdTime=new Date();
    }


}
