package webservicesdemo.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webservicesdemo.entity.Course;
import webservicesdemo.entity.Student;
import webservicesdemo.repo.StudentRepo;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.findAllStudents();
    }

    @Override
    public void create(Student student) {
        studentRepo.create(student);
    }

    @Override
    public void update(Student student, int id) {
        studentRepo.updateStudent(student, id);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepo.getCoursesByStudentId(id);
    }
}
