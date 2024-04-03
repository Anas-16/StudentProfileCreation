package com.studentprofile.search.engine.service;

import com.studentprofile.search.engine.entity.StudentProfile;
import com.studentprofile.search.engine.repository.StudentProfileRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileService {

    private final StudentProfileRepository studentProfileRepository;


    @Autowired
    public StudentProfileService(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    public void saveStudentProfile(StudentProfile studentProfile) {
        studentProfileRepository.save(studentProfile);
    }
    public List<StudentProfile> getStudentsByName(String name) {
        return studentProfileRepository.findByName(name);
    }

}

