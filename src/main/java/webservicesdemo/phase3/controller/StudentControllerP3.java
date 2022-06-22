package webservicesdemo.phase3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webservicesdemo.phase3.dto.StudentDTO;
import webservicesdemo.phase3.service.student.StudentService;

import java.util.List;

@RestController
@RequestMapping("/p3/students")
public class StudentControllerP3 {

    private final StudentService service;

    @Autowired
    public StudentControllerP3(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentDTO> getALlStudents() {
        return service.findAll();
    }

    @PostMapping
    public void create(@RequestBody StudentDTO student) {
        service.create(student);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody StudentDTO dto, @PathVariable int id) {
        service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/search")
    public List<StudentDTO> searchByMajor(@RequestParam String major) {
        return service.getStudentsByMajor(major);
    }
}
