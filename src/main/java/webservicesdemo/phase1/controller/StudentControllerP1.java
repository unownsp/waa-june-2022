package webservicesdemo.phase1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import webservicesdemo.phase1.entity.Student;
import webservicesdemo.phase1.service.student.StudentService;

import java.util.List;

@Controller
@RequestMapping("/p1/students")
public class StudentControllerP1 {

    private final StudentService service;

    @Autowired
    public StudentControllerP1(StudentService service) {
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
