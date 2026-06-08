package com.aws.carddemo.service.business;

import com.aws.carddemo.exception.ValidationException;
import com.aws.carddemo.model.dto.*;
import com.aws.carddemo.model.entity.Account;
import com.aws.carddemo.model.entity.Card;
import com.aws.carddemo.model.entity.Csusr01Y;
import com.aws.carddemo.model.entity.Transaction;
import com.aws.carddemo.service.AccountService;
import com.aws.carddemo.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Central dispatcher mapping legacy COBOL program names to modernized business logic.
 */
@Service
@RequiredArgsConstructor
public class ProgramExecutionService {

    private final AuthenticationService authenticationService;
    private final UserSecurityService userSecurityService;
    private final TransactionProcessingService transactionProcessingService;
    private final BillPaymentService billPaymentService;
    private final BatchOrchestrationService batchOrchestrationService;
    private final DateUtilityService dateUtilityService;
    private final AccountService accountService;
    private final CardService cardService;

    public ProgramResponse execute(String programName, ProgramRequest request) {
        Map<String, Object> params = request != null && request.getParameters() != null
                ? request.getParameters()
                : Map.of();

        return switch (programName.toUpperCase()) {
            case "COSGN00C" -> executeSignOn(params);
            case "COMEN01C" -> executeMainMenu();
            case "COACTVWC" -> executeAccountView(params);
            case "COACTUPC" -> executeAccountUpdate(params);
            case "COCRDLIC" -> executeCardList();
            case "COCRDSLC" -> executeCardView(params);
            case "COCRDUPC" -> executeCardUpdate(params);
            case "COTRN00C" -> executeTransactionList(params);
            case "COTRN01C" -> executeTransactionView(params);
            case "COTRN02C" -> executeTransactionAdd(params);
            case "CORPT00C" -> executeTransactionReport();
            case "COBIL00C" -> executeBillPayment(params);
            case "COADM01C" -> executeAdminMenu();
            case "COUSR00C" -> executeUserList();
            case "COUSR01C" -> executeUserAdd(params);
            case "COUSR02C" -> executeUserUpdate(params);
            case "COUSR03C" -> executeUserDelete(params);
            case "COBSWAIT" -> executeWait(params);
            case "CBACT01C" -> executeAccountImport(params);
            case "CBACT02C" -> executeCardImport(params);
            case "CBACT03C" -> executeXrefImport(params);
            case "CBACT04C" -> executeInterestCalculation();
            case "CBCUS01C" -> executeCustomerImport(params);
            case "CBTRN01C" -> executeTransactionBatch(params);
            case "CBTRN02C" -> executeDailyTransactionPost(params);
            case "CBTRN03C" -> executeBatchTransactionReport();
            case "CBIMPORT" -> executeFullBatchImport(params);
            case "CBEXPORT" -> executeDataExport();
            case "CSUTLDTC" -> executeDateUtility(params);
            default -> ProgramResponse.failure(programName, "Unknown program: " + programName);
        };
    }

    public Map<String, Object> getProgramStatus(String programName) {
        Map<String, Object> status = new HashMap<>();
        status.put("programName", programName.toUpperCase());
        status.put("status", "Active");
        status.put("implementation", "Java/Spring Boot");
        return status;
    }

    private ProgramResponse executeSignOn(Map<String, Object> params) {
        SignOnRequest request = SignOnRequest.builder()
                .userId(stringParam(params, "userId"))
                .password(stringParam(params, "password"))
                .build();
        SignOnResponse response = authenticationService.authenticate(request);
        Map<String, Object> data = new HashMap<>();
        data.put("userId", response.getUserId());
        data.put("userType", response.getUserType());
        data.put("redirectProgram", response.getRedirectProgram());
        return ProgramResponse.success("COSGN00C", response.getMessage(), data);
    }

    private ProgramResponse executeMainMenu() {
        Map<String, Object> data = new HashMap<>();
        data.put("title", "CardDemo Main Menu");
        data.put("endpoint", "/api/v1/navigation/menu");
        return ProgramResponse.success("COMEN01C", "Main menu available via navigation API", data);
    }

    private ProgramResponse executeAccountView(Map<String, Object> params) {
        Long accountId = longParam(params, "accountId");
        Account account = accountService.findById(accountId);
        Map<String, Object> data = new HashMap<>();
        data.put("account", account);
        return ProgramResponse.success("COACTVWC", "Account retrieved", data);
    }

