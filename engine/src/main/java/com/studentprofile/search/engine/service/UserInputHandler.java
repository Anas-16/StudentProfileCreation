package com.studentprofile.search.engine.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Scanner;

@Service
public class UserInputHandler {

    private final Scanner scanner;

    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String promptForName() {
        System.out.print("Enter student's name: ");
        return scanner.nextLine();
    }

    public String promptForEmail() {
        System.out.print("Enter student's email: ");
        return scanner.nextLine();
    }

    public LocalDate promptForDOB() {
        System.out.print("Enter student's date of birth (YYYY-MM-DD): ");
        String dobString = scanner.nextLine();
        return LocalDate.parse(dobString);
    }

    public String promptForCourse() {
        System.out.print("Enter student's course: ");
        return scanner.nextLine();
    }

    public String promptForGrade() {
        System.out.print("Enter student's grade: ");
        return scanner.nextLine();
    }

    public boolean promptForAnotherProfile() {
        System.out.print("Do you want to create another student profile? (yes/no): ");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("yes");
    }


    public String promptForReturnStudent() {
        System.out.println("Which student would you like to retrieve?:  ");
        return scanner.nextLine();
    }
}
