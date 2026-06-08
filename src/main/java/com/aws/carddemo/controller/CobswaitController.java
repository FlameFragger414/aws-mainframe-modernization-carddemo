package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COBSWAIT functionality.
 */
@RestController
@RequestMapping("/api/v1/cobswait")
public class CobswaitController extends BaseLegacyProgramController {

    public CobswaitController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COBSWAIT");
    }
}