    private ProgramResponse executeAccountUpdate(Map<String, Object> params) {
        Long accountId = longParam(params, "accountId");
        AccountUpdateDTO dto = AccountUpdateDTO.builder()
                .acctActiveStatus(stringParam(params, "acctActiveStatus"))
                .acctCurrBal(bigDecimalParam(params, "acctCurrBal"))
                .acctCreditLimit(bigDecimalParam(params, "acctCreditLimit"))
                .acctCashCreditLimit(bigDecimalParam(params, "acctCashCreditLimit"))
                .acctOpenDate(stringParam(params, "acctOpenDate"))
                .acctExpirationDate(stringParam(params, "acctExpirationDate"))
                .acctGroupId(stringParam(params, "acctGroupId"))
                .custId(longParam(params, "custId"))
                .custFirstName(stringParam(params, "custFirstName"))
                .custMiddleName(stringParam(params, "custMiddleName"))
                .custLastName(stringParam(params, "custLastName"))
                .custAddrLine1(stringParam(params, "custAddrLine1"))
                .custAddrLine2(stringParam(params, "custAddrLine2"))
                .custAddrLine3(stringParam(params, "custAddrLine3"))
                .custAddrStateCd(stringParam(params, "custAddrStateCd"))
                .custAddrZip(stringParam(params, "custAddrZip"))
                .custPhoneNum1(stringParam(params, "custPhoneNum1"))
                .custPhoneNum2(stringParam(params, "custPhoneNum2"))
                .custSsn(longParam(params, "custSsn"))
                .custFicoScore(integerParam(params, "custFicoScore"))
                .oldActiveStatus(stringParam(params, "oldActiveStatus"))
                .oldCurrBal(bigDecimalParam(params, "oldCurrBal"))
                .oldCreditLimit(bigDecimalParam(params, "oldCreditLimit"))
                .build();
        Account updated = accountService.updateAccount(accountId, dto);
        Map<String, Object> data = new HashMap<>();
        data.put("account", updated);
        return ProgramResponse.success("COACTUPC", "Account updated successfully", data);
    }

    private ProgramResponse executeCardList() {
        List<Card> cards = cardService.findAll();
        Map<String, Object> data = new HashMap<>();
        data.put("cards", cards);
        data.put("count", cards.size());
        return ProgramResponse.success("COCRDLIC", "Card list retrieved", data);
    }

    private ProgramResponse executeCardView(Map<String, Object> params) {
        String cardNum = stringParam(params, "cardNum");
        Card card = cardService.findById(cardNum);
        Map<String, Object> data = new HashMap<>();
        data.put("card", card);
        return ProgramResponse.success("COCRDSLC", "Card retrieved", data);
    }

    private ProgramResponse executeCardUpdate(Map<String, Object> params) {
        String cardNum = stringParam(params, "cardNum");
        CardUpdateDTO dto = CardUpdateDTO.builder()
                .cardEmbossedName(stringParam(params, "cardEmbossedName"))
                .cardActiveStatus(stringParam(params, "cardActiveStatus"))
                .expiryMonth(stringParam(params, "expiryMonth"))
                .expiryYear(stringParam(params, "expiryYear"))
                .build();
        Card updated = cardService.updateCard(cardNum, dto);
        Map<String, Object> data = new HashMap<>();
        data.put("card", updated);
        return ProgramResponse.success("COCRDUPC", "Card updated successfully", data);
    }

    private ProgramResponse executeTransactionList(Map<String, Object> params) {
        List<Transaction> transactions = params.containsKey("accountId")
                ? transactionProcessingService.listTransactionsByAccount(longParam(params, "accountId"))
                : transactionProcessingService.listTransactions();
        Map<String, Object> data = new HashMap<>();
        data.put("transactions", transactions);
        data.put("count", transactions.size());
        return ProgramResponse.success("COTRN00C", "Transaction list retrieved", data);
    }

    private ProgramResponse executeTransactionView(Map<String, Object> params) {
        Transaction transaction = transactionProcessingService.getTransaction(stringParam(params, "tranId"));
        Map<String, Object> data = new HashMap<>();
        data.put("transaction", transaction);
        return ProgramResponse.success("COTRN01C", "Transaction retrieved", data);
    }

