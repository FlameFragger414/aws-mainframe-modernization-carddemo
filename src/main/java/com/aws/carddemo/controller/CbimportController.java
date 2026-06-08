package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for CBIMPORT functionality.
 */
@RestController
@RequestMapping("/api/v1/cbimport")
public class CbimportController extends BaseLegacyProgramController {

    public CbimportController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "CBIMPORT");
    }
}
