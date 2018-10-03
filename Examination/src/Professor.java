import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Professor {
    private String name;
    private String secondName;
    private String lastName;

    public void rateExams(Enrollee enrollee) { //Метод оценивания абитуриентов на экзаменах
        Exams exams = new Exams();
        exams.markFirstExam = getMark();
        exams.markSecondExam = getMark();
        exams.markThirdExam = getMark();
        exams.averageMark = (double) (exams.markFirstExam + exams.markSecondExam + exams.markThirdExam) / 3; //Средняя оценка
        exams.averageMark=new BigDecimal(exams.averageMark).setScale(3, RoundingMode.UP).doubleValue(); // Приведение средней оценки к удобочитаемому виду - до тысячных после точки)
        enrollee.exams = exams; //В поле абитуриента передаем все оценки
    }

    private int getMark() {//Метод случайного оценивания
        Random random = new Random();
        return random.nextInt(4) + 2; //Случайное число от 2 до 5
    }

    Professor(String name, String secondName, String lastName) {//Конструктор
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
    }

}
