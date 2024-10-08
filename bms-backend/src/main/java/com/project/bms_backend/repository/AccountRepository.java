package com.project.bms_backend.repository;

import com.project.bms_backend.entity.Account;
import com.project.bms_backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {


}
