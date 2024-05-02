package com.project.courses.Service;

import com.project.courses.Models.Course;
import com.project.courses.Models.Instructor;

import java.util.List;

public interface InstructorService {
    public void registerNewInstructor(Instructor instructor);

    public void deleteInstructor(long ID);

    public void updateInstructorDetails(Instructor instructor);

    public Instructor getInstructorDetails(long ID);
    public List<Course> getInstructorCourses(long ID);
}
