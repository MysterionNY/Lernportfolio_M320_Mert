package V1.Interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentGroup extends ArrayList<Student> {
    public List<Student> getStudentsSortedByGrade() {
        List<Student> copy = new ArrayList<>(this);
        Collections.sort(copy);
        return copy;
    }

    public Student getBestStudent() {
        if (this.isEmpty()) return null;
        return Collections.min(this);
    }
}
