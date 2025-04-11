package com.zw.jimfish.Smart.School.Management.System.SSMS.model.assessment;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.grade.Grade;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.student.Student;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.subject.Subject;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.teacher.Teacher;
import com.zw.jimfish.Smart.School.Management.System.SSMS.utilities.AssessmentType;
import com.zw.jimfish.Smart.School.Management.System.SSMS.utilities.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "assessment_marks", indexes = {
        @Index(name = "idx_assessment_student_subject", columnList = "student_id, subject_id"),
        @Index(name = "idx_assessment_date", columnList = "date")
})
public class AssessmentMark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id", nullable = false)
    private Grade grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssessmentType assessmentType;

    @NotNull
    @Column(nullable = false)
    private Double marks;

    @Column(nullable = false)
    private LocalDate date;

    @Size(max = 500)
    private String comments;

    @Embedded
    private Audit audit;
}