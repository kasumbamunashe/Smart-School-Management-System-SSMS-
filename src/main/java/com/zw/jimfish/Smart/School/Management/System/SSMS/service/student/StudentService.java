package com.zw.jimfish.Smart.School.Management.System.SSMS.service.student;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.student.Student;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.student.StudentRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    Student addStudent(StudentRequest request);
    Student updateStudent(StudentRequest request);
    Student deleteStudent(Long id);
    Student getStudent(Long id);
    Page<Student> getStudents(String searchParam,Pageable pageable);
    Student getById(Long id);
}
