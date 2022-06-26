package org.back.school.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.back.school.model.Student;
import org.back.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class SchoolControllerTests extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private SchoolService schoolService;

    private MockMvc mockMvc;

    @BeforeClass
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testFindAll(){
        int listOfStudents = schoolService.findAll().size();
        Assert.assertTrue(listOfStudents > 0);
    }

    @Test
    public void testFindById() throws Exception {
        mockMvc.perform(get("/student/get/1"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Jake"))
                .andExpect(jsonPath("$.lastName").value("Gyllenhaal"))
                .andExpect(jsonPath("$.email").value("jakegyllenhaal@gmail.com"))
                .andExpect(jsonPath("$.faculty").value("Engineering"))
                .andExpect(jsonPath("$.program").value("MCM"))
                .andExpect(jsonPath("$.course").value(3))
                .andExpect(jsonPath("$.gpa").value(3.9));
    }

    @Test
    public void testSaveStudent() throws Exception {
        Student student = new Student("Walter", "White", 2,
                "Chemistry", 2.7, "walterwhite@gmail.com",
                "Nanomaterials");
        ObjectMapper mapper = new ObjectMapper();
        String jsonObject = mapper.writeValueAsString(student);
        int numberOfStudentsBeforeInsertion = schoolService.findAll().size();
        mockMvc.perform(post("/student/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObject))
                .andExpect(status().isCreated());
        int numberOfStudentsAfterInsertion = schoolService.findAll().size();
        Assert.assertTrue(numberOfStudentsBeforeInsertion < numberOfStudentsAfterInsertion);
    }

    @Test
    public void testUpdateStudent() throws Exception {
        Student studentToBeUpdated = schoolService.findById(1L);
        studentToBeUpdated.setEmail("updatedEmail");
        ObjectMapper mapper = new ObjectMapper();
        String jsonObject = mapper.writeValueAsString(studentToBeUpdated);
        mockMvc.perform(put("/student/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObject))
                .andExpect(status().isOk());
        Student updatedStudent = schoolService.findById(1L);
        Assert.assertEquals(studentToBeUpdated.getEmail(), updatedStudent.getEmail());
    }
}
