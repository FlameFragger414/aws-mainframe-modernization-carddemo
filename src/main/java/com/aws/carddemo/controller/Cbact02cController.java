package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for CBACT02C functionality.
 */
@RestController
@RequestMapping("/api/v1/cbact02c")
public class Cbact02cController extends BaseLegacyProgramController {

    public Cbact02cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "CBACT02C");
    }
}
