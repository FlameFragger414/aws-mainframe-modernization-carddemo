package com.aws.carddemo.controller;

import com.aws.carddemo.model.dto.BatchResult;
import com.aws.carddemo.service.business.BatchOrchestrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/batch")
@RequiredArgsConstructor
public class BatchController {

    private final BatchOrchestrationService batchService;

    @PostMapping("/accounts/import")
    public ResponseEntity<BatchResult> importAccounts(@RequestParam String inputFilePath) {
        return ResponseEntity.ok(batchService.importAccounts(inputFilePath));
    }

    @PostMapping("/cards/import")
    public ResponseEntity<BatchResult> importCards(@RequestParam String inputFilePath) {
        return ResponseEntity.ok(batchService.importCards(inputFilePath));
    }

    @PostMapping("/customers/import")
    public ResponseEntity<BatchResult> importCustomers(@RequestParam String inputFilePath) {
        return ResponseEntity.ok(batchService.importCustomers(inputFilePath));
    }

    @PostMapping("/xref/import")
    public ResponseEntity<BatchResult> importCrossReferences(@RequestParam String inputFilePath) {
        return ResponseEntity.ok(batchService.importCrossReferences(inputFilePath));
    }

    @PostMapping("/interest/calculate")
    public ResponseEntity<BatchResult> calculateInterest() {
        return ResponseEntity.ok(batchService.calculateInterest());
    }

    @PostMapping("/transactions/post")
    public ResponseEntity<BatchResult> postTransactions(@RequestParam String inputFilePath) {
        return ResponseEntity.ok(batchService.postDailyTransactions(inputFilePath));
    }

    @PostMapping("/full-cycle")
    public ResponseEntity<BatchResult> runFullCycle(
            @RequestParam String accountFile,
            @RequestParam String cardFile,
            @RequestParam String customerFile,
            @RequestParam String xrefFile,
            @RequestParam String dailyTranFile) {
        return ResponseEntity.ok(batchService.runFullBatchCycle(
                accountFile, cardFile, customerFile, xrefFile, dailyTranFile));
    }

    @GetMapping("/export")
    public ResponseEntity<Map<String, Object>> exportData() {
        return ResponseEntity.ok(batchService.exportData());
    }

    @GetMapping("/transactions/report")
    public ResponseEntity<Map<String, Object>> transactionReport() {
        return ResponseEntity.ok(batchService.transactionReport());
    }
}
