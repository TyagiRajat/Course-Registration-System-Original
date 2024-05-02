package com.project.courses.DTO;

import com.project.courses.Models.Department;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Entity
public class CourseDTO {
        @Id
        private int courseID;
        private String courseName;
        private String courseDescription;
        private int courseCredits;
        @ManyToOne
        private Department courseDepartment;
        private int coursePrice;
}
