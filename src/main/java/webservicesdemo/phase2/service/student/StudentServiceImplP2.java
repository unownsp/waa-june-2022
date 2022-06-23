package webservicesdemo.phase2.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webservicesdemo.phase2.dto.StudentDTO;
import webservicesdemo.phase2.entity.Course;
import webservicesdemo.phase2.repo.StudentRepoP2;

import java.util.List;

@Service
public class StudentServiceImplP2 implements StudentService {

    private final StudentRepoP2 studentRepoP2;

    @Autowired
    public StudentServiceImplP2(StudentRepoP2 studentRepoP2) {
        this.studentRepoP2 = studentRepoP2;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepoP2.findAllStudents()
                .stream()
                .map(student -> new StudentDTO().toDTO(student))
                .toList();
    }

    @Override
    public void create(StudentDTO student) {
        studentRepoP2.create(student.toEntity());
    }

    @Override
    public void update(StudentDTO student, int id) {
        studentRepoP2.updateStudent(student.toEntity(), id);
    }

    @Override
    public void delete(int id) {
        studentRepoP2.delete(id);
    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        return studentRepoP2.getStudentByMajor(major)
                .stream()
                .map(student -> new StudentDTO().toDTO(student))
                .toList();
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepoP2.getCoursesByStudentId(id);
    }
}
