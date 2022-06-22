package webservicesdemo.phase3.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webservicesdemo.phase3.dto.StudentDTO;
import webservicesdemo.phase3.entity.Course;
import webservicesdemo.phase3.repo.StudentRepoP3;

import java.util.List;

@Service
public class StudentServiceImplP3 implements StudentService {

    private final StudentRepoP3 studentRepoP3;

    @Autowired
    public StudentServiceImplP3(StudentRepoP3 studentRepoP3) {
        this.studentRepoP3 = studentRepoP3;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepoP3.findAllStudents()
                .stream()
                .map(student -> new StudentDTO().toDTO(student))
                .toList();
    }

    @Override
    public void create(StudentDTO student) {
        studentRepoP3.create(student.toEntity());
    }

    @Override
    public void update(StudentDTO student, int id) {
        studentRepoP3.updateStudent(student.toEntity(), id);
    }

    @Override
    public void delete(int id) {
        studentRepoP3.delete(id);
    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        return studentRepoP3.getStudentByMajor(major)
                .stream()
                .map(student -> new StudentDTO().toDTO(student))
                .toList();
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepoP3.getCoursesByStudentId(id);
    }
}
