package org.back.school.service;

import org.back.school.mapper.SchoolMapper;
import org.back.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    private final SchoolMapper studentMapper;

    @Autowired
    public SchoolService(SchoolMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    public Student findById(Long id){
        return studentMapper.findById(id);
    }

    public void save(Student student) {
        studentMapper.save(student);
    }

    public void update(Student student) {
        studentMapper.update(student);
    }

    public void delete(Long id) {
        studentMapper.delete(id);
    }
}
