package com.zw.jimfish.Smart.School.Management.System.SSMS.service.user;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.User;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.UserRequest;
import com.zw.jimfish.Smart.School.Management.System.SSMS.repository.user.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@Data
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(UserRequest request) {
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

    @Override
    public Optional<User> findUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {

        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return Optional.empty();
    }
}
