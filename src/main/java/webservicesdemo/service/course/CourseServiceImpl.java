package webservicesdemo.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webservicesdemo.CourseDTO;
import webservicesdemo.repo.CourseRepo;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepo.findAll()
                .stream()
                .map((course -> new CourseDTO().toDto(course)))
                .toList();
    }

    @Override
    public void create(CourseDTO courseDTO) {
        courseRepo.create(courseDTO.toEntity());
    }

    @Override
    public void updateCourse(CourseDTO courseDTO, int id) {
        courseRepo.updateCourse(courseDTO.toEntity(), id);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }
}
