package lecture;

import java.util.List;
import java.util.stream.Collectors;

public class GradeLecture extends Lecture {

    private List<Grade> grades;

    public GradeLecture(int pass, String title, List<Integer> scores, List<Grade> grades) {
        super(pass, title, scores);
        this.grades = grades;
    }

    @Override
    public String evaluate() {
        return super.evaluate() + ", " + gradesStatistics();
    }

    public double average(String gradeName) {
        return grades.stream()
            .filter(grade -> grade.isName(gradeName))
            .findFirst()
            .map(this::gradeAverage)
            .orElse(0.0);
    }

    private double gradeAverage(Grade grade) {
        return getScores().stream()
            .filter(grade::include)
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0);
    }

    private String gradesStatistics() {
        return grades.stream()
            .map(this::format)
            .collect(Collectors.joining(" "));
    }

    private String format(Grade grade) {
        return String.format("%s:%d", grade.getName(), gradeCount(grade));
    }

    private long gradeCount(Grade grade) {
        return getScores().stream()
            .filter(grade::include)
            .count();
    }
}
