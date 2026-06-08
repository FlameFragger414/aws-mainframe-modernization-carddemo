package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COUSR00C functionality.
 */
@RestController
@RequestMapping("/api/v1/cousr00c")
public class Cousr00cController extends BaseLegacyProgramController {

    public Cousr00cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COUSR00C");
    }
}
