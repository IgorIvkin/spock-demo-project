package com.igorivkin.spockdemoproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankOperation {
    private BankOperationType type;
    private Instant created;
    private Long bankAccountNumber;
    private Double delta;
}
