package com.zw.jimfish.Smart.School.Management.System.SSMS.controller.user;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.User;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.UserRequest;
import com.zw.jimfish.Smart.School.Management.System.SSMS.service.user.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/User")
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity <User> addUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }
    @GetMapping("/getAll")
    public ResponseEntity <Page<User>> getAllUsers(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(userService.getAllUsers(pageable));
    }
}
