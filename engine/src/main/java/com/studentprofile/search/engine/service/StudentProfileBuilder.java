package com.studentprofile.search.engine.service;


import com.studentprofile.search.engine.entity.StudentProfile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentProfileBuilder {

    public StudentProfile buildStudentProfile(int id, String name, String email, LocalDate dob, String course, String grade) {
        return new StudentProfile.StudentProfileBuilder()
                .setId(id)
                .setName(name)
                .setEmail(email)
                .setDob(dob)
                .setCourse(course)
                .setGrade(grade)
                .build();
    }
}

