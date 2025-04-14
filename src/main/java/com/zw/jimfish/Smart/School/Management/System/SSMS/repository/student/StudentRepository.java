package com.zw.jimfish.Smart.School.Management.System.SSMS.repository.student;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Boolean existsByEmail(String email);
}
