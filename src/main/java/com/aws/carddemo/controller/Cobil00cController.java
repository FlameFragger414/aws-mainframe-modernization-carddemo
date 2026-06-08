package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COBIL00C functionality.
 */
@RestController
@RequestMapping("/api/v1/cobil00c")
public class Cobil00cController extends BaseLegacyProgramController {

    public Cobil00cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COBIL00C");
    }
}
