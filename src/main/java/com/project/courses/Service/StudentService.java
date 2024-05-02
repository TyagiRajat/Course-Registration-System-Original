package com.project.courses.Service;

import com.project.courses.Models.Course;
import com.project.courses.Models.Student;
import com.project.courses.Repositiries.StudentRepo;

import java.util.List;

public interface StudentService {
//    private void

    public void registerNewStudent(Student student);

    public void deleteStudent(long ID);

    public Student getStudentDetails(Long ID);

    public void updateStudentDetails(Student student);

    public List<Course> getStudentCourses(long ID);

}
