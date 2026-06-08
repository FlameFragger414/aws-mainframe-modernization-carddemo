package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COUSR03C functionality.
 */
@RestController
@RequestMapping("/api/v1/cousr03c")
public class Cousr03cController extends BaseLegacyProgramController {

    public Cousr03cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COUSR03C");
    }
}
