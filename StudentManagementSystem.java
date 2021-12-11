package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.Scanner;

public class StudentManagementSystem { Scanner scanner = new Scanner(System.in);
    private String firstName;
    private String lastname;
    private int age = 0;
    private String studentID;
    String stuClass;
    public String department;
    private String coursesEnrolled;
    private int tuition = 750;
    private int textBooks = 150;
    private int health = 500;
    private int sport = 450;
    private int uPass = 200;
    private int totalFee = (tuition + textBooks + health + sport + uPass);

    public StudentManagementSystem(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public void enroll() throws ParseException {
        System.out.println("\nWelcome " + firstName + " " + lastname +
                "\njust a few steps to complete your profile.\n\nEnter your date of birth (dd-MM-yyyy): ");
        String age = scanner.next();
        calculateAge(age);
        System.out.println("\nClass: ");
        String inputE1 = scanner.next();
        stuClass = inputE1;
        System.out.println("\nChoose your department:\n1. SCIENCE\n2. SOCIAL SCIENCES\n3. ART\n\nEnter an option: ");
        int dept = scanner.nextInt();
        this.courseArea(dept);
        showMenu();
    }
    private void showMenu() {
            System.out.println("\nWelcome to Plus Ultra Academy!\n\nMENU\n1. My Profile\n2. Pay Fees\n0. Exit");
            char ch;
            do {
                System.out.println("\nEnter menu option: ");
                int in = scanner.nextInt();
                ch = (char) in;
                switch (ch) {
                    case 1 -> studentProfile();
                    case 2 -> payFees();
                }
            }
            while (ch != 0);
        }

    private void studentProfile() {
            System.out.println("\nSTUDENT PROFILE\n\nName: " +
                    firstName + " " + lastname + "\nAge: " + age + "\nStudent ID: " + studentID + "\nClass: "
                    + stuClass +"\nDepartment: " + department + "\n\nCourses Enrolled: " + coursesEnrolled);
        }

    public String generateID() {
        int length = 10;
        String studentID = "ABCDEFGH0123456789";
        char[] id = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * studentID.length());
            id[i] = studentID.charAt(rand);
        }
        return new String(id);
    }

    private void payFees() {
        System.out.println("• Tuition fee - $" + tuition + "\n• Textbooks and supplies - $" + textBooks + "\n" +
                "• Health and dental plan - $" + health + "\n• Sport and recreation fee - $" + sport +
                "\n• U-Pass - $" + uPass + "\n" + "\nYour total fee for this section is $" + totalFee + "\n");
        System.out.println("1.Pay 2.Back");
        int fee = scanner.nextInt();
        if (fee == 1) {
            System.out.println("Enter amount: ");
            int amount = scanner.nextInt();
            if (amount < totalFee) {
                System.out.println("Insufficient amount\n");
                payFees();
            }else{
                System.out.println("Transaction Successful!\nYou have completed payment of your fees for this semester. Print receipt\n");
            }
        }
        else if (fee == 2){
            showMenu();
        }

        }

        public void calculateAge(String dob) throws ParseException {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(dob);
            Instant instant = date.toInstant();
            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
            LocalDate givenDate = zone.toLocalDate();
            Period period = Period.between(givenDate, LocalDate.now());
            age = period.getYears();
        }

        public String courseArea(int dept) {
        if (dept == 1) {
            studentID = generateID();
            department = "SCIENCES";
            coursesEnrolled = "English\nMathematics\nPhysics\nChemistry\nBiology";
            return "";
        }else if (dept == 2) {
            studentID = generateID();
            department = "SOCIAL-SCIENCES";
            coursesEnrolled = "English\nMathematics\nGeography\nGovernment\nEconomics";
            return "";
        }
        else if (dept == 3){
            studentID = generateID();
            department = "Art";
            coursesEnrolled = "English\nLiterature\nHistory\nCivic-Education\nCreative-Art\n";
            return "";
        }
        else {
            return "";
        }

        }


    }

