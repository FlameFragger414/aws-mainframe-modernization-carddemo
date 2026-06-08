package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COUSR02C functionality.
 */
@RestController
@RequestMapping("/api/v1/cousr02c")
public class Cousr02cController extends BaseLegacyProgramController {

    public Cousr02cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COUSR02C");
    }
}
