package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for CBTRN01C functionality.
 */
@RestController
@RequestMapping("/api/v1/cbtrn01c")
public class Cbtrn01cController extends BaseLegacyProgramController {

    public Cbtrn01cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "CBTRN01C");
    }
}
