package webservicesdemo.phase2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webservicesdemo.phase2.dto.CourseDTO;
import webservicesdemo.phase2.service.course.CourseServiceImplP2;

import java.util.List;

@RestController
@RequestMapping("/p2/courses")
@CrossOrigin(origins="http://localhost:63342")
public class CourseControllerP2 {

    private final CourseServiceImplP2 courseServiceImplP2;

    @Autowired
    public CourseControllerP2(CourseServiceImplP2 courseServiceImplP2) {
        this.courseServiceImplP2 = courseServiceImplP2;
    }

    @GetMapping
    public List<CourseDTO> findAllProducts() {
        return courseServiceImplP2.findAll();
    }

    //http://localhost:8080/courses?age=20  ==>will conflict with findAllProducts as age is not a url thing
    //http://localhost:8080/courses/search?age=20
//    @GetMapping("/search")
//    public List<CourseDTO> getAllStudentsByAge(@RequestParam int age) {
//        return null;
//    }

    @PostMapping
    public void create(@RequestBody CourseDTO dto) {
        courseServiceImplP2.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CourseDTO dto, @PathVariable int id) {
        courseServiceImplP2.updateCourse(dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseServiceImplP2.delete(id);
    }

}
