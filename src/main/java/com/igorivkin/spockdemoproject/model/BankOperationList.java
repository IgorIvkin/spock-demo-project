package com.igorivkin.spockdemoproject.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BankOperationList {
    private List<BankOperation> operations;

    public BankOperationList() {
        this.operations = new ArrayList<>();
    }
}
