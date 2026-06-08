package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COADM01C functionality.
 */
@RestController
@RequestMapping("/api/v1/coadm01c")
public class Coadm01cController extends BaseLegacyProgramController {

    public Coadm01cController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COADM01C");
    }
}
