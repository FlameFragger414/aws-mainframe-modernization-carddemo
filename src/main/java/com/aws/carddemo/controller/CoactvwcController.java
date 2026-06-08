package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COACTVWC functionality.
 */
@RestController
@RequestMapping("/api/v1/coactvwc")
public class CoactvwcController extends BaseLegacyProgramController {

    public CoactvwcController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COACTVWC");
    }
}
