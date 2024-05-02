package com.project.courses.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentID;
    private String studentName;
    private String studentEmail;
    private long studentPhoneNumber;

    private String dateOfJoining;
    @ElementCollection
    private List<Long> courses;
}
