package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COCRDUPC functionality.
 */
@RestController
@RequestMapping("/api/v1/cocrdupc")
public class CocrdupcController extends BaseLegacyProgramController {

    public CocrdupcController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COCRDUPC");
    }
}
