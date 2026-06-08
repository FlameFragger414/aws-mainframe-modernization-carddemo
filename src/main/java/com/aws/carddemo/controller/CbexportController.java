package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for CBEXPORT functionality.
 */
@RestController
@RequestMapping("/api/v1/cbexport")
public class CbexportController extends BaseLegacyProgramController {

    public CbexportController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "CBEXPORT");
    }
}
