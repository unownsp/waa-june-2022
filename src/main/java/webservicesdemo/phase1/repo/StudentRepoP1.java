package webservicesdemo.phase1.repo;

import org.springframework.stereotype.Repository;
import webservicesdemo.phase1.entity.Course;
import webservicesdemo.phase1.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepoP1 {

    private final List<Student> students = new ArrayList<>();


    public StudentRepoP1() {

        Student student = new Student(1, "Saugat", "Pageni", "saugatpageni@miu.edu", "CS", new ArrayList<>(), 4.0);
        Student student2 = new Student(2, "Sudip", "Adhikari", "sadh@gmail.com", "SE", new ArrayList<>(), 3.0);
        students.add(student);
        students.add(student2);
    }

    public List<Student> findAllStudents() {
        return students;
    }

    public void create(Student student) {
        students.add(student);
    }

    public void updateStudent(Student student, int id) {
        for (Student s : students) {
            if (s.getId() == id) students.add(student);
        }
    }

    public void delete(int id) {
        students.removeIf((student -> student.getId() == id));
    }

    public List<Student> getStudentByMajor(String major) {
        return students.stream().filter((student -> student.getMajor().equalsIgnoreCase(major))).toList();
    }

    public List<Course> getCoursesByStudentId(int id) {
        List<Course> courses = new ArrayList<>();

        for (Student s : students) {
            if (s.getId() == id) courses = s.getCoursesTaken();
        }

        return courses;
    }
}
