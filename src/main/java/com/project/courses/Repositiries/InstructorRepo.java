package com.project.courses.Repositiries;

import com.project.courses.Models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Long> {

    public Instructor save(Instructor instructor);

    public void delete(Instructor instructor);

    public Optional<Instructor> findById(long ID);
}
