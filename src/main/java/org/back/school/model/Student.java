package org.back.school.model;

public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer course;
    private String faculty;
    private Double gpa;
    private String email;
    private String program;

    public Student() {
    }

    public Student(String firstName,
                   String lastName,
                   Integer course,
                   String faculty,
                   Double gpa,
                   String email,
                   String program) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.faculty = faculty;
        this.gpa = gpa;
        this.email = email;
        this.program = program;
    }

    public Student(Long id,
                   String firstName,
                   String lastName,
                   Integer course,
                   String faculty,
                   Double gpa,
                   String email,
                   String program) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.faculty = faculty;
        this.gpa = gpa;
        this.email = email;
        this.program = program;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
