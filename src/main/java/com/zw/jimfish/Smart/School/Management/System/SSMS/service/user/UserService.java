package com.zw.jimfish.Smart.School.Management.System.SSMS.service.user;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.User;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    User createUser(UserRequest request);

    Page<User>getAllUsers(Pageable pageable);

    User findUserById(Long id);

    User updateUser(Long id, UserRequest request);
    void deleteUser(Long id);
}
