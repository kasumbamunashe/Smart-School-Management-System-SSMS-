package com.zw.jimfish.Smart.School.Management.System.SSMS.controller.student;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.student.Student;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.student.StudentRequest;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.User;
import com.zw.jimfish.Smart.School.Management.System.SSMS.service.student.StudentService;
import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/Student")
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/getAll")
    public ResponseEntity<Page<Student>> getAllStudents(@Nullable String searchParam,
                                                        Pageable pageable) {

        return ResponseEntity.ok(studentService.getStudents(searchParam,pageable));
    }
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody StudentRequest request) {
        return ResponseEntity.ok(studentService.addStudent(request));
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.getById(studentId));
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody StudentRequest request) {
        return ResponseEntity.ok(studentService.updateStudent(studentId, request));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.deleteStudent(studentId));
    }

}
