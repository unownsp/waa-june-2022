package webservicesdemo.phase2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webservicesdemo.phase2.dto.StudentDTO;
import webservicesdemo.phase2.service.student.StudentService;

import java.util.List;

@RestController
@RequestMapping("/p2/students")
@CrossOrigin(origins="http://localhost:63342")
public class StudentControllerP2 {

    private final StudentService service;

    @Autowired
    public StudentControllerP2(StudentService service) {
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
