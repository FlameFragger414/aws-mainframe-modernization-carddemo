package com.aws.carddemo.service.business;

import com.aws.carddemo.model.dto.ProgramRequest;
import com.aws.carddemo.model.dto.ProgramResponse;
import com.aws.carddemo.model.dto.SignOnResponse;
import com.aws.carddemo.service.AccountService;
import com.aws.carddemo.service.CardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProgramExecutionServiceTest {

    @Mock private AuthenticationService authenticationService;
    @Mock private UserSecurityService userSecurityService;
    @Mock private TransactionProcessingService transactionProcessingService;
    @Mock private BillPaymentService billPaymentService;
    @Mock private BatchOrchestrationService batchOrchestrationService;
    @Mock private DateUtilityService dateUtilityService;
    @Mock private AccountService accountService;
    @Mock private CardService cardService;

    @InjectMocks
    private ProgramExecutionService programExecutionService;

    @Test
    void execute_cosgn00c_delegatesToAuthenticationService() {
        when(authenticationService.authenticate(any())).thenReturn(SignOnResponse.builder()
                .authenticated(true)
                .userId("USER0001")
                .userType("U")
                .redirectProgram("COMEN01C")
                .message("Sign-on successful")
                .build());

        ProgramResponse response = programExecutionService.execute("COSGN00C", ProgramRequest.builder()
                .parameters(Map.of("userId", "USER0001", "password", "PASSWORD"))
                .build());

        assertTrue(response.isSuccess());
        assertEquals("COSGN00C", response.getProgramName());
        assertEquals("COMEN01C", response.getData().get("redirectProgram"));
    }

    @Test
    void execute_unknownProgram_returnsFailure() {
        ProgramResponse response = programExecutionService.execute("UNKNOWN", ProgramRequest.builder().build());
        assertFalse(response.isSuccess());
    }
}
