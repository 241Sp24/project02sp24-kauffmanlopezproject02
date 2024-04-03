package studentdriver;

public class GraduateStudent extends StudentFees {

    private int coursesEnrolled;
    private boolean isGraduateAssistant;
    private String graduateAssistantType;
    private final double ADDITIONAL_FEES = 654.45;

    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant, String graduateAssistantType, int coursesEnrolled) {
        super(studentName, studentID, isEnrolled);
        this.isGraduateAssistant = isGraduateAssistant;
        this.graduateAssistantType = graduateAssistantType;
        this.coursesEnrolled = coursesEnrolled;

    }

    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant, int coursesEnrolled) {
        super(studentName, studentID, isEnrolled);
        this.isGraduateAssistant = isGraduateAssistant;
        this.coursesEnrolled = coursesEnrolled;
    }

    public boolean isIsGraduateAssistant() {
        return isGraduateAssistant;
    }

    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    public double getPayableAmount() {
        double numOfCred = coursesEnrolled * 3;
        double totalAmount = numOfCred + ADDITIONAL_FEES;
        if (graduateAssistantType.equals("Full")) {
            totalAmount = 0;
        } else if (graduateAssistantType.equals("Half")) {
            totalAmount = totalAmount / 2;
        }
        return totalAmount;
    }

    public String toString() {
        return "Is Graduate Assistant? " + isGraduateAssistant + "Graduate Assistant Type: " + graduateAssistantType + "Courses Enrolled " + coursesEnrolled;
    }
}
