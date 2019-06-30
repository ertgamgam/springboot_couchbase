package com.ertgamgam.sampleapi.controllers;

import com.ertgamgam.sampleapi.entity.Lesson;
import com.ertgamgam.sampleapi.repository.LessonRepository;
import com.ertgamgam.sampleapi.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LessonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    LessonRepository lessonRepository;

    @Test
    void findAll() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setId("1");
        lesson.setLessonName("se");
        lesson.setCreatedTime(new Date("2019-06-23T20:06:42.608+0000"));

        List<Lesson> lessons = Arrays.asList(lesson);
        given(lessonRepository.findAll()).willReturn(lessons);

        this.mockMvc.perform(get("/api/v1/lessons"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1,'lessonName': 'se','createdTime': '2019-06-23T20:06:42.608+0000'}]"));


    }
}