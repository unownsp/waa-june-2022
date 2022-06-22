package webservicesdemo.phase2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import webservicesdemo.phase2.entity.Course;
import webservicesdemo.phase2.entity.Student;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;
    private double gpa;

    public StudentDTO toDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setMajor(student.getMajor());
        studentDTO.setCoursesTaken(student.getCoursesTaken());
        studentDTO.setGpa(student.getGpa());

        return studentDTO;
    }

    public Student toEntity() {
        Student student = new Student();
        student.setId(this.getId());
        student.setFirstName(this.getFirstName());
        student.setLastName(this.getLastName());
        student.setEmail(this.getEmail());
        student.setMajor(this.getMajor());
        student.setCoursesTaken(this.getCoursesTaken());
        student.setGpa(this.getGpa());

        return student;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof StudentDTO studentDTO)) return false;
        return studentDTO.getId() == this.id;
    }
}
