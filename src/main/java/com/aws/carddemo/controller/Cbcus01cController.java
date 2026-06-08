package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for CBCUS01C functionality.
 */
@RestController
@RequestMapping("/api/v1/cbcus01c")
public class Cbcus01cController extends BaseLegacyProgramController {

    public Cbcus01cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "CBCUS01C");
    }
}
