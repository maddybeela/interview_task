package com.company.rewards.repository;

import com.company.rewards.entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Long> {

    @Query(value = "select distinct CUSTOMER_NAME from USER_TRANSACTIONS", nativeQuery = true)
    List<String> findUniqueCustomer();
    List<Transaction> findByCustomerNameAndTransactionDateBetween(String customerName, LocalDate startDate, LocalDate endDate);
}
