package com.aws.carddemo.service.business;

import com.aws.carddemo.exception.ValidationException;
import com.aws.carddemo.model.dto.SignOnRequest;
import com.aws.carddemo.model.dto.SignOnResponse;
import com.aws.carddemo.model.entity.Csusr01Y;
import com.aws.carddemo.repository.Csusr01YRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

    @Mock
    private Csusr01YRepository userRepository;

    @InjectMocks
    private AuthenticationService authenticationService;

    @Test
    void authenticate_backOfficeUser_redirectsToMainMenu() {
        when(userRepository.findById("USER0001")).thenReturn(Optional.of(
                Csusr01Y.builder()
                        .secUsrId("USER0001")
                        .secUsrPwd("PASSWORD")
                        .secUsrType("U")
                        .build()));

        SignOnResponse response = authenticationService.authenticate(SignOnRequest.builder()
                .userId("user0001")
                .password("password")
                .build());

        assertTrue(response.isAuthenticated());
        assertEquals("USER0001", response.getUserId());
        assertEquals("COMEN01C", response.getRedirectProgram());
    }

    @Test
    void authenticate_adminUser_redirectsToAdminMenu() {
        when(userRepository.findById("ADMIN001")).thenReturn(Optional.of(
                Csusr01Y.builder()
                        .secUsrId("ADMIN001")
                        .secUsrPwd("PASSWORD")
                        .secUsrType("A")
                        .build()));

        SignOnResponse response = authenticationService.authenticate(SignOnRequest.builder()
                .userId("admin001")
                .password("PASSWORD")
                .build());

        assertEquals("COADM01C", response.getRedirectProgram());
    }

    @Test
    void authenticate_wrongPassword_throwsValidationException() {
        when(userRepository.findById("USER0001")).thenReturn(Optional.of(
                Csusr01Y.builder()
                        .secUsrId("USER0001")
                        .secUsrPwd("PASSWORD")
                        .secUsrType("U")
                        .build()));

        assertThrows(ValidationException.class, () -> authenticationService.authenticate(SignOnRequest.builder()
                .userId("USER0001")
                .password("WRONG")
                .build()));
    }
}
