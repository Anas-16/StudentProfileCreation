package com.studentprofile.search.engine.service;

import com.studentprofile.search.engine.entity.StudentProfile;
import com.studentprofile.search.engine.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentOptions {

    private final StudentProfileRepository studentProfileRepository;
    private final UserInputHandler userInputHandler;
    private final StudentProfileBuilder studentProfileBuilder;
    private final StudentProfileService studentProfileService;

    @Autowired
    public StudentOptions(StudentProfileRepository studentProfileRepository,
                          UserInputHandler userInputHandler,
                          StudentProfileBuilder studentProfileBuilder,
                          StudentProfileService studentProfileService) {
        this.studentProfileRepository = studentProfileRepository;
        this.userInputHandler = userInputHandler;
        this.studentProfileBuilder = studentProfileBuilder;
        this.studentProfileService = studentProfileService;
    }

    public void switchStatements() {
        boolean createMore = true;
        int idCounter = 1;

        while (createMore) {
            System.out.println("Creating a new student profile...");

            String name = userInputHandler.promptForName();
            String email = userInputHandler.promptForEmail();
            LocalDate dob = userInputHandler.promptForDOB();
            String course = userInputHandler.promptForCourse();
            String grade = userInputHandler.promptForGrade();

            StudentProfile studentProfile = studentProfileBuilder.buildStudentProfile(idCounter++, name, email, dob, course, grade);

            studentProfileService.saveStudentProfile(studentProfile);

            createMore = userInputHandler.promptForAnotherProfile();
        }
    }
}
