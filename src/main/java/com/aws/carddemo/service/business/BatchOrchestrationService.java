package com.aws.carddemo.service.business;

import com.aws.carddemo.batch.AccountImportBatch;
import com.aws.carddemo.batch.CardImportBatch;
import com.aws.carddemo.batch.CrossRefImportBatch;
import com.aws.carddemo.batch.CustomerImportBatch;
import com.aws.carddemo.model.dto.BatchResult;
import com.aws.carddemo.model.entity.Account;
import com.aws.carddemo.model.entity.Card;
import com.aws.carddemo.model.entity.Customer;
import com.aws.carddemo.model.entity.Transaction;
import com.aws.carddemo.repository.AccountRepository;
import com.aws.carddemo.repository.CardRepository;
import com.aws.carddemo.repository.CustomerRepository;
import com.aws.carddemo.repository.TransactionRepository;
import com.aws.carddemo.service.impl.InterestCalculationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BatchOrchestrationService {

    private final AccountImportBatch accountImportBatch;
    private final CardImportBatch cardImportBatch;
    private final CustomerImportBatch customerImportBatch;
    private final CrossRefImportBatch crossRefImportBatch;
    private final InterestCalculationServiceImpl interestCalculationService;
    private final TransactionProcessingService transactionProcessingService;
    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    public BatchResult importAccounts(String inputFilePath) {
        accountImportBatch.runImport(inputFilePath);
        return success("CBACT01C", "Account import completed");
    }

    public BatchResult importCards(String inputFilePath) {
        int count = cardImportBatch.runImport(inputFilePath);
        return success("CBACT02C", "Imported " + count + " card records");
    }

    public BatchResult importCrossReferences(String inputFilePath) {
        int count = crossRefImportBatch.runImport(inputFilePath);
        return success("CBACT03C", "Imported " + count + " cross-reference records");
    }

    public BatchResult importCustomers(String inputFilePath) {
        int count = customerImportBatch.runImport(inputFilePath);
        return success("CBCUS01C", "Imported " + count + " customer records");
    }

    public BatchResult calculateInterest() {
        interestCalculationService.calculateMonthlyInterest();
        return success("CBACT04C", "Monthly interest calculation completed");
    }

    public BatchResult postDailyTransactions(String inputFilePath) {
        return transactionProcessingService.postDailyTransactions(inputFilePath);
    }

    public Map<String, Object> exportData() {
        List<Account> accounts = accountRepository.findAll();
        List<Card> cards = cardRepository.findAll();
        List<Customer> customers = customerRepository.findAll();
        List<Transaction> transactions = transactionRepository.findAll();

        Map<String, Object> export = new HashMap<>();
        export.put("accounts", accounts);
        export.put("cards", cards);
        export.put("customers", customers);
        export.put("transactions", transactions);
        export.put("accountCount", accounts.size());
        export.put("cardCount", cards.size());
        export.put("customerCount", customers.size());
        export.put("transactionCount", transactions.size());
        return export;
    }

    public BatchResult runFullBatchCycle(String accountFile, String cardFile, String customerFile,
                                         String xrefFile, String dailyTranFile) {
        importAccounts(accountFile);
        importCards(cardFile);
        importCustomers(customerFile);
        importCrossReferences(xrefFile);
        BatchResult posting = postDailyTransactions(dailyTranFile);
        calculateInterest();
        return BatchResult.builder()
                .programName("CBIMPORT")
                .recordsProcessed(posting.getRecordsProcessed())
                .recordsRejected(posting.getRecordsRejected())
                .success(posting.isSuccess())
                .message("Full batch cycle completed")
                .build();
    }

    public Map<String, Object> transactionReport() {
        List<Transaction> transactions = transactionRepository.findAll();
        Map<String, Object> report = new HashMap<>();
        report.put("programName", "CBTRN03C");
        report.put("transactionCount", transactions.size());
        report.put("transactions", transactions);
        return report;
    }

    private BatchResult success(String programName, String message) {
        return BatchResult.builder()
                .programName(programName)
                .success(true)
                .message(message)
                .build();
    }
}
