package webservicesdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import webservicesdemo.entity.Student;
import webservicesdemo.service.student.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getALlStudents() {
        return service.findAll();
    }

    @PostMapping
    public void create(@RequestBody Student student) {
        service.create(student);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Student dto, @PathVariable int id) {
        service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
