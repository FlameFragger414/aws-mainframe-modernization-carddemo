package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for CBACT03C functionality.
 */
@RestController
@RequestMapping("/api/v1/cbact03c")
public class Cbact03cController extends BaseLegacyProgramController {

    public Cbact03cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "CBACT03C");
    }
}
