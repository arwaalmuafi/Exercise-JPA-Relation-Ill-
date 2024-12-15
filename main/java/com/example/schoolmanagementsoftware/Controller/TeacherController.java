package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.ApiResponse.ApiResponse;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Teacher")
public class TeacherController {

    private final TeacherService teacherService;
    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){
        return ResponseEntity.status(200).body(teacherService.getALLTeacher());
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return  ResponseEntity.status(200).body(new ApiResponse("teacher added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@RequestBody @Valid Teacher teacher ){
        teacherService.updateTeacher(teacher,id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher deleted"));
    }
    @GetMapping("/gatAll/{id}")
    public ResponseEntity findAll(@PathVariable Integer id){
        return ResponseEntity.status(200).body( teacherService.getByTeacherId(id));
    }
    @GetMapping("/teacherByCourse/{course_id}")
    public ResponseEntity findTeacherByCourseId(@PathVariable Integer course_id){
        return ResponseEntity.status(200).body(teacherService.findTeacherByCourseId(course_id));
    }


}
