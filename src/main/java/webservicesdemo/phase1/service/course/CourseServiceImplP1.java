package webservicesdemo.phase1.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webservicesdemo.phase1.entity.Course;
import webservicesdemo.phase1.repo.CourseRepoP1;

import java.util.List;

@Service
public class CourseServiceImplP1 implements CourseService {

    private final CourseRepoP1 courseRepoP1;

    @Autowired
    public CourseServiceImplP1(CourseRepoP1 courseRepoP1) {
        this.courseRepoP1 = courseRepoP1;
    }

    @Override
    public List<Course> findAll() {
        return courseRepoP1.findAll();
    }

    @Override
    public void create(Course courseDTO) {
        courseRepoP1.create(courseDTO);
    }

    @Override
    public void updateCourse(Course courseDTO, int id) {
        courseRepoP1.updateCourse(courseDTO, id);
    }

    @Override
    public void delete(int id) {
        courseRepoP1.delete(id);
    }
}
