package webservicesdemo.phase3.service.student;

import webservicesdemo.phase3.dto.StudentDTO;
import webservicesdemo.phase3.entity.Course;

import java.util.List;

public interface StudentService {

    List<StudentDTO> findAll();
    void create(StudentDTO student);
    void update(StudentDTO student, int id);
    void delete(int id);
    List<StudentDTO> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int id);
}
