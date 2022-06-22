package webservicesdemo.phase3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import webservicesdemo.phase3.entity.Course;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private int id;
    private String name;
    private String code;

    public CourseDTO toDto(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setCode(course.getCode());

        return courseDTO;
    }

    public Course toEntity() {
        Course course = new Course();
        course.setId(this.id);
        course.setCode(this.code);
        course.setName(this.name);

        return course;
    }
}
