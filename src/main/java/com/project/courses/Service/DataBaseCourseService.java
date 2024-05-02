package com.project.courses.Service;


import com.project.courses.Models.Course;
import com.project.courses.Models.Instructor;
import com.project.courses.Models.Student;
import com.project.courses.Repositiries.CourseRepo;
import com.project.courses.Repositiries.InstructorRepo;
import com.project.courses.Repositiries.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DataBaseCourseService implements com.project.courses.Service.CourseService {

    InstructorRepo instructorRepo;
    CourseRepo courseRepo;
    StudentRepo studentRepo;
    DataBaseStudentService DBStudentService;
    InstructorService instructorService;
    DataBaseInstructorService DBInstructorService;

    @Override
    public void deleteCourse(long ID){

        Course course = getCourse(ID);
        courseRepo.delete(course);
    }

    @Override
    public void updateCourse(Course course){
        courseRepo.save(course);
    }

    @Override
    public Course getCourse(long ID){
        Optional<Course> OptionalCourse = courseRepo.findById(ID);
        if(OptionalCourse.isPresent()){
            return OptionalCourse.get();
        }
        else throw new RuntimeException("Course not found");
    }

    @Override
    public List<Course> getAllCourses(){
        List<Course> listOfCourses = courseRepo.findAll();
        return listOfCourses;
    }

    @Override
    public void addCourse(Course course) {
        courseRepo.save(course);
    }

    @Override
    public void addStudentToCourse(long courseID, long studentID){
        Optional<Course> course = courseRepo.findById(courseID);
        if(!course.isPresent()){
            throw new RuntimeException("Course not found");
        }
        Optional<Student> student = studentRepo.findById(studentID);
        if(!student.isPresent()){
            throw new RuntimeException("Student not found");
        }
        List<Long> currentStudents = course.get().getStudents();
        currentStudents.add(studentID);
        courseRepo.save(course.get());
        DBStudentService.updateStudentCources(student.get(), courseID, "add");
    }

    @Override
    public void addInstructorToCourse(long courseID, long instructorID) {
        Optional<Course> course = courseRepo.findById(courseID);
        if (!course.isPresent()) {
            throw new RuntimeException("Course not found");
        }
        Optional<Instructor> instructor = instructorRepo.findById(instructorID);
        if (!instructor.isPresent()) {
            throw new RuntimeException("Instructor not found");
        }
        List<Long> currentInstructors = course.get().getInstructors();
        currentInstructors.add(instructorID);
        courseRepo.save(course.get());
        DBInstructorService.updateInstructorCourses(instructor.get(), courseID, "add");
    }

    public void removeStudentFromCourse(long courseID, long studentID){
        Optional<Course> course = courseRepo.findById(courseID);
        if(!course.isPresent()){
            throw new RuntimeException("Course not found");
        }
        Optional<Student> student = studentRepo.findById(studentID);
        if(!student.isPresent()){
            throw new RuntimeException("Student not found");
        }
        List<Long> currentStudents = course.get().getStudents();
        currentStudents.remove(studentID);
        courseRepo.save(course.get());
        DBStudentService.updateStudentCources(student.get(), courseID, "remove");
    }

    public void removeInstructorFromCourse(long courseID, long instructorID){
        Optional<Course> course = courseRepo.findById(courseID);
        if(!course.isPresent()){
            throw new RuntimeException("Course not found");
        }
        Optional<Instructor> instructor = instructorRepo.findById(instructorID);
        if(!instructor.isPresent()){
            throw new RuntimeException("Instructor not found");
        }
        List<Long> currentInstructors = course.get().getInstructors();
        currentInstructors.remove(instructorID);
        courseRepo.save(course.get());
        DBInstructorService.updateInstructorCourses(instructor.get(), courseID, "remove");
    }

}
