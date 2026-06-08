package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COACTUPC functionality.
 */
@RestController
@RequestMapping("/api/v1/coactupc")
public class CoactupcController extends BaseLegacyProgramController {

    public CoactupcController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COACTUPC");
    }
}
