package com.project.courses.Controller;
//import package makkad.keshav.courses.Service.CourseService


import com.project.courses.Models.Course;
import com.project.courses.Service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    CourseService courseService;

    CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping("/register")
    void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }

    @DeleteMapping("/delete/{ID}")
    void deleteCourse(@PathVariable long ID){
        courseService.deleteCourse(ID);
    }

    @GetMapping("/all")
    List<Course> getAllCources(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{ID}")
    Course getCourse(@PathVariable long ID){
        return courseService.getCourse(ID);
    }

    @PatchMapping("/update")
    void updateCourse(@RequestBody Course course){
        courseService.updateCourse(course);
    }

    @PostMapping("/addStudent")
    void addStudentToCourse(@RequestParam long courseID, @RequestParam long studentID){
        courseService.addStudentToCourse(courseID, studentID);
    }

    @PostMapping("/addInstructor")
    void addInstructorToCourse(@RequestParam long courseID, @RequestParam long instructorID){
        courseService.addInstructorToCourse(courseID, instructorID);
    }

    @DeleteMapping("/removeStudent")
    void removeStudentFromCourse(@RequestParam long courseID, @RequestParam long studentID){
        courseService.removeStudentFromCourse(courseID, studentID);
    }

    @DeleteMapping("/removeInstructor")
    void removeInstructorFromCourse(@RequestParam long courseID, @RequestParam long instructorID){
        courseService.removeInstructorFromCourse(courseID, instructorID);
    }



}
