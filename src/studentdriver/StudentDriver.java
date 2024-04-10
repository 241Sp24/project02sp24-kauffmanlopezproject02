/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdriver;

/**
 *
 * @author dianar
 */
import java.util.*;
import java.io.*;

public class StudentDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //Ask Kai: why line 66 is out of bounds and calculate students fees etc w/o making a new arraylist
        //create StudentFees array
        StudentFees[] students = new StudentFees[12];

        //declare number of students variable
        int noOfUGStudents = 0;
        int noOfGradStudents = 0;
        int noOfOnlineStudents = 0;
        //new scanner
        Scanner input = new Scanner(System.in);
        //promt user for number of under grad students
        System.out.print("Enter the no of UG students: ");
        noOfUGStudents = input.nextInt();
        //promt user for number of grad students
        System.out.print("Enter the no of Graduate students: ");
        noOfGradStudents = input.nextInt();
        //promt user for number of online students
        System.out.print("Enter the no of Online students: ");
        noOfOnlineStudents = input.nextInt();

        //open a file to read from
        File inputFile = new File("input.csv");
        //Read from the open file
        Scanner inputII = new Scanner(inputFile);

        //counter variable
        int counter = 0;
        while (inputII.hasNextLine()) {
            String name = inputII.nextLine();
            String[] stringArray = name.split(",");
            //if statements with (numOfUGStudent<5) etc...
            if (counter < noOfUGStudents) {
                int studentID = Integer.parseInt(stringArray[0]);
                String studentName = stringArray[1];
                boolean isEnrolled = Boolean.parseBoolean(stringArray[2]);
                int coursesEnrolled = Integer.parseInt(stringArray[3]);
                boolean hasScholarship = Boolean.parseBoolean(stringArray[4]);
                double scholarshipAmount = Double.parseDouble(stringArray[5]);
                students[counter] = new UGStudent(studentName, studentID, isEnrolled, hasScholarship, scholarshipAmount, coursesEnrolled);
                counter++;
            } else if (counter < noOfGradStudents + noOfUGStudents) {
                if (stringArray.length == 6) {
                    int studentID = Integer.parseInt(stringArray[0]);
                    String studentName = stringArray[1];
                    boolean isEnrolled = Boolean.parseBoolean(stringArray[2]);
                    int coursesEnrolled = Integer.parseInt(stringArray[3]);
                    boolean isGraduateAssistant = Boolean.parseBoolean(stringArray[4]);
                    String graduateAssistantType = stringArray[5];
                    students[counter] = new GraduateStudent(studentName, studentID, isEnrolled, isGraduateAssistant, graduateAssistantType, coursesEnrolled);
                    counter++;
                } else {
                    int studentID = Integer.parseInt(stringArray[0]);
                    String studentName = stringArray[1];
                    boolean isEnrolled = Boolean.parseBoolean(stringArray[2]);
                    int coursesEnrolled = Integer.parseInt(stringArray[3]);
                    boolean isGraduateAssistant = Boolean.parseBoolean(stringArray[4]);
                    students[counter] = new GraduateStudent(studentName, studentID, isEnrolled, isGraduateAssistant, coursesEnrolled);
                    counter++;
                }
            } else if (counter < noOfOnlineStudents + noOfGradStudents + noOfUGStudents) {
                int studentID = Integer.parseInt(stringArray[0]);
                String studentName = stringArray[1];
                boolean isEnrolled = Boolean.parseBoolean(stringArray[2]);
                int noOfMonths = Integer.parseInt(stringArray[3]);
                students[counter] = new OnlineStudent(studentName, studentID, isEnrolled, noOfMonths);
                counter++;
            }
        }
        //UG stats
        double UGAvgF = 0.0;
        int UGSchol = 0;
        int UGCourses = 0;
        for (StudentFees x : students) {
            if (x instanceof UGStudent) {
                UGStudent y = (UGStudent) x;
                if (y.isHasScholarship()) {
                    UGSchol += 1;
                }
                if (y.isIsEnrolled()) {
                    UGCourses += y.getCoursesEnrolled();
                }
            }
        }

        //Grad stats
        double GAvgF = 0.0;
        int GACount = 0;
        int GCourses = 0;
        for (StudentFees l : students) {
            if (l instanceof GraduateStudent) {
                GraduateStudent m = (GraduateStudent) l;
                if (m.isIsGraduateAssistant()) {
                    GACount += 1;
                }
                if (m.isIsEnrolled()) {
                    GCourses += m.getCoursesEnrolled();
                }
            }
        }

        //ENHANCED FOR LOOP/PRINTING STUFF
        //not sure if any of this is right...
        //System.out.println("**********Undergraduate Students details**********");
        int b = 0;
        int c = 0;
        int d = 0;
        for (StudentFees a : students) {
            System.out.println();
            if (a instanceof UGStudent) {
                if (b == 0) {
                    System.out.println("**********Undergraduate Students details**********");
                }
                System.out.println(a);
                b++;
            } else if (a instanceof GraduateStudent) {
                if (c == 0) {
                    System.out.println("**********Graduate Students details**********");
                }
                System.out.println(a);
                c++;
            } else if (a instanceof OnlineStudent) {
                if (d == 0) {
                    System.out.println("**********Online Students details**********");
                }
                System.out.println(a);
                d++;
            }
        }

        System.out.println("\n**********Undergraduate Student Details**********");
        System.out.println("Average Students fee: ");
        System.out.println("Scholarship count: " + UGSchol);
        System.out.println("Total number of courses: " + UGCourses);

        System.out.println("**********Graduate Students details**********");
        System.out.println("Average Students fee: ");
        System.out.println("Graduate Assistanship count: " + GACount);
        System.out.println("Total number of courses: " + GCourses);

        System.out.println("**********Online Students details**********");
        System.out.println("Average Students fee: ");
    }

}
