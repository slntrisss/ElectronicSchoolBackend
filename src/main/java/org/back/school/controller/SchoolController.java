package org.back.school.controller;

import org.back.school.model.Student;
import org.back.school.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/student")
public class SchoolController {
    private final SchoolService studentService;

    public SchoolController(SchoolService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> findAll(){
        List<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> findById(@PathVariable ("id") Long id){
        Student student = studentService.findById(id);
        return new ResponseEntity<>(student, OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(student, CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        studentService.update(student);
        System.out.println(student.getFirstName());
        return new ResponseEntity<>(student, OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id")Long id){
        studentService.delete(id);
        return new ResponseEntity<>(OK);
    }
}
