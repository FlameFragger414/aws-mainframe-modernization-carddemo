package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COTRN00C functionality.
 */
@RestController
@RequestMapping("/api/v1/cotrn00c")
public class Cotrn00cController extends BaseLegacyProgramController {

    public Cotrn00cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COTRN00C");
    }
}
