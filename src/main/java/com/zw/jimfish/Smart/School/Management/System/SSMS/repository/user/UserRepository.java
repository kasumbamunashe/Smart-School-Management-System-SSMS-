package com.zw.jimfish.Smart.School.Management.System.SSMS.repository.user;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
}
