package com.project.courses.Repositiries;

import com.project.courses.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    public Optional<Student> findById(long id);

    public void delete(Student student);

    public Student save(Student student);

}
