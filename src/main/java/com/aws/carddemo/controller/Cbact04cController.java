package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for CBACT04C functionality.
 */
@RestController
@RequestMapping("/api/v1/cbact04c")
public class Cbact04cController extends BaseLegacyProgramController {

    public Cbact04cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "CBACT04C");
    }
}
