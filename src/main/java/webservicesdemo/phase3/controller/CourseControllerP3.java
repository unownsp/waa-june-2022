package webservicesdemo.phase3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webservicesdemo.phase3.dto.CourseDTO;
import webservicesdemo.phase3.service.course.CourseServiceImplP3;

import java.util.List;

@RestController
@RequestMapping("/p3/courses")
public class CourseControllerP3 {

    private final CourseServiceImplP3 courseServiceImplP3;

    @Autowired
    public CourseControllerP3(CourseServiceImplP3 courseServiceImplP3) {
        this.courseServiceImplP3 = courseServiceImplP3;
    }

    @GetMapping
    public List<CourseDTO> findAllProducts() {
        return courseServiceImplP3.findAll();
    }

    //http://localhost:8080/courses?age=20  ==>will conflict with findAllProducts as age is not a url thing
    //http://localhost:8080/courses/search?age=20
//    @GetMapping("/search")
//    public List<CourseDTO> getAllStudentsByAge(@RequestParam int age) {
//        return null;
//    }

    @PostMapping
    public void create(@RequestBody CourseDTO dto) {
        courseServiceImplP3.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CourseDTO dto, @PathVariable int id) {
        courseServiceImplP3.updateCourse(dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseServiceImplP3.delete(id);
    }

}
