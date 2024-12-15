package com.example.schoolmanagementsoftware.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class CourseDTO {

    @NotEmpty
    @Size(min = 2,message = "name should be longer then 2")
    private String name;

    private TeacherDTO teacherDTO;

    private List<StudentDTO> studentDTOS;

    public @NotEmpty @Size(min = 2, message = "name should be longer then 2") String getName() {
        return name;
    }

    public void setName(@NotEmpty @Size(min = 2, message = "name should be longer then 2") String name) {
        this.name = name;
    }

    public TeacherDTO getTeacherDTO() {
        return teacherDTO;
    }

    public void setTeacherDTO(TeacherDTO teacherDTO) {
        this.teacherDTO = teacherDTO;
    }

    public List<StudentDTO> getStudentDTOS() {
        return studentDTOS;
    }

    public void setStudentDTOS(List<StudentDTO> studentDTOS) {
        this.studentDTOS = studentDTOS;
    }

    public CourseDTO(@NotEmpty @Size(min = 2,message = "should be longer then 2") String name) {
    }
}

