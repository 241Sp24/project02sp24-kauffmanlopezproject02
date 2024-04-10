package studentdriver;

public class UGStudent extends StudentFees {

    private double scholarshipAmount;
    private int coursesEnrolled;
    private boolean hasScholarship;
    private final double ADDITIONAL_FEE = 820.70;

    public UGStudent(String studentName, int studentID, boolean isEnrolled, boolean hasScholarship, double scholarshipAmount, int coursesEnrolled) {
        super(studentName, studentID, isEnrolled);
        this.hasScholarship = hasScholarship;
        this.scholarshipAmount = scholarshipAmount;
        this.coursesEnrolled = coursesEnrolled;

    }

    public boolean isHasScholarship() {
        return hasScholarship;
    }

    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    @Override
    public double getPayableAmount(){
        if (super.isIsEnrolled()) {
            if(!hasScholarship){
                scholarshipAmount= 0.0;
            }
            double numOfCred = coursesEnrolled * 3;
            numOfCred = numOfCred * 543.50;
            return numOfCred + ADDITIONAL_FEE - scholarshipAmount;
        } 
        else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nScholarship: " + hasScholarship + "\nScholarship amount: " + scholarshipAmount
                + "\nCourses Enrolled: " + coursesEnrolled + "\nPayable amount: " + getPayableAmount();
    }
}
