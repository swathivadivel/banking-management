package com.project.bms_backend.dto;

import com.project.bms_backend.entity.Account;
import com.project.bms_backend.entity.Customer;

public class AccountMapper {

    public static AccountDto mapToAccountDto(Account account){
        return new AccountDto(
                account.getAccountId(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getAccountType()
        );
    }
}
