package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COTRN02C functionality.
 */
@RestController
@RequestMapping("/api/v1/cotrn02c")
public class Cotrn02cController extends BaseLegacyProgramController {

    public Cotrn02cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COTRN02C");
    }
}
