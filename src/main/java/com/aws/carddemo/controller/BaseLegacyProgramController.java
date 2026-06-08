package com.aws.carddemo.controller;

import com.aws.carddemo.model.dto.ProgramRequest;
import com.aws.carddemo.model.dto.ProgramResponse;
import com.aws.carddemo.service.business.ProgramExecutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Base controller for migrated COBOL program REST endpoints.
 */
@RequiredArgsConstructor
public abstract class BaseLegacyProgramController {

    private final ProgramExecutionService programExecutionService;
    private final String programName;

    @PostMapping("/execute")
    public ResponseEntity<ProgramResponse> execute(@RequestBody(required = false) ProgramRequest request) {
        ProgramResponse response = programExecutionService.execute(
                programName,
                request != null ? request : ProgramRequest.builder().build());
        return response.isSuccess()
                ? ResponseEntity.ok(response)
                : ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getStatus() {
        return ResponseEntity.ok(programExecutionService.getProgramStatus(programName));
    }

    @GetMapping("/detail/{n}")
    public ResponseEntity<Map<String, Object>> getDetail(@PathVariable int n) {
        Map<String, Object> detail = new HashMap<>();
        detail.put("programName", programName);
        detail.put("detailIndex", n);
        detail.put("description", "Migrated from legacy " + programName + " COBOL program");
        detail.put("status", "implemented");
        return ResponseEntity.ok(detail);
    }
}
