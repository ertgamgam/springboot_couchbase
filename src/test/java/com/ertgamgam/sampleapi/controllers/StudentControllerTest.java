package com.ertgamgam.sampleapi.controllers;

import com.ertgamgam.sampleapi.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StudentRepository studentRepository;


    @Test
    public void findAll() throws Exception {
        /*//given
        Student student = new Student();
        student.setId("1");
        student.setName("ayşe");
        student.setSurName("gamgam");
        student.setCreatedTime(new Date("2019-06-23T19:15:21.005+0000"));

        Iterable<Student> students = Arrays.asList(student);
        given(studentRepository.findAll()).willReturn(students);

        this.mockMvc.perform(get("/api/v1/students"))
                .andExpect(status().isOk())
                .andExpect(content().json(""));*/
    }

    @Test
    void findById() {
    }

    @Test
    void getByName() {
    }

    @Test
    void create() {
    }
}