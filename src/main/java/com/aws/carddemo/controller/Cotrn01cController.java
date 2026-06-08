package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COTRN01C functionality.
 */
@RestController
@RequestMapping("/api/v1/cotrn01c")
public class Cotrn01cController extends BaseLegacyProgramController {

    public Cotrn01cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COTRN01C");
    }
}
