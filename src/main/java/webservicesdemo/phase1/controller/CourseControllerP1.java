package webservicesdemo.phase1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webservicesdemo.phase1.entity.Course;
import webservicesdemo.phase1.service.course.CourseServiceImplP1;

import java.util.List;

@RestController
@RequestMapping("/p1/courses")
public class CourseControllerP1 {

    private final CourseServiceImplP1 courseServiceImplP1;

    @Autowired
    public CourseControllerP1(CourseServiceImplP1 courseServiceImplP1) {
        this.courseServiceImplP1 = courseServiceImplP1;
    }

    @GetMapping
    public List<Course> findAllProducts() {
        return courseServiceImplP1.findAll();
    }

    //http://localhost:8080/courses?age=20  ==>will conflict with findAllProducts as age is not a url thing
    //http://localhost:8080/courses/search?age=20
//    @GetMapping("/search")
//    public List<CourseDTO> getAllStudentsByAge(@RequestParam int age) {
//        return null;
//    }

    @PostMapping
    public void create(@RequestBody Course dto) {
        courseServiceImplP1.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Course dto, @PathVariable int id) {
        courseServiceImplP1.updateCourse(dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseServiceImplP1.delete(id);
    }

}
