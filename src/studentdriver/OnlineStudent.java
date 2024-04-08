/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentdriver;

/**
 *
 * @author s556538
 */
public class OnlineStudent extends StudentFees {

    private int noOfMonths;
    private final double MONTHLY_FEE = 1245.25;

    public OnlineStudent(String studentName, int studentID, boolean isEnrolled, int noOfMonths) {
        super(studentName, studentID, isEnrolled);
        this.noOfMonths = noOfMonths;
    }

    @Override
    public double getPayableAmount() {
        double payableAmount = MONTHLY_FEE * noOfMonths;
        return payableAmount;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.noOfMonths;
    }

}
