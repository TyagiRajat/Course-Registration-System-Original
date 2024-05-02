package com.project.courses.Controller;

import com.project.courses.Models.Course;
import com.project.courses.Models.Instructor;
import com.project.courses.Service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    InstructorService instructorService;

    InstructorController(InstructorService instructorService){
        this.instructorService = instructorService;
    }

    @PostMapping("/register")
    void registerNewInstructor(@RequestBody Instructor instructor){
        instructorService.registerNewInstructor(instructor);
    }

    @DeleteMapping("/delete/{ID}")
    void deleteInstructor(@PathVariable long ID){
        instructorService.deleteInstructor(ID);
    }

    @PatchMapping("/update")
    void updateInstructorDetails(@RequestBody Instructor instructor){
        instructorService.updateInstructorDetails(instructor);
    }

    @GetMapping("/{ID}")
    Instructor getInstructorDetails(@PathVariable long ID){
        return instructorService.getInstructorDetails(ID);
    }

    @GetMapping("/courses/{ID}")
    List<Course> getInstructorCourses(@PathVariable long ID){
        return instructorService.getInstructorCourses(ID);
    }
}
