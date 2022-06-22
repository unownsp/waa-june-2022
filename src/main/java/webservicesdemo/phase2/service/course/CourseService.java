package webservicesdemo.phase2.service.course;

import webservicesdemo.phase2.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> findAll();
    void create(CourseDTO courseDTO);
    void updateCourse(CourseDTO courseDTO, int id);
    void delete(int id);
}
