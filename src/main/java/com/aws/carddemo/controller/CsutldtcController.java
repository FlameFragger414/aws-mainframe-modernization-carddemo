package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for CSUTLDTC functionality.
 */
@RestController
@RequestMapping("/api/v1/csutldtc")
public class CsutldtcController extends BaseLegacyProgramController {

    public CsutldtcController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "CSUTLDTC");
    }
}
