package com.ertgamgam.sampleapi.entity;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.couchbase.client.java.repository.annotation.Field;
import com.ertgamgam.sampleapi.extensions.StudentDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(using = StudentDeserializer.class)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;

    @Field
    private String name;

    @Field("dictionary")
    private Map hashMap;


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
