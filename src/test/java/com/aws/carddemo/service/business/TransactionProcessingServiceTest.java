package com.aws.carddemo.service.business;

import com.aws.carddemo.exception.ValidationException;
import com.aws.carddemo.model.dto.TransactionDTO;
import com.aws.carddemo.model.entity.Account;
import com.aws.carddemo.model.entity.Transaction;
import com.aws.carddemo.repository.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionProcessingServiceTest {

    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private CardRepository cardRepository;
    @Mock
    private Cvact03YRepository xrefRepository;
    @Mock
    private Cvtra01YRepository tcatBalRepository;

    @InjectMocks
    private TransactionProcessingService transactionProcessingService;

    @Test
    void addTransaction_updatesAccountBalance() {
        Account account = Account.builder()
                .acctId(10000000001L)
                .acctCurrBal(new BigDecimal("100.00"))
                .acctCreditLimit(new BigDecimal("5000.00"))
                .acctCurrCycCredit(BigDecimal.ZERO)
                .acctCurrCycDebit(BigDecimal.ZERO)
                .build();

        when(transactionRepository.existsById("TXN001")).thenReturn(false);
        when(accountRepository.findById(10000000001L)).thenReturn(Optional.of(account));
        when(tcatBalRepository.findByTrancatAcctIdAndTrancatTypeCdAndTrancatCd(any(), any(), any()))
                .thenReturn(List.of());
        when(transactionRepository.save(any(Transaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

        TransactionDTO dto = TransactionDTO.builder()
                .tranId("TXN001")
                .tranTypeCd("01")
                .tranCatCd(1)
                .tranAmt(new BigDecimal("50.00"))
                .accountId(10000000001L)
                .build();

        Transaction result = transactionProcessingService.addTransaction(dto);

        assertEquals("TXN001", result.getTranId());
        ArgumentCaptor<Account> accountCaptor = ArgumentCaptor.forClass(Account.class);
        verify(accountRepository).save(accountCaptor.capture());
        assertEquals(new BigDecimal("150.00"), accountCaptor.getValue().getAcctCurrBal());
    }

    @Test
    void addTransaction_overLimit_throwsValidationException() {
        Account account = Account.builder()
                .acctId(10000000001L)
                .acctCurrBal(new BigDecimal("100.00"))
                .acctCreditLimit(new BigDecimal("100.00"))
                .acctCurrCycCredit(BigDecimal.ZERO)
                .acctCurrCycDebit(BigDecimal.ZERO)
                .build();

        when(transactionRepository.existsById("TXN002")).thenReturn(false);
        when(accountRepository.findById(10000000001L)).thenReturn(Optional.of(account));

        TransactionDTO dto = TransactionDTO.builder()
                .tranId("TXN002")
                .tranTypeCd("01")
                .tranCatCd(1)
                .tranAmt(new BigDecimal("150.00"))
                .accountId(10000000001L)
                .build();

        assertThrows(ValidationException.class, () -> transactionProcessingService.addTransaction(dto));
    }
}
