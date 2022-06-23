package webservicesdemo.phase1.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webservicesdemo.phase1.entity.Course;
import webservicesdemo.phase1.entity.Student;
import webservicesdemo.phase1.repo.StudentRepoP1;

import java.util.List;

@Service
public class StudentServiceImplP1 implements StudentService {

    private final StudentRepoP1 studentRepoP1;

    @Autowired
    public StudentServiceImplP1(StudentRepoP1 studentRepoP1) {
        this.studentRepoP1 = studentRepoP1;
    }

    @Override
    public List<Student> findAll() {
        return studentRepoP1.findAllStudents();
    }

    @Override
    public void create(Student student) {
        studentRepoP1.create(student);
    }

    @Override
    public void update(Student student, int id) {
        studentRepoP1.updateStudent(student, id);
    }

    @Override
    public void delete(int id) {
        studentRepoP1.delete(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepoP1.getStudentByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepoP1.getCoursesByStudentId(id);
    }
}
