package com.zw.jimfish.Smart.School.Management.System.SSMS.model.teacher;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.utilities.Gender;

import java.util.Set;

public class TeacherRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String employeeNumber;
    private String address;
    private String nextOfKin;
    private String nextOfKinPhoneNumber;
    private Set<Long> subjectsId;
    private Set<String> gradeNames;
    private Gender gender;
    private boolean active;
}
