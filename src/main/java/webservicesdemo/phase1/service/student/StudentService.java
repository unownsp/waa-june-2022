package webservicesdemo.phase1.service.student;


import webservicesdemo.phase1.entity.Course;
import webservicesdemo.phase1.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();
    void create(Student student);
    void update(Student student, int id);
    void delete(int id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int id);
}
