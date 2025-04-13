package com.zw.jimfish.Smart.School.Management.System.SSMS.service.student;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.student.Student;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.student.StudentRequest;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.UserRequest;
import com.zw.jimfish.Smart.School.Management.System.SSMS.repository.student.StudentRepository;
import com.zw.jimfish.Smart.School.Management.System.SSMS.service.exceptions.InvalidFormatException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@Slf4j
@Data
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private boolean isValidEmail(String email) {
        if (email == null) return false;


        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private boolean isValidPhoneNumber(String phone) {
        if (phone == null) return false;

        String digitsOnly = phone.replaceAll("[^0-9]", "");

        return digitsOnly.length() >= 8 && digitsOnly.length() <= 15;
    }
    @Override
    public Student addStudent(StudentRequest request) {
        if (!isValidEmail(request.getEmail())) {
            throw new InvalidFormatException("Invalid email address format");
        }

        if (!isValidPhoneNumber(request.getPhone())) {
            throw new InvalidFormatException("Invalid phone number format");
        }

        Student student = Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .nextOfKin(request.getNextOfKin())
                .nextOfKinEmail(request.getNextOfKinEmail())
                .nextOfKinPhoneNumber(request.getNextOfKinAddress())
                .nextOfKinAddress(request.getNextOfKinAddress())
                .academicClass(request.getAcademicClass())
                .assessmentMarks(request.getAssessmentMarks())
                
                .active(true)

                .build();

        return null;
    }


    @Override
    public Student updateStudent(StudentRequest request) {
        return null;
    }

    @Override
    public Student deleteStudent(Long id) {
        return null;
    }

    @Override
    public Student getStudent(Long id) {
        return null;
    }

    @Override
    public Page<Student> getStudents(String searchParam, Pageable pageable) {
        return null;
    }

    @Override
    public Student getById(Long id) {
        return null;
    }
}
