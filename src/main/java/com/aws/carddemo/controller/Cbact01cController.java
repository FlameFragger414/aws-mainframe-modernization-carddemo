package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for CBACT01C functionality.
 */
@RestController
@RequestMapping("/api/v1/cbact01c")
public class Cbact01cController extends BaseLegacyProgramController {

    public Cbact01cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "CBACT01C");
    }
}