    private ProgramResponse executeTransactionAdd(Map<String, Object> params) {
        TransactionDTO dto = buildTransactionDto(params);
        Transaction transaction = transactionProcessingService.addTransaction(dto);
        Map<String, Object> data = new HashMap<>();
        data.put("transaction", transaction);
        return ProgramResponse.success("COTRN02C", "Transaction added successfully", data);
    }

    private ProgramResponse executeTransactionReport() {
        Map<String, Object> report = batchOrchestrationService.transactionReport();
        return ProgramResponse.success("CORPT00C", "Transaction report generated", report);
    }

    private ProgramResponse executeBillPayment(Map<String, Object> params) {
        BillPaymentRequest request = BillPaymentRequest.builder()
                .accountId(longParam(params, "accountId"))
                .confirmed(booleanParam(params, "confirmed"))
                .build();
        Map<String, Object> result = billPaymentService.processBillPayment(request);
        return ProgramResponse.success("COBIL00C", String.valueOf(result.get("message")), result);
    }

    private ProgramResponse executeAdminMenu() {
        Map<String, Object> data = new HashMap<>();
        data.put("title", "CardDemo Admin Menu");
        data.put("options", List.of("List Users", "Add User", "Update User", "Delete User"));
        return ProgramResponse.success("COADM01C", "Admin menu available", data);
    }

    private ProgramResponse executeUserList() {
        List<Csusr01Y> users = userSecurityService.listUsers();
        Map<String, Object> data = new HashMap<>();
        data.put("users", users);
        data.put("count", users.size());
        return ProgramResponse.success("COUSR00C", "User list retrieved", data);
    }

    private ProgramResponse executeUserAdd(Map<String, Object> params) {
        UserRequest request = buildUserRequest(params);
        Csusr01Y user = userSecurityService.addUser(request);
        Map<String, Object> data = new HashMap<>();
        data.put("user", user);
        return ProgramResponse.success("COUSR01C", "User added successfully", data);
    }

    private ProgramResponse executeUserUpdate(Map<String, Object> params) {
        String userId = stringParam(params, "userId");
        UserRequest request = buildUserRequest(params);
        Csusr01Y user = userSecurityService.updateUser(userId, request);
        Map<String, Object> data = new HashMap<>();
        data.put("user", user);
        return ProgramResponse.success("COUSR02C", "User updated successfully", data);
    }

    private ProgramResponse executeUserDelete(Map<String, Object> params) {
        String userId = stringParam(params, "userId");
        userSecurityService.deleteUser(userId);
        return ProgramResponse.success("COUSR03C", "User deleted successfully");
    }

