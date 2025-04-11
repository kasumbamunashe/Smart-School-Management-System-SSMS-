package com.zw.jimfish.Smart.School.Management.System.SSMS.controller.student;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.student.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {
    @GetMapping
    public String getAllStudents() {
        return "munashe";
        // implementation
    }
}
