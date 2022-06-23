package webservicesdemo.phase2.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webservicesdemo.phase2.dto.CourseDTO;
import webservicesdemo.phase2.repo.CourseRepoP2;

import java.util.List;

@Service
public class CourseServiceImplP2 implements CourseService {

    private final CourseRepoP2 courseRepoP2;

    @Autowired
    public CourseServiceImplP2(CourseRepoP2 courseRepoP2) {
        this.courseRepoP2 = courseRepoP2;
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepoP2.findAll()
                .stream()
                .map((course -> new CourseDTO().toDto(course)))
                .toList();
    }
    @Override
    public void create(CourseDTO courseDTO) {
        courseRepoP2.create(courseDTO.toEntity());
    }
    @Override
    public void updateCourse(CourseDTO courseDTO, int id) {
        courseRepoP2.updateCourse(courseDTO.toEntity(), id);
    }
    @Override
    public void delete(int id) {
        courseRepoP2.delete(id);
    }
}