    private ProgramResponse executeWait(Map<String, Object> params) {
        int seconds = integerParam(params, "seconds");
        if (seconds <= 0) {
            seconds = 1;
        }
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            return ProgramResponse.failure("COBSWAIT", "Wait interrupted");
        }
        Map<String, Object> data = new HashMap<>();
        data.put("secondsWaited", seconds);
        return ProgramResponse.success("COBSWAIT", "Wait completed", data);
    }

    private ProgramResponse executeAccountImport(Map<String, Object> params) {
        BatchResult result = batchOrchestrationService.importAccounts(stringParam(params, "inputFilePath"));
        return toBatchResponse(result);
    }

    private ProgramResponse executeCardImport(Map<String, Object> params) {
        BatchResult result = batchOrchestrationService.importCards(stringParam(params, "inputFilePath"));
        return toBatchResponse(result);
    }

    private ProgramResponse executeXrefImport(Map<String, Object> params) {
        BatchResult result = batchOrchestrationService.importCrossReferences(stringParam(params, "inputFilePath"));
        return toBatchResponse(result);
    }

    private ProgramResponse executeInterestCalculation() {
        BatchResult result = batchOrchestrationService.calculateInterest();
        return toBatchResponse(result);
    }

    private ProgramResponse executeCustomerImport(Map<String, Object> params) {
        BatchResult result = batchOrchestrationService.importCustomers(stringParam(params, "inputFilePath"));
        return toBatchResponse(result);
    }

    private ProgramResponse executeTransactionBatch(Map<String, Object> params) {
        BatchResult result = batchOrchestrationService.postDailyTransactions(stringParam(params, "inputFilePath"));
        return toBatchResponse(result);
    }

    private ProgramResponse executeDailyTransactionPost(Map<String, Object> params) {
        return executeTransactionBatch(params);
    }

    private ProgramResponse executeBatchTransactionReport() {
        Map<String, Object> report = batchOrchestrationService.transactionReport();
        return ProgramResponse.success("CBTRN03C", "Batch transaction report generated", report);
    }

    private ProgramResponse executeFullBatchImport(Map<String, Object> params) {
        BatchResult result = batchOrchestrationService.runFullBatchCycle(
                stringParam(params, "accountFile"),
                stringParam(params, "cardFile"),
                stringParam(params, "customerFile"),
                stringParam(params, "xrefFile"),
                stringParam(params, "dailyTranFile"));
        return toBatchResponse(result);
    }

    private ProgramResponse executeDataExport() {
        Map<String, Object> export = batchOrchestrationService.exportData();
        return ProgramResponse.success("CBEXPORT", "Data export completed", export);
    }

    private ProgramResponse executeDateUtility(Map<String, Object> params) {
        Map<String, Object> result = dateUtilityService.convertDate(
                stringParam(params, "inputDate"),
                stringParam(params, "targetFormat"));
        return ProgramResponse.success("CSUTLDTC", "Date conversion completed", result);
    }

    private ProgramResponse toBatchResponse(BatchResult result) {
        Map<String, Object> data = new HashMap<>();
        data.put("recordsProcessed", result.getRecordsProcessed());
        data.put("recordsRejected", result.getRecordsRejected());
        if (result.isSuccess()) {
            return ProgramResponse.success(result.getProgramName(), result.getMessage(), data);
        }
        return ProgramResponse.failure(result.getProgramName(), result.getMessage());
    }

    private TransactionDTO buildTransactionDto(Map<String, Object> params) {
        return TransactionDTO.builder()
                .tranId(stringParam(params, "tranId"))
                .tranTypeCd(stringParam(params, "tranTypeCd"))
                .tranCatCd(integerParam(params, "tranCatCd"))
                .tranSource(stringParam(params, "tranSource"))
                .tranDesc(stringParam(params, "tranDesc"))
                .tranAmt(bigDecimalParam(params, "tranAmt"))
                .tranMerchantId(integerParam(params, "tranMerchantId"))
                .tranMerchantName(stringParam(params, "tranMerchantName"))
                .tranMerchantCity(stringParam(params, "tranMerchantCity"))
                .tranMerchantZip(stringParam(params, "tranMerchantZip"))
                .tranCardNum(stringParam(params, "tranCardNum"))
                .accountId(longParam(params, "accountId"))
                .build();
    }

    private UserRequest buildUserRequest(Map<String, Object> params) {
        return UserRequest.builder()
                .userId(stringParam(params, "userId"))
                .firstName(stringParam(params, "firstName"))
                .lastName(stringParam(params, "lastName"))
                .password(stringParam(params, "password"))
                .userType(stringParam(params, "userType"))
                .build();
    }

    private String stringParam(Map<String, Object> params, String key) {
        Object value = params.get(key);
        return value != null ? value.toString() : null;
    }

    private Long longParam(Map<String, Object> params, String key) {
        Object value = params.get(key);
        if (value == null) {
            throw new ValidationException("Missing required parameter: " + key);
        }
        if (value instanceof Number number) {
            return number.longValue();
        }
        return Long.parseLong(value.toString());
    }

    private Integer integerParam(Map<String, Object> params, String key) {
        Object value = params.get(key);
        if (value == null) {
            return null;
        }
        if (value instanceof Number number) {
            return number.intValue();
        }
        return Integer.parseInt(value.toString());
    }

    private BigDecimal bigDecimalParam(Map<String, Object> params, String key) {
        Object value = params.get(key);
        if (value == null) {
            return null;
        }
        if (value instanceof BigDecimal decimal) {
            return decimal;
        }
        if (value instanceof Number number) {
            return BigDecimal.valueOf(number.doubleValue());
        }
        return new BigDecimal(value.toString());
    }

    private boolean booleanParam(Map<String, Object> params, String key) {
        Object value = params.get(key);
        if (value == null) {
            return false;
        }
        if (value instanceof Boolean bool) {
            return bool;
        }
        return Boolean.parseBoolean(value.toString());
    }
}
