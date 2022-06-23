package webservicesdemo.phase2.repo;

import org.springframework.stereotype.Repository;
import webservicesdemo.phase2.entity.Course;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepoP2 {
    private final List<Course> courses = new ArrayList<>();

    public CourseRepoP2() {
        Course c1 = new Course(1, "WAA", "CS545");
        Course c2 = new Course(2, "WAP", "CS472");
        courses.add(c1);
        courses.add(c2);
    }

    public List<Course> findAll() {
        return courses;
    }

    public void create(Course c) {
        courses.add(c);
    }

    public Course getById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) return course;
        }
        return null;
    }

    public void updateCourse(Course course, int id) {

        if (courses.contains(course))
            courses.set(courses.indexOf(course), course);
    }

    public void delete(int id) {
        courses.removeIf(course -> course.getId() == id);
    }
}
