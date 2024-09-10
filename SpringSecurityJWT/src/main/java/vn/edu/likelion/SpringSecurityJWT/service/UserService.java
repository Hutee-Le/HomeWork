package vn.edu.likelion.SpringSecurityJWT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.likelion.SpringSecurityJWT.domain.UserEntity;
import vn.edu.likelion.SpringSecurityJWT.repository.UserRepository;
import vn.edu.likelion.SpringSecurityJWT.utils.PasswordUtil;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity handleCreateUser(UserEntity user) {
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public UserEntity fetchUserById(long id) {
        Optional<UserEntity> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    public List<UserEntity> fetchAllUser() {
        return this.userRepository.findAll();
    }

    public UserEntity handleUpdateUser(UserEntity reqUser) {
        UserEntity currentUser = this.fetchUserById(reqUser.getId());
        if (currentUser != null) {
            currentUser.setEmail(reqUser.getEmail());
            currentUser.setName(reqUser.getName());
            currentUser.setPassword(reqUser.getPassword());
            // update
            currentUser = this.userRepository.save(currentUser);
        }
        return currentUser;
    }

    public UserEntity handleGetUserByUsername(String username) {
        return this.userRepository.findByEmail(username);
    }

    public boolean changePassword(String username, String oldPassword, String newPassword) {
        UserEntity user = userRepository.findByEmail(username);
        if (user == null || !passwordEncoder.matches(oldPassword, user.getPassword())) {
            return false; // Invalid current password
        }

        if (!PasswordUtil.isValid(newPassword)) {
            throw new IllegalArgumentException("Password is too weak!");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        return true;
    }
}