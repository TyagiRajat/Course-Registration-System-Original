package com.project.courses.Controller;

import com.project.courses.Models.Student;
import com.project.courses.Service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/register")
    void registerNewStudent(@RequestBody Student student){
        studentService.registerNewStudent(student);
    }

    @DeleteMapping("/delete/{ID}")
    void deleteStudent(@PathVariable long ID){
        studentService.deleteStudent(ID);
    }

    @PatchMapping("/update")
    void updateStudentDetails(@RequestBody Student student){
        studentService.updateStudentDetails(student);
    }

    @GetMapping("/{ID}")
    Student getStudentDetails(@PathVariable long ID){
        return studentService.getStudentDetails(ID);
    }

    @GetMapping("/courses/{ID}")
    void getStudentCourses(@PathVariable long ID){
        studentService.getStudentCourses(ID);
    }
}
