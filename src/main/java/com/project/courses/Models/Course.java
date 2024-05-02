package com.project.courses.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseID;
    private String courseName;
    private String courseDescription;
    private int courseCredits;
//    @ManyToOne
    private String courseDepartment;
    private int coursePrice;
    @ElementCollection
    private List<Long> students;
    @ElementCollection
    private List<Long> instructors;
}
