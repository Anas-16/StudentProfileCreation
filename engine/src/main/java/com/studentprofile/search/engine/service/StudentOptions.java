package com.studentprofile.search.engine.service;

import com.studentprofile.search.engine.entity.StudentProfile;
import com.studentprofile.search.engine.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Scanner;

@Service
public class StudentOptions {

    private final StudentProfileRepository studentProfileRepository;

    @Autowired
    public StudentOptions(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    public void switchStatements() {
        Scanner scanner = new Scanner(System.in);
        boolean createMore = true;
        int idCounter = 1;

        while (createMore) {
            System.out.println("Creating a new student profile...");

            String name = null;
            String email = null;
            LocalDate dob = null;
            String course = null;
            String grade = null;

            boolean searchForAnotherCategory = true;
            do {
                System.out.println("What would you like to add?\n1) Name\n2) Email\n3) Date of birth\n4) Course\n5) Grade");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (option) {
                    case 1:
                        System.out.print("Enter student's name: ");
                        name = scanner.nextLine();
                        break;
                    case 2:
                        System.out.print("Enter student's email: ");
                        email = scanner.nextLine();
                        break;
                    case 3:
                        System.out.print("Enter student's date of birth (YYYY-MM-DD): ");
                        String dobString = scanner.nextLine();
                        dob = LocalDate.parse(dobString);
                        break;
                    case 4:
                        System.out.print("Enter student's course: ");
                        course = scanner.nextLine();
                        break;
                    case 5:
                        System.out.print("Enter student's grade: ");
                        grade = scanner.nextLine();
                        break;
                }

                // Prompt the user to search for another category
                System.out.println("Would you like to add another category? (yes/no): ");
                String input = scanner.nextLine().toLowerCase();
                searchForAnotherCategory = input.equals("yes");
            } while (searchForAnotherCategory);

            // Create StudentProfile object using the builder
            StudentProfile studentProfile = new StudentProfile.StudentProfileBuilder()
                    .setId(idCounter++)
                    .setName(name)
                    .setEmail(email)
                    .setDob(dob != null ? dob : LocalDate.now())
                    .setCourse(course)
                    .setGrade(grade)
                    .build();

            // Save the student profile to the database
            studentProfileRepository.save(studentProfile);

            // Prompt the user to create more profiles
            System.out.print("Do you want to create another student profile? (yes/no): ");
            String input = scanner.nextLine();
            createMore = input.equalsIgnoreCase("yes");
        }

        scanner.close();
    }
}
