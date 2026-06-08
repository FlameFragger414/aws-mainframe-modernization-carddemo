package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for CORPT00C functionality.
 */
@RestController
@RequestMapping("/api/v1/corpt00c")
public class Corpt00cController extends BaseLegacyProgramController {

    public Corpt00cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "CORPT00C");
    }
}
