package com.project.courses.Service;

import com.project.courses.Models.Course;
import com.project.courses.Models.Instructor;
import com.project.courses.Repositiries.CourseRepo;
import com.project.courses.Repositiries.InstructorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DataBaseInstructorService implements InstructorService{

    InstructorRepo instructorRepo;
    CourseRepo courseRepo;
//    DataBaseInstructorService(InstructorRepo instructorRepo){
//        this.instructorRepo = instructorRepo;
//    }

    @Override
    public void registerNewInstructor(Instructor instructor) {
        instructorRepo.save(instructor);
    }

    @Override
    public void deleteInstructor(long ID) {
        Instructor instructor = getInstructorDetails(ID);
        instructorRepo.delete(instructor);
    }

    @Override
    public void updateInstructorDetails(Instructor instructor) {
        instructorRepo.save(instructor);
    }

    @Override
    public Instructor getInstructorDetails(long ID) {
        Optional<Instructor> OptionalInstructor = instructorRepo.findById(ID);
        if(OptionalInstructor.isPresent()){
            return OptionalInstructor.get();
        }
        else throw new RuntimeException("Instructor not found");

    }

    public void updateInstructorCourses(Instructor instructor, long courseID, String action){
        if(action.equals("add"))
            instructor.getCourses().add(courseID);
        else if(action.equals("remove"))
            instructor.getCourses().remove(courseID);
        instructorRepo.save(instructor);
    }

    @Override
    public List<Course> getInstructorCourses(long ID){
        Optional<Instructor> OptionalInstructor = instructorRepo.findById(ID);
        if(!OptionalInstructor.isPresent()){
            throw new RuntimeException("Instructor not found");
        }

        List<Course> courses = new ArrayList<Course>();
        for(Long courseID : OptionalInstructor.get().getCourses()){
            Optional<Course> course = courseRepo.findById(courseID);
            if(course.isPresent()){
                courses.add(course.get());
            }
        }
        return courses;
    }
}
