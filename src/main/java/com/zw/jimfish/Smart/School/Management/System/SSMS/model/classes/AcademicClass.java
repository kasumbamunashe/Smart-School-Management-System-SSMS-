package com.zw.jimfish.Smart.School.Management.System.SSMS.model.classes;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.grade.Grade;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.student.Student;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.subject.Subject;
import com.zw.jimfish.Smart.School.Management.System.SSMS.utilities.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "academic_classes")
public class AcademicClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @ManyToMany
    @JoinTable(
            name = "class_subjects",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects;

    @OneToMany(mappedBy = "academicClass")
    private List<Student> students;

    @OneToMany(mappedBy = "academicClass", cascade = CascadeType.ALL)
    private List<ClassSection> sections;

    @Embedded
    private Audit audit;

    @Column(nullable = false)
    private boolean active = true;
}