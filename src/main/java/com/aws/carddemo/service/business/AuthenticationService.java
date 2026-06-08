package com.aws.carddemo.service.business;

import com.aws.carddemo.exception.ValidationException;
import com.aws.carddemo.model.dto.SignOnRequest;
import com.aws.carddemo.model.dto.SignOnResponse;
import com.aws.carddemo.model.entity.Csusr01Y;
import com.aws.carddemo.repository.Csusr01YRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final Csusr01YRepository userRepository;

    public SignOnResponse authenticate(SignOnRequest request) {
        if (request.getUserId() == null || request.getUserId().isBlank()) {
            throw new ValidationException("Please enter User ID ...");
        }
        if (request.getPassword() == null || request.getPassword().isBlank()) {
            throw new ValidationException("Please enter Password ...");
        }

        String userId = request.getUserId().trim().toUpperCase();
        String password = request.getPassword().trim().toUpperCase();

        Csusr01Y user = userRepository.findById(userId)
                .orElseThrow(() -> new ValidationException("User not found. Try again ..."));

        if (!password.equals(user.getSecUsrPwd())) {
            throw new ValidationException("Wrong Password. Try again ...");
        }

        String redirectProgram = isAdmin(user.getSecUsrType()) ? "COADM01C" : "COMEN01C";

        return SignOnResponse.builder()
                .authenticated(true)
                .userId(userId)
                .userType(user.getSecUsrType())
                .redirectProgram(redirectProgram)
                .message("Sign-on successful")
                .build();
    }

    private boolean isAdmin(String userType) {
        return userType != null && ("A".equalsIgnoreCase(userType) || "ADMIN".equalsIgnoreCase(userType));
    }
}
