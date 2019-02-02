package app.theone.service.impl;

import app.theone.entity.Role;
import app.theone.entity.User;
import app.theone.repository.RoleRepository;
import app.theone.repository.UserRepository;
import app.theone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public User addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        Optional<Role> roleId = roleRepository.findById(1L);
        Set<Role> userRoles = user.getRoles();
        userRoles.add(roleId.get());
        return userRepository.save(user);
    }

    @Override
    public void removeUser(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long userId) {
        Optional<User> byId = userRepository.findById(userId);
        return byId.orElseGet(User::new);
    }
    @Override
    public boolean updateUser(User updatedUser) {
        System.out.println("UserID: " + updatedUser.getUserId());
        Optional<User> optionalUser = userRepository.findById(updatedUser.getUserId());
        if(optionalUser.isPresent()) {
            User dbUser = optionalUser.get();
            dbUser.setUserName(updatedUser.getUserName());
            dbUser.setEmail(updatedUser.getEmail());
            dbUser.setPassword(encoder.encode(updatedUser.getPassword()));
            userRepository.save(dbUser);
            return true;
        }
        return false;
    }
}
