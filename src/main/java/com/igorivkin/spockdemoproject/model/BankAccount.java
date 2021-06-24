package com.igorivkin.spockdemoproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    private Long number;
    private String type;
    private String title;
    private Double amount;
    private boolean specialClient;
}
