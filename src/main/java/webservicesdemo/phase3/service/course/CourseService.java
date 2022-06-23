package webservicesdemo.phase3.service.course;

import webservicesdemo.phase3.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> findAll();
    void create(CourseDTO courseDTO);
    void updateCourse(CourseDTO courseDTO, int id);
    void delete(int id);
}
