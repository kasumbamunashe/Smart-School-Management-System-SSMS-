package com.zw.jimfish.Smart.School.Management.System.SSMS.service.student;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.classes.AcademicClass;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.classes.ClassSection;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.grade.Grade;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.student.Student;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.student.StudentRequest;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.User;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.utilities.Role;
import com.zw.jimfish.Smart.School.Management.System.SSMS.repository.classes.AcademicClassRepository;
import com.zw.jimfish.Smart.School.Management.System.SSMS.repository.classes.ClassSectionRepository;
import com.zw.jimfish.Smart.School.Management.System.SSMS.repository.grade.GradeRepository;
import com.zw.jimfish.Smart.School.Management.System.SSMS.repository.student.StudentRepository;
import com.zw.jimfish.Smart.School.Management.System.SSMS.repository.user.UserRepository;
import com.zw.jimfish.Smart.School.Management.System.SSMS.service.exceptions.DuplicateResourceException;
import com.zw.jimfish.Smart.School.Management.System.SSMS.service.exceptions.InvalidFormatException;
import com.zw.jimfish.Smart.School.Management.System.SSMS.service.exceptions.ResourceNotFoundException;
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
    private final AcademicClassRepository academicClassRepository;
    private final GradeRepository gradeRepository;
    private final ClassSectionRepository classSectionRepository;
    private final UserRepository userRepository;


    @Override
    public Student addStudent(StudentRequest request) {
        if (!isValidEmail(request.getEmail())) {
            throw new InvalidFormatException("Invalid email address format");
        }
        AcademicClass academicClass = academicClassRepository.findById(request.getAcademicClassId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "AcademicClass not found with id: " + request.getAcademicClassId()));

        ClassSection classSection = null;
        if (request.getClassSectionId() != null) {
            classSection = classSectionRepository.findById(request.getClassSectionId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "ClassSection not found with id: " + request.getClassSectionId()));
        }

        Grade grade = null;
        if (request.getGradeId() != null) {
            grade = gradeRepository.findById(request.getGradeId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Grade not found with id: " + request.getGradeId()));
        }
        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already exists: " + request.getEmail());
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("User with this email already exists: " + request.getEmail());
        }

        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(Role.STUDENT)
                .build();


        Student student = Student.builder()
                .user(user)
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(request.getGender())
                .address(request.getAddress())
                .nextOfKin(request.getNextOfKin())
                .nextOfKinPhoneNumber(request.getNextOfKinPhoneNumber())
                .nextOfKinAddress(request.getNextOfKinAddress())
                .nextOfKinEmail(request.getNextOfKinEmail())
                .grade(grade)
                .academicClass(academicClass)
                .classSection(classSection)
                .active(true)
                .build();

        return studentRepository.save(student);
    }

    private boolean isValidEmail(String email) {
        if (email == null) return false;

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }



    @Override
    public Student updateStudent(Long studentId, StudentRequest request) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));

        if (request.getAddress() != null) {
            student.setAddress(request.getAddress());
        }
        if (request.getNextOfKin() != null) {
            student.setNextOfKin(request.getNextOfKin());
        }
        if (request.getNextOfKinPhoneNumber() != null) {
            student.setNextOfKinPhoneNumber(request.getNextOfKinPhoneNumber());
        }
        if (request.getNextOfKinAddress() != null) {
            student.setNextOfKinAddress(request.getNextOfKinAddress());
        }
        if (request.getNextOfKinEmail() != null) {
            // Validate email format if provided
            if (!isValidEmail(request.getNextOfKinEmail())) {
                throw new InvalidFormatException("Invalid next of kin email format");
            }
            student.setNextOfKinEmail(request.getNextOfKinEmail());
        }

        if (request.getAcademicClassId() != null) {
            AcademicClass academicClass = academicClassRepository.findById(request.getAcademicClassId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "AcademicClass not found with id: " + request.getAcademicClassId()));
            student.setAcademicClass(academicClass);
        }

        if (request.getClassSectionId() != null) {
            ClassSection classSection = classSectionRepository.findById(request.getClassSectionId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "ClassSection not found with id: " + request.getClassSectionId()));
            student.setClassSection(classSection);
        }

        // Update grade if provided
        if (request.getGradeId() != null) {
            Grade grade = gradeRepository.findById(request.getGradeId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Grade not found with id: " + request.getGradeId()));
            student.setGrade(grade);
        }

        if (request.getActive() != null) {
            student.setActive(request.getActive());
        }

        return studentRepository.save(student);
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
