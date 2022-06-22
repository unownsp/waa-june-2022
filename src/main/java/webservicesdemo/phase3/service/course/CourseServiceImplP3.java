package webservicesdemo.phase3.service.course;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webservicesdemo.phase3.dto.CourseDTO;
import webservicesdemo.phase3.entity.Course;
import webservicesdemo.phase3.repo.CourseRepoP3;

import java.util.List;

@Service
public class CourseServiceImplP3 implements CourseService {

    private final CourseRepoP3 courseRepoP3;
    private final ModelMapper modelMapper;

    @Autowired
    public CourseServiceImplP3(CourseRepoP3 courseRepoP3, ModelMapper modelMapper) {
        this.courseRepoP3 = courseRepoP3;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepoP3.findAll()
                .stream()
                .map((course -> modelMapper.map(course, CourseDTO.class)))
                .toList();
    }

    @Override
    public void create(CourseDTO courseDTO) {
        courseRepoP3.create(modelMapper.map(courseDTO, Course.class));
    }

    @Override
    public void updateCourse(CourseDTO courseDTO, int id) {
        courseRepoP3.updateCourse(modelMapper.map(courseDTO, Course.class), id);
    }

    @Override
    public void delete(int id) {
        courseRepoP3.delete(id);
    }
}
