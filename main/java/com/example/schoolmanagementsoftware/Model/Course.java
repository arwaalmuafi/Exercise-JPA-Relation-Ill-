package com.example.schoolmanagementsoftware.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 2,message = "should be longer then 2")
    private String name;

    @ManyToOne
    @JsonIgnore
    @JsonBackReference
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
