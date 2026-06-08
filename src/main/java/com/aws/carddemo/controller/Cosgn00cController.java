package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COSGN00C functionality.
 */
@RestController
@RequestMapping("/api/v1/cosgn00c")
public class Cosgn00cController extends BaseLegacyProgramController {

    public Cosgn00cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COSGN00C");
    }
}
