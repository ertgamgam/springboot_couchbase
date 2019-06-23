package com.ertgamgam.sampleapi.entity;

import com.couchbase.client.java.repository.annotation.Field;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import javax.validation.constraints.NotNull;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends BaseEntity {

    @NotNull
    @Field
    private String name;


    @NotNull
    @Field
    private String surName;

}


/*  ctrl shift /
@Document: Couchbase’s annotation which defines an entity, similar to @Entity in JPA. Couchbase will automatically add a property called _class in the document to use it as the document type.
@Data:  Lombok’s annotation, auto-generate getters and setters
@AllArgsConstructor: Lombok’s annotation, auto-generate a constructor using all fields of the class, this constructor is used in our tests.
@NoArgsConstructor: Lombok’s annotation, auto-generate a constructor with no args (required by Spring Data)
@EqualsAndHashCode: Lombok’s annotation, auto-generate equals and hashcode methods, also used in our tests.
@NotNull: Yes! You can use javax.validation with Couchbase.
@Id: The document’s key
@Field:  Couchbase’s annotations, similar to @Column
*/
