package com.example.schoolmanagementsoftware.DTO;


import com.example.schoolmanagementsoftware.Model.Course;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Data
public class TeacherDTO {
    @NotEmpty(message = "name cannot be Empty!")
    private String name;

    @NotNull(message = "age must be not null")
    @Min(21)
    private Integer age;
    @NotEmpty
    @Email(message = "but Email in good way")
    private String email;

    private List<CourseDTO> course;

    public @NotEmpty(message = "name cannot be Empty!") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "name cannot be Empty!") String name) {
        this.name = name;
    }

    public @NotNull(message = "age must be not null") @Min(21) Integer getAge() {
        return age;
    }

    public void setAge(@NotNull(message = "age must be not null") @Min(21) Integer age) {
        this.age = age;
    }

    public @NotEmpty @Email(message = "but Email in good way") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty @Email(message = "but Email in good way") String email) {
        this.email = email;
    }

    public List<CourseDTO> getCourse() {
        return course;
    }

    public void setCourse(List<CourseDTO> course) {
        this.course = course;
    }

    public TeacherDTO(@NotEmpty(message = "name cannot be Empty!") String name, @NotNull(message = "age must be not null") Integer age, @Email(message = "but Email in good way") String email, Set<Course> course) {
    }
}
