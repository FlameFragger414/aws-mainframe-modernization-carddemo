package com.aws.carddemo.controller;

import com.aws.carddemo.service.business.ProgramExecutionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for COCRDLIC functionality.
 */
@RestController
@RequestMapping("/api/v1/cocrdlic")
public class CocrdlicController extends BaseLegacyProgramController {

    public CocrdlicController(ProgramExecutionService programExecutionService) {
        super(programExecutionService, "COCRDLIC");
    }
}
