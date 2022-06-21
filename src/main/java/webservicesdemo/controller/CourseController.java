package webservicesdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webservicesdemo.CourseDTO;
import webservicesdemo.service.course.CourseServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseServiceImpl courseServiceImpl;

    @Autowired
    public CourseController(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }

    @GetMapping
    public List<CourseDTO> findAllProducts() {
        return courseServiceImpl.findAll();
    }

    //http://localhost:8080/courses?age=20  ==>will conflict with findAllProducts as age is not a url thing
    //http://localhost:8080/courses/search?age=20
//    @GetMapping("/search")
//    public List<CourseDTO> getAllStudentsByAge(@RequestParam int age) {
//        return null;
//    }

    @PostMapping
    public void create(@RequestBody CourseDTO dto) {
        courseServiceImpl.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CourseDTO dto, @PathVariable int id) {
        courseServiceImpl.updateCourse(dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseServiceImpl.delete(id);
    }

}
