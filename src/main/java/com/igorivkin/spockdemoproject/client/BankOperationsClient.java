package com.igorivkin.spockdemoproject.client;

import com.igorivkin.spockdemoproject.model.BankOperation;
import com.igorivkin.spockdemoproject.model.BankOperationList;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class BankOperationsClient {
    private final RestTemplate restTemplate;

    public BankOperationsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Возвращает список банковских операций за заданный период.
     *
     * @param from дата, от которой отсчитываются операции
     * @param to дата, до которой отсчитываются операции.
     * @return список операций за период
     */
    public List<BankOperation> getOperationsByPeriod(LocalDate from, LocalDate to) {
        BankOperationList operationList = restTemplate.getForObject("...", BankOperationList.class);
        return Optional.ofNullable(operationList)
                .map(BankOperationList::getOperations)
                .orElseThrow(() -> new IllegalStateException("Cannot retrieve operations, operations list is null"));
    }
}
