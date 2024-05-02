package com.project.courses.Service;

import com.project.courses.Models.Course;
import com.project.courses.Models.Student;
import com.project.courses.Repositiries.CourseRepo;
import com.project.courses.Repositiries.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class DataBaseStudentService implements StudentService{
    StudentRepo studentRepo;
    CourseRepo courseRepo;

    @Override
    public void registerNewStudent(Student student){
            studentRepo.save(student);
        }

    @Override
    public void deleteStudent(long id) {
        Student student = getStudentDetails(id);
        studentRepo.delete(student);
    }

    @Override
    public Student getStudentDetails(Long ID){
        Optional<Student> OptionalStudent = studentRepo.findById(ID);
        if(OptionalStudent.isPresent()){
            return OptionalStudent.get();
        }
        else throw new RuntimeException("Student not found");
    }

    @Override
    public void updateStudentDetails(Student student){
            studentRepo.save(student);
        }


    public void updateStudentCources(Student student, long courseID, String action){
        if(action.equals("add"))
            student.getCourses().add(courseID);
        else if(action.equals("remove"))
            student.getCourses().remove(courseID);
        studentRepo.save(student);
    }

    @Override
    public List<Course> getStudentCourses(long ID){
        Optional<Student> OptionalStudent = studentRepo.findById(ID);
        if(!OptionalStudent.isPresent()){
            throw new RuntimeException("Student not found");
        }
        List<Course> courses = new ArrayList<Course>();
        for(Long courseID : OptionalStudent.get().getCourses()){
            Optional<Course> course = courseRepo.findById(courseID);
            if(course.isPresent()){
                courses.add(course.get());
            }
        }
        return courses;
    }
}
