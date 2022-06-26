create table if not exists student(
    id int auto_increment primary key,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    faculty varchar(255),
    program varchar(255),
    course int,
    gpa double
);