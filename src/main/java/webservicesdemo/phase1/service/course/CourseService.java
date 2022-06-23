package webservicesdemo.phase1.service.course;


import webservicesdemo.phase1.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();
    void create(Course courseDTO);
    void updateCourse(Course courseDTO, int id);
    void delete(int id);
}
