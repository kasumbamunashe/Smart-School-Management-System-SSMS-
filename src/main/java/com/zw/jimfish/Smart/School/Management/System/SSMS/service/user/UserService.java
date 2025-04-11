package com.zw.jimfish.Smart.School.Management.System.SSMS.service.user;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.User;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    User createUser(UserRequest request);
    Optional<User> findUserByEmail(String email);
    Page<User>getAllUsers(Pageable pageable);
    Optional<User> findUserById(Long id);
}
