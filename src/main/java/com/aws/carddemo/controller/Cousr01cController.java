package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COUSR01C functionality.
 */
@RestController
@RequestMapping("/api/v1/cousr01c")
public class Cousr01cController extends BaseLegacyProgramController {

    public Cousr01cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COUSR01C");
    }
}
