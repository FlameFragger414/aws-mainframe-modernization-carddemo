package com.aws.carddemo.config;

import com.aws.carddemo.model.entity.Csusr01Y;
import com.aws.carddemo.repository.Csusr01YRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Seeds default CardDemo users (parity with legacy USRSEC sample data).
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final Csusr01YRepository userRepository;

    @Override
    public void run(String... args) {
        seedUser("USER0001", "Regular", "User", "PASSWORD", "U");
        seedUser("ADMIN001", "Admin", "User", "PASSWORD", "A");
    }

    private void seedUser(String userId, String firstName, String lastName, String password, String userType) {
        if (!userRepository.existsById(userId)) {
            userRepository.save(Csusr01Y.builder()
                    .secUsrId(userId)
                    .secUsrFname(firstName)
                    .secUsrLname(lastName)
                    .secUsrPwd(password)
                    .secUsrType(userType)
                    .build());
            log.info("Seeded default user: {}", userId);
        }
    }
}
