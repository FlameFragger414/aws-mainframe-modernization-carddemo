package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for CBTRN02C functionality.
 */
@RestController
@RequestMapping("/api/v1/cbtrn02c")
public class Cbtrn02cController extends BaseLegacyProgramController {

    public Cbtrn02cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "CBTRN02C");
    }
}
