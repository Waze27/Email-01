package com.email.email_01.service;

import com.email.email_01.entities.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    static List<Student> students = Arrays.asList(
            new Student("1", "Mirko", "Di Cristina", "mirko7726@gmail.com"),
            new Student("2", "Mario", "Cotumaccio", "marioilpiùforte@gmail.com"),
            new Student("3", "Lorenzo", "Catania", "tutorpiùforte@gmail.com"),
            new Student("4", "Carlo", "Carli", "hofinitoleidee@gmail.com")
    );

    public Student getStudentById(String studentId) {
        Optional<Student> studentFromDB = students.stream().filter(student -> student.getId().equals(studentId)).findAny();
        if (studentFromDB.isPresent()) return studentFromDB.get();
        return null;
    }
}
