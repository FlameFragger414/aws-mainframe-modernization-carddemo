package com.aws.carddemo.controller;

import com.aws.carddemo.model.dto.SignOnRequest;
import com.aws.carddemo.model.dto.SignOnResponse;
import com.aws.carddemo.service.business.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signon")
    public ResponseEntity<SignOnResponse> signOn(@RequestBody SignOnRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
