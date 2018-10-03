public class Main {
    public static void main(String[] args) {
        Faculty faculty = new Faculty("Information Sciences"); //Create Faculty
        Professor professor = new Professor("Ivan", "Ivanovich", "Ivanov");//Hire professor;
        faculty.professor = professor; // Assign to faculty;

        Enrollee firstEnrollee = new Enrollee("Frank", "junior", "Sinatra");
        Enrollee secondEnrollee = new Enrollee("Albert", "Einstein");
        Enrollee thirdEnrollee = new Enrollee("Michael", "Joseph", "Jackson");

        firstEnrollee.registration(faculty); // registration on faculty
        secondEnrollee.registration(faculty);
        thirdEnrollee.registration(faculty);

        professor.rateExams(firstEnrollee); // Examination
        professor.rateExams(secondEnrollee);
        professor.rateExams(thirdEnrollee);

        faculty.checkPassingScore(); // Create list of students
        faculty.printListStudents(); // Print information


    }
}
