package com.zw.jimfish.Smart.School.Management.System.SSMS.model.student;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.assessment.AssessmentMark;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.attendance.AttendanceRecord;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.classes.AcademicClass;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.classes.ClassSection;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.grade.Grade;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.parent.Parent;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.utilities.Audit;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.utilities.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Gender gender;
    private String nextOfKin;
    private String nextOfKinAddress;
    private String nextOfKinEmail;
    private Grade grade;
    private List<AssessmentMark> assessmentMarks;
    private List<AttendanceRecord> attendanceRecords;
    private List<Parent> parents;
    private AcademicClass academicClass;
    private ClassSection classSection;
}
