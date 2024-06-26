/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentdriver;

/**
 *
 * @author s556538
 */
public abstract class StudentFees {
    private String studentName;
    private int studentID; 
    private boolean isEnrolled;
    private final int CREDITS_PER_COURSE = 3;
    private final double PER_CREDIT_FEE = 543.50;
    
    public StudentFees(String studentName, int studentID, boolean isEnrolled){
        this.studentName = studentName; 
        this.studentID = studentID;
        this.isEnrolled = isEnrolled;
    }
    public String getStudentName(){
        return studentName;
    }
    public int getStudentID(){
        return studentID;
    }
    public boolean isIsEnrolled(){
        return isEnrolled;
    }
    public int getCREDITS_PER_COURSE(){
        return CREDITS_PER_COURSE;
    }
    public double getPER_CREDIT_FEE(){
        return PER_CREDIT_FEE;
    }
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public void setStudentID(int studentID){
        this.studentID = studentID;
    }
    public void isEnrolled(boolean isEnrolled){
        this.isEnrolled = isEnrolled;
    }
    public abstract double getPayableAmount();
    
    @Override
    public String toString(){
       return "Student Name: " + studentName + "\nStudent id: " + studentID + "\nEnrolled: " + isEnrolled;
    }
}
