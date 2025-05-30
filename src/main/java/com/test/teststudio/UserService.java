package com.test.teststudio;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Logging
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Logging
    public User getUser(Long userId) {
        testMethod(1);
        return userRepository.findById(userId);
    }

    @Logging
    private void testMethod(int a) {

    }

    @Logging
    public void saveUser(User user) {
        validateUser(user);
        userRepository.save(user);
    }

    @Logging
    private void validateUser(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (user.getAge() < 0) {
            throw new IllegalArgumentException("Age must be greater than or equal to 0");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
    }

}
