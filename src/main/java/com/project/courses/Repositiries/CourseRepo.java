package com.project.courses.Repositiries;

import com.project.courses.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    @Override
    Course save(Course course);

    @Override
    Optional<Course> findById(Long id);

    @Override
    List<Course> findAll();

    @Override
    public void delete(Course course);
}
