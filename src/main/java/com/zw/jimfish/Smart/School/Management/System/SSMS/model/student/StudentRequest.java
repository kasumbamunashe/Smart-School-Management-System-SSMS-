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
    private String email;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String address;
    private String nextOfKin;
    private String nextOfKinPhoneNumber;
    private String nextOfKinAddress;
    private String nextOfKinEmail;
    private Long gradeId;
    private Long academicClassId;
    private Long classSectionId;
    private Boolean active;
}
