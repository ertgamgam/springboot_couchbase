package com.ertgamgam.sampleapi.controllers;

import com.ertgamgam.sampleapi.entity.Lesson;
import com.ertgamgam.sampleapi.entity.Student;
import com.ertgamgam.sampleapi.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lessons")
public class LessonController {

    @Autowired
    LessonRepository lessonRepository;

    //http://localhost:8081/lessons?page=1&size=3&sort=id,DESC
    @GetMapping
    public Page<Lesson> findAll(Pageable pageable) {
        return lessonRepository.findAll(pageable);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Lesson> findById(@PathVariable String id) {
        return lessonRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    /*@GetMapping(path = {"/findbyname/{name}"})
    public List GetByName(@PathVariable String name) {
        return lessonRepository.findByName(name);
    } */

    @PostMapping
    public Lesson create(@RequestBody Lesson lesson) {
        lesson.onCreated();
        return lessonRepository.save(lesson);
    }
}
