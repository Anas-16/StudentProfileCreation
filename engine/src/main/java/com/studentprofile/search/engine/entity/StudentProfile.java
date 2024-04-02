package com.studentprofile.search.engine.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @Column(name = "course")
    private String course;

    @Column(name = "grade")
    private String grade;

    private int age;


    public StudentProfile(int id, String name, String email, LocalDate dob, String course, String grade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;

        LocalDate currentTime = LocalDate.now();
        Period period = Period.between(dob, currentTime);
        this.age = period.getYears();
        this.course = course;
        this.grade = grade;
    }
    public StudentProfile() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public String getGrade() {
        return grade;
    }

    public static class StudentProfileBuilder {
        private int id;
        private String name;
        private String email;
        private LocalDate dob;
        private int age;

        private String course;
        private String grade;

        public StudentProfileBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentProfileBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public StudentProfileBuilder setDob(LocalDate dob) {
            this.dob = dob;
            return this;
        }

        public StudentProfileBuilder setId(int idCounter) {
            this.id = idCounter;
            return this;
        }

        public StudentProfileBuilder setCourse(String course) {
            this.course = course;
            return this;
        }

        public StudentProfileBuilder setGrade(String grade) {
            this.grade = grade;
            return this;
        }

        public StudentProfile build() {
            return new StudentProfile(id, name, email, dob, course, grade);
        }
    }
}
