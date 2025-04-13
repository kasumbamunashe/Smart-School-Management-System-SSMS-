package com.zw.jimfish.Smart.School.Management.System.SSMS.model.teacher;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.assessment.AssessmentMark;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.attendance.AttendanceRecord;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.classes.ClassSection;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.grade.Grade;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.timetable.TimetableEntry;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.User;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.utilities.Audit;
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
@Table(name = "teachers", indexes = {
        @Index(name = "idx_teacher_employee_number", columnList = "employeeNumber", unique = true)
})
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false)
    private String lastName;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, unique = true)
    private String employeeNumber;

    @Size(max = 200)
    private String address;

    @Size(max = 50)
    private String nextOfKin;

    @Size(max = 20)
    private String nextOfKinPhoneNumber;

    @ElementCollection
    @CollectionTable(name = "teacher_subjects", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "subject")
    private Set<String> subjects;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "teacher_grades",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "grade_id")
    )
    private Set<Grade> grades;

    @Embedded
    private Audit audit;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<TimetableEntry> timetableEntries;

    @OneToMany(mappedBy = "classTeacher", cascade = CascadeType.ALL)
    private List<ClassSection> classSections;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AssessmentMark> assessmentMarks;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttendanceRecord> attendanceRecords;

    @Column(nullable = false)
    private boolean active = true;
}