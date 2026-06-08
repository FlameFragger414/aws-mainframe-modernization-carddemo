package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COMEN01C functionality.
 */
@RestController
@RequestMapping("/api/v1/comen01c")
public class Comen01cController extends BaseLegacyProgramController {

    public Comen01cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COMEN01C");
    }
}
