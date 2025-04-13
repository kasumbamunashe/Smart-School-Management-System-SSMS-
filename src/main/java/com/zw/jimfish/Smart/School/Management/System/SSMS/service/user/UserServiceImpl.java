package com.zw.jimfish.Smart.School.Management.System.SSMS.service.user;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.User;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.UserRequest;
import com.zw.jimfish.Smart.School.Management.System.SSMS.repository.user.UserRepository;
import com.zw.jimfish.Smart.School.Management.System.SSMS.service.exceptions.InvalidFormatException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
@Slf4j
@Data
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(UserRequest request) {
        if (!isValidEmail(request.getEmail())) {
            throw new InvalidFormatException("Invalid email address format");
        }

        if (!isValidPhoneNumber(request.getPhone())) {
            throw new InvalidFormatException("Invalid phone number format");
        }

        User user = User.builder()
                .firstName(request.getFirstName())
                .username(request.getEmail())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .address(request.getAddress())
                .build();

        return userRepository.save(user);
    }

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
    public Page<User> getAllUsers(Pageable pageable) {

        return userRepository.findAll(pageable);
    }

    @Override
    public User findUserById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw  new RuntimeException("User not found");
        }
        return optionalUser.get();
    }


    @Override
    public User updateUser(Long id, UserRequest request) {
        if (!isValidEmail(request.getEmail())) {
            throw new InvalidFormatException("Invalid email address format");
        }

        if (!isValidPhoneNumber(request.getPhone())) {
            throw new InvalidFormatException("Invalid phone number format");
        }
        User existingUser = findUserById(id);
        existingUser.setFirstName(request.getFirstName());
        existingUser.setLastName(request.getLastName());
        existingUser.setEmail(request.getEmail());
        existingUser.setPhone(request.getPhone());
        existingUser.setRole(request.getRole());
        existingUser.setAddress(request.getAddress());
        existingUser.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(existingUser);
    }
    @Override
     public void deleteUser(Long id) {
        User existingUser = findUserById(id);
         userRepository.delete(existingUser);
    }
}
