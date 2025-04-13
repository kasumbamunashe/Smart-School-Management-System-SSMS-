package com.zw.jimfish.Smart.School.Management.System.SSMS.model.student;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.assessment.AssessmentMark;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.attendance.AttendanceRecord;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.classes.AcademicClass;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.classes.ClassSection;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.grade.Grade;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.parent.Parent;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.User;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.utilities.Audit;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.utilities.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "students", indexes = {
        @Index(name = "idx_student_grade", columnList = "grade_id")
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Email
    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Size(max = 200)
    private String address;

    @Size(max = 50)
    private String nextOfKin;

    @Size(max = 20)
    private String nextOfKinPhoneNumber;

    @Size(max = 200)
    private String nextOfKinAddress;

    @Size(max = 100)
    private String nextOfKinEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @Embedded
    private Audit audit;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AssessmentMark> assessmentMarks;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttendanceRecord> attendanceRecords;

    @ManyToMany(mappedBy = "children")
    private List<Parent> parents;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_class_id")
    private AcademicClass academicClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_section_id")
    private ClassSection classSection;

    @Column(nullable = false)
    private boolean active = true;
}