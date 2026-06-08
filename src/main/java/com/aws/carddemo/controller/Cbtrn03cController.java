package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for CBTRN03C functionality.
 */
@RestController
@RequestMapping("/api/v1/cbtrn03c")
public class Cbtrn03cController extends BaseLegacyProgramController {

    public Cbtrn03cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "CBTRN03C");
    }
}
