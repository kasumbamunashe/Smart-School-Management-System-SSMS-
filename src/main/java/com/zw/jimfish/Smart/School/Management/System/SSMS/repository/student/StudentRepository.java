package com.zw.jimfish.Smart.School.Management.System.SSMS.repository.student;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.student.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Boolean existsByEmail(String email);

   Page <Student> findByFirstNameContainingIgnoreCaseOrLastNameContaining(String firstName, String lastName, Pageable pageable);

}
