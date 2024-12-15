package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.ApiResponse.ApiException;
import com.example.schoolmanagementsoftware.DTO.CourseDTO;
import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Model.Student;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repository.CourseRepository;
import com.example.schoolmanagementsoftware.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<CourseDTO> getAllCourse() {
       List<Course>courses=courseRepository.findAll();
       List<CourseDTO>courseDTOS=new ArrayList<>();
       for(Course course:courses){
          CourseDTO courseDTO=new CourseDTO(course.getName());
       }
       return courseDTOS;
    }

    public void addCourse(Integer teacher_id, Course course) {
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        if (teacher == null) {
            throw new ApiException("Teacher not found ");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);

    }

    public void updateCourse(Integer id, Course course) {
        Course oldCourse = courseRepository.findCourseById(id);
        if (oldCourse == null) {
            throw new ApiException("Course not found");
        }
        oldCourse.setName(course.getName());

        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        courseRepository.delete(course);

    }

    public void findTeacherName(Integer course_id){
        Course course=courseRepository.findCourseById(course_id);
        if(course==null){
            throw new ApiException("not found");
        }

    }
    //4
    public List<Student> getStudentsByCourseId(Integer course_Id) {
        Course course =courseRepository.findCourseById(course_Id);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        return course.getStudents();
    }

}
