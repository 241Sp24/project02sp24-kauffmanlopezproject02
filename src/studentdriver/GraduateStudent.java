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
        graduateAssistantType = "";
    }

    public boolean isIsGraduateAssistant() {
        return isGraduateAssistant;
    }

    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    @Override
    public double getPayableAmount() {
        if(isIsEnrolled()){
            double numOfCred = coursesEnrolled * 3 * 543.50;
            if(isIsGraduateAssistant()){
                if (graduateAssistantType.toLowerCase().equals("full")) {
                    numOfCred = 0;
                } 
                else if (graduateAssistantType.toLowerCase().equals("half")) {
                    numOfCred = numOfCred / 2;
                }
            }
            double totalAmount = numOfCred + ADDITIONAL_FEES;
            return totalAmount;
        }
        else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nGraduate Assistant: " + isGraduateAssistant + "\nGraduate Assistant Type: " + graduateAssistantType + "\nCourses Enrolled " + coursesEnrolled + "\nPayable Amount: " + getPayableAmount();
    }
}
