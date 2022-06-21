package webservicesdemo.service.student;

import webservicesdemo.entity.Course;
import webservicesdemo.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();
    void create(Student student);
    void update(Student student, int id);
    void delete(int id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int id);
}
