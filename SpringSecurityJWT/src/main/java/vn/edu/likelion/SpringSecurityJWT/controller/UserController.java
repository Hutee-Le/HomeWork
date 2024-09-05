package vn.edu.likelion.SpringSecurityJWT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.SpringSecurityJWT.domain.UserEntity;
import vn.edu.likelion.SpringSecurityJWT.service.UserService;
import vn.edu.likelion.SpringSecurityJWT.utils.error.IdInvalidException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/users")
    public ResponseEntity<UserEntity> createNewUser(@RequestBody UserEntity reqUser) {
        String hashPassword = passwordEncoder.encode(reqUser.getPassword());
        reqUser.setPassword(hashPassword);
        UserEntity user = userService.handleCreateUser(reqUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) throws IdInvalidException {
        if (id >= 1500) {
            throw new IdInvalidException("Id không lớn hơn 1501");
        }
        userService.handleDeleteUser(id);
        return ResponseEntity.ok("User deleted");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") long id) {
        UserEntity fetchUser = userService.fetchUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(fetchUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.fetchAllUser());
    }

    @PutMapping("/users")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user) {
        UserEntity updateUser = userService.handleUpdateUser(user);
        return ResponseEntity.ok(updateUser);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminAccess() {
        return "Admin Access";
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/user")
    public String userAccess() {
        return "User Access";
    }
}
