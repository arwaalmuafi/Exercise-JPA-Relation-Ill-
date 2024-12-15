package com.example.schoolmanagementsoftware.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class StudentDTO {

    @NotEmpty
    private String name;
    @NotNull
    @Min(10)
    private Integer age;
    @NotEmpty
    private String major;

    private List<CourseDTO> courses;


}
