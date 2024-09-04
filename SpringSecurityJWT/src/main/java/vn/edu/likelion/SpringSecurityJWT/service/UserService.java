package vn.edu.likelion.SpringSecurityJWT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.SpringSecurityJWT.domain.UserEntity;
import vn.edu.likelion.SpringSecurityJWT.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

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
}