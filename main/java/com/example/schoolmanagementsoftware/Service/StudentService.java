package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.ApiResponse.ApiException;
import com.example.schoolmanagementsoftware.DTO.CourseDTO;
import com.example.schoolmanagementsoftware.DTO.StudentDTO;
import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Model.Student;
import com.example.schoolmanagementsoftware.Repository.CourseRepository;
import com.example.schoolmanagementsoftware.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();

        for (Student student : students) {
            List<CourseDTO> courseDTOS = new ArrayList<>();
            for (Course course : student.getCourses()) {
                CourseDTO courseDTO = new CourseDTO(course.getName());
                courseDTOS.add(courseDTO);
            }
            StudentDTO studentDTO = new StudentDTO(student.getName(), student.getAge(), student.getMajor(), courseDTOS);
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }


    public void updateStudent(Integer id, Student student) {
        Student existingStudent = studentRepository.findStudentById(id);
        if (existingStudent == null) {
            throw new ApiException("Student not found");
        }
        existingStudent.setName(student.getName());
        existingStudent.setMajor(student.getMajor());
        studentRepository.save(existingStudent);
    }

    public void deleteStudent(Integer id) {
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        studentRepository.delete(student);
    }

    //3
    public void updateStudentMajor(Integer studentId, String major) {
        Student student = studentRepository.findStudentById(studentId);
        if (student == null)
            throw new ApiException(" not found");

        student.setMajor(major);
        student.setCourses(null);
        studentRepository.save(student);

    }

    public List<StudentDTO> getListOfStudent(Integer course_id) {
        Course course = courseRepository.findCourseById(course_id);
        if(course==null){
            throw new ApiException(" Cannot find the Course");
        }

        List<Student> students = new ArrayList<>(course.getStudents());

        List<StudentDTO> studentDTOS = new ArrayList<>();

        for (Student s : students) {
            List<CourseDTO> courseDTOS = new ArrayList<>();
            for (Course c : s.getCourses()) {
                CourseDTO courseDTO = new CourseDTO(c.getName());
                courseDTOS.add(courseDTO);
            }

            StudentDTO studentDTO = new StudentDTO(s.getName(), s.getAge(), s.getMajor(), courseDTOS);
            studentDTOS.add(studentDTO);
        }

        return studentDTOS;
    }

    public void assignCourseToStudent(Integer studentId, Integer courseId) {
        Student student = studentRepository.findStudentById(studentId);
        Course course = courseRepository.findCourseById(courseId);

        if (student == null || course == null) {
            throw new ApiException("Student or Course not found");
        }

        student.getCourses().add(course);
        course.getStudents().add(student);

        // Save the updated entities
        studentRepository.save(student);
        courseRepository.save(course);
    }


}
