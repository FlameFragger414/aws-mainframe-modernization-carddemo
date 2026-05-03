package com.aws.carddemo.service.impl;

import com.aws.carddemo.exception.ResourceNotFoundException;
import com.aws.carddemo.exception.ValidationException;
import com.aws.carddemo.model.dto.AccountUpdateDTO;
import com.aws.carddemo.model.entity.Account;
import com.aws.carddemo.model.entity.Customer;
import com.aws.carddemo.repository.AccountRepository;
import com.aws.carddemo.repository.CustomerRepository;
import com.aws.carddemo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    private final CustomerRepository customerRepository;

    @Override
    public Account save(Account entity) {
        return repository.save(entity);
    }

    @Override
    public Account findById(Object id) {
        return repository.findById((Long)id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
    }

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById((Long)id);
    }

    @Override
    @Transactional
    public Account updateAccount(Long accountId, AccountUpdateDTO updateDto) {
        // 1. Fetch existing records (Simulating CICS READ UPDATE)
        Account account = repository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found: " + accountId));
        
        Customer customer = customerRepository.findById(updateDto.getCustId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + updateDto.getCustId()));

        // 2. Optimistic Locking Check (Simulating 9700-CHECK-CHANGE-IN-REC)
        validateNoConcurrentChanges(account, updateDto);

        // 3. Deep Validation Logic (Simulating 1200-EDIT-MAP-INPUTS)
        performDeepValidation(updateDto);

        // 4. Apply Updates (Simulating 9600-WRITE-PROCESSING)
        mapUpdateDtoToEntities(updateDto, account, customer);

        // 5. Persist Changes (Simulating REWRITE)
        customerRepository.save(customer);
        return repository.save(account);
    }

    private void validateNoConcurrentChanges(Account account, AccountUpdateDTO dto) {
        if (!account.getAcctActiveStatus().equals(dto.getOldActiveStatus()) ||
            account.getAcctCurrBal().compareTo(dto.getOldCurrBal()) != 0 ||
            account.getAcctCreditLimit().compareTo(dto.getOldCreditLimit()) != 0) {
            throw new ValidationException("Record changed by someone else. Please review.");
        }
    }

    private void performDeepValidation(AccountUpdateDTO dto) {
        if (!"Y".equalsIgnoreCase(dto.getAcctActiveStatus()) && !"N".equalsIgnoreCase(dto.getAcctActiveStatus())) {
            throw new ValidationException("Account Active Status must be Y or N");
        }
        if (dto.getCustSsn() != null) {
            long ssnPart1 = dto.getCustSsn() / 1000000;
            if (ssnPart1 == 0 || ssnPart1 == 666 || (ssnPart1 >= 900 && ssnPart1 <= 999)) {
                throw new ValidationException("Invalid SSN: Part 1 rules violated");
            }
        }
        if (dto.getCustFicoScore() != null && (dto.getCustFicoScore() < 300 || dto.getCustFicoScore() > 850)) {
            throw new ValidationException("Invalid FICO score range");
        }
    }

    private void mapUpdateDtoToEntities(AccountUpdateDTO dto, Account account, Customer customer) {
        account.setAcctActiveStatus(dto.getAcctActiveStatus());
        account.setAcctCurrBal(dto.getAcctCurrBal());
        account.setAcctCreditLimit(dto.getAcctCreditLimit());
        account.setAcctCashCreditLimit(dto.getAcctCashCreditLimit());
        account.setAcctOpenDate(dto.getAcctOpenDate());
        account.setAcctExpirationDate(dto.getAcctExpirationDate());
        account.setAcctGroupId(dto.getAcctGroupId());

        customer.setCustFirstName(dto.getCustFirstName());
        customer.setCustMiddleName(dto.getCustMiddleName());
        customer.setCustLastName(dto.getCustLastName());
        customer.setCustAddrLine1(dto.getCustAddrLine1());
        customer.setCustAddrLine2(dto.getCustAddrLine2());
        customer.setCustAddrLine3(dto.getCustAddrLine3());
        customer.setCustAddrStateCd(dto.getCustAddrStateCd());
        customer.setCustAddrZip(dto.getCustAddrZip());
        customer.setCustPhoneNum1(dto.getCustPhoneNum1());
        customer.setCustPhoneNum2(dto.getCustPhoneNum2());
        customer.setCustFicoCreditScore(dto.getCustFicoScore());
    }
}
