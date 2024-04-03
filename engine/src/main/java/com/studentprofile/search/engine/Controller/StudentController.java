package com.studentprofile.search.engine.Controller;

import com.studentprofile.search.engine.entity.StudentProfile;
import com.studentprofile.search.engine.service.StudentProfileService;
import com.studentprofile.search.engine.service.UserInputHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/search")
public class StudentController {

    private final StudentProfileService studentProfileService;
    private final UserInputHandler userInputHandler;

    @Autowired
    public StudentController(StudentProfileService studentProfileService, UserInputHandler userInputHandler) {
        this.studentProfileService = studentProfileService;
        this.userInputHandler = userInputHandler;
    }

    @GetMapping
    public List<StudentProfile> getStudent(@RequestParam("name") String name) {
        return studentProfileService.getStudentsByName(name);
    }
}
