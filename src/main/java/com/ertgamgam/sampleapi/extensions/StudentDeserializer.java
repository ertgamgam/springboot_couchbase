package com.ertgamgam.sampleapi.extensions;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonParser;
import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.DeserializationContext;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.JsonNode;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ertgamgam.sampleapi.entity.Student;

import java.io.IOException;

public class StudentDeserializer extends StdDeserializer<Student> {

    public StudentDeserializer() {
        this(null);
    }

    public StudentDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Student deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);

        return new Student();
    }
}
