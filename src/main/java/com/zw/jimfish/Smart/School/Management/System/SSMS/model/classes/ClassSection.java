package com.zw.jimfish.Smart.School.Management.System.SSMS.model.classes;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.student.Student;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.teacher.Teacher;
import com.zw.jimfish.Smart.School.Management.System.SSMS.utilities.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "class_sections", indexes = {
        @Index(name = "idx_section_name_class", columnList = "academic_class_id, name", unique = true)
})
public class ClassSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false)
    private String name; // e.g., "A", "B", "Science", "Arts"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_class_id", nullable = false)
    private AcademicClass academicClass;


    @OneToMany(mappedBy = "classSection")
    private List<Student> students;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_teacher_id")
    private Teacher classTeacher;

    @Size(max = 200)
    private String description;

    @Embedded
    private Audit audit;

    @Column(nullable = false)
    private boolean active = true;
}