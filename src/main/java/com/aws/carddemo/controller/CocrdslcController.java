package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COCRDSLC functionality.
 */
@RestController
@RequestMapping("/api/v1/cocrdslc")
public class CocrdslcController extends BaseLegacyProgramController {

    public CocrdslcController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COCRDSLC");
    }
}
