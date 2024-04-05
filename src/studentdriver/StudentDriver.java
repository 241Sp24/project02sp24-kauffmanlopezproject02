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
        System.out.println("Project02");
        //create StudentFees array
        StudentFees [] students = new StudentFees[12];
        
        //declare number of students variable 
        int noOfUGStudents = 0;
        int noOfGradStudents = 0;
        int noOfOnlineStudents = 0;
        //new scanner
        Scanner input = new Scanner(System.in);
        //promt user for number of under grad students
        System.out.println("Enter the no of UG students: ");
        noOfUGStudents = input.nextInt();
        //promt user for number of grad students
        System.out.println("Enter the no of Graduate students: ");
        noOfGradStudents = input.nextInt();
        //promt user for number of online students
        System.out.println("Enter the no of Online students: ");
        noOfOnlineStudents = input.nextInt();
        
        //open a file to read from
        File inputFile = new File("input.csv");
        //Read from the open file
        Scanner inputII = new Scanner(inputFile);
        
        while(inputII.hasNextLine()){
            String name = inputII.nextLine();
            String [] stringArray = name.split(",");
            //if statements with (numOfUGStudent<5) etc...
        }
        
    }

}
