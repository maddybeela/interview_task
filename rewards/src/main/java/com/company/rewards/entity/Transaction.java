package com.company.rewards.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="USER_TRANSACTIONS")
@NoArgsConstructor
@Data
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="CUSTOMER_NAME")
    String customerName;

    @Column(name="TRANSACTION_ID")
    String transactionId;

    @Column(name="TRANSACTION_AMOUNT")
    Integer transactionAmount;

    @Column(name="TRANSACTION_DATE")
    LocalDate transactionDate;

}
