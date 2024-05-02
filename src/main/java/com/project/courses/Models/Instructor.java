package com.project.courses.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Instructor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long instructorID;
    private String instructorName;
    private String instructorEmail;
    private long instructorPhoneNumber;
//    @ElementCollection
    private String instructorDepartment;
    private long salary;
    @ElementCollection
    private List<Long> courses;

}
