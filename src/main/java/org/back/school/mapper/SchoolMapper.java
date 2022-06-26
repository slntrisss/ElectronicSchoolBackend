package org.back.school.mapper;

import org.apache.ibatis.annotations.*;
import org.back.school.model.Student;

import java.util.List;

@Mapper
public interface SchoolMapper {
    @Select("SELECT * FROM student")
    List<Student> findAll();

    @Select("SELECT * FROM student WHERE id=#{id}")
    Student findById(@Param("id") Long id);

    @Insert("INSERT INTO student(first_name, last_name, email, faculty, program, course, gpa) " +
            "VALUES(#{firstName}, #{lastName}, #{email}, #{faculty}, #{program}, #{course}," +
            "#{gpa})")
    void save(Student student);

    @Update("UPDATE student SET first_name=#{firstName}, last_name=#{lastName}, email=#{email}, " +
            "faculty=#{faculty}, program=#{program}, course=#{course}, gpa=#{gpa} WHERE id=#{id}")
    void update(Student student);

    @Delete("DELETE FROM student WHERE id=#{id}")
    void delete(@Param("id") Long id);
}
