package com.zw.jimfish.Smart.School.Management.System.SSMS.model.grade;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.classes.AcademicClass;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.utilities.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "grades", indexes = {
        @Index(name = "idx_grade_name", columnList = "name", unique = true)
})
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "min_marks", nullable = false)
    private Double minMarks;

    @NotNull
    @Column(name = "max_marks", nullable = false)
    private Double maxMarks;

    @Size(max = 200)
    private String description;

    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
    private List<AcademicClass> academicClasses;

    @Embedded
    private Audit audit;

    @Column(nullable = false)
    private boolean active = true;
}