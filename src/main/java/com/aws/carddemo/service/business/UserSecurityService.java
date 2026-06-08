package com.aws.carddemo.service.business;

import com.aws.carddemo.exception.ResourceNotFoundException;
import com.aws.carddemo.exception.ValidationException;
import com.aws.carddemo.model.dto.UserRequest;
import com.aws.carddemo.model.entity.Csusr01Y;
import com.aws.carddemo.repository.Csusr01YRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSecurityService {

    private final Csusr01YRepository userRepository;

    public List<Csusr01Y> listUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public Csusr01Y addUser(UserRequest request) {
        validateUserRequest(request, true);

        String userId = request.getUserId().trim().toUpperCase();
        if (userRepository.existsById(userId)) {
            throw new ValidationException("User ID already exists: " + userId);
        }

        Csusr01Y user = Csusr01Y.builder()
                .secUsrId(userId)
                .secUsrFname(request.getFirstName().trim())
                .secUsrLname(request.getLastName().trim())
                .secUsrPwd(request.getPassword().trim().toUpperCase())
                .secUsrType(request.getUserType().trim().toUpperCase())
                .build();

        return userRepository.save(user);
    }

    @Transactional
    public Csusr01Y updateUser(String userId, UserRequest request) {
        Csusr01Y user = userRepository.findById(userId.toUpperCase())
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));

        if (request.getFirstName() != null && !request.getFirstName().isBlank()) {
            user.setSecUsrFname(request.getFirstName().trim());
        }
        if (request.getLastName() != null && !request.getLastName().isBlank()) {
            user.setSecUsrLname(request.getLastName().trim());
        }
        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            user.setSecUsrPwd(request.getPassword().trim().toUpperCase());
        }
        if (request.getUserType() != null && !request.getUserType().isBlank()) {
            user.setSecUsrType(request.getUserType().trim().toUpperCase());
        }

        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String userId) {
        if (!userRepository.existsById(userId.toUpperCase())) {
            throw new ResourceNotFoundException("User not found: " + userId);
        }
        userRepository.deleteById(userId.toUpperCase());
    }

    public Csusr01Y getUser(String userId) {
        return userRepository.findById(userId.toUpperCase())
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));
    }

    private void validateUserRequest(UserRequest request, boolean requireAll) {
        if (request.getFirstName() == null || request.getFirstName().isBlank()) {
            throw new ValidationException("First Name can NOT be empty...");
        }
        if (request.getLastName() == null || request.getLastName().isBlank()) {
            throw new ValidationException("Last Name can NOT be empty...");
        }
        if (requireAll && (request.getUserId() == null || request.getUserId().isBlank())) {
            throw new ValidationException("User ID can NOT be empty...");
        }
        if (requireAll && (request.getPassword() == null || request.getPassword().isBlank())) {
            throw new ValidationException("Password can NOT be empty...");
        }
        if (requireAll && (request.getUserType() == null || request.getUserType().isBlank())) {
            throw new ValidationException("User Type can NOT be empty...");
        }
    }
}
