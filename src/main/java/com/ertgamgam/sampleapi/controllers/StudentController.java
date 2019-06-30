package com.ertgamgam.sampleapi.controllers;

import com.ertgamgam.sampleapi.entity.Student;
import com.ertgamgam.sampleapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    //http://localhost:8081/students?page=1&size=3&sort=id,DESC
    @GetMapping
    public String findAll(Pageable pageable) {
        return studentRepository.customGetAll(pageable).toString();

    }


    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Student> findById(@PathVariable String id) {
        return studentRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = {"/findbyname/{name}"})
    public List GetByName(@PathVariable String name) {
        return studentRepository.findByName(name);
    }

    @PostMapping
    public Student create(@Valid @RequestBody Student student) {
        return studentRepository.save(student);
    }
}
