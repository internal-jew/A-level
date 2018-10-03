public class Exams {
    int markFirstExam;
    int markSecondExam;
    int markThirdExam;
    double averageMark;

    @Override
    public String toString() {
        return "Average mark: " + averageMark + " (1 exam: " + markFirstExam + ", 2 exam: " + markSecondExam + ", 3 exam: " + markThirdExam + ")";
    }
}
