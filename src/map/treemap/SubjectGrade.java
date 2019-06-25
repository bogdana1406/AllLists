package map.treemap;

import java.io.Serializable;
import java.util.Objects;

public class SubjectGrade implements Serializable {

    private final String subject;
    private final Integer grade;

    public SubjectGrade(String subject, Integer grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public Integer getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectGrade that = (SubjectGrade) o;
        return Objects.equals(subject, that.subject) &&
                Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, grade);
    }

    @Override
    public String toString() {
        return "Subject: " + subject + " Grade: " + grade;
    }
}
