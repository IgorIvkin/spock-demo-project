package com.igorivkin.spockdemoproject.service;

import com.igorivkin.spockdemoproject.client.BankOperationsClient;
import com.igorivkin.spockdemoproject.model.BankAccount;
import com.igorivkin.spockdemoproject.model.BankOperation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class BankAccountService {

    private final BankOperationsClient bankOperationsClient;

    public BankAccountService(BankOperationsClient bankOperationsClient) {
        this.bankOperationsClient = bankOperationsClient;
    }

    /**
     * Возвращает список банковских операций за заданный период.
     *
     * @param from дата, от которой отсчитываются операции
     * @param to дата, до которой отсчитываются операции.
     * @return список операций за период
     */
    public List<BankOperation> getOperationsByPeriod(LocalDate from, LocalDate to) {
        return bankOperationsClient.getOperationsByPeriod(from, to);
    }

    /**
     * Проверяет, что банковский аккаунт достоин доверия. Аккаунт достоин доверия,
     * если он удовлетворяет любому из двух критериев:
     *  - на счету более 1 000 000 рублей
     *  - аккаунт имеет специальный режим обслуживания (specialClient = true)
     *
     * @return true, если аккаунт достоин доверия
     */
    public boolean isAccountTrustable(BankAccount account) {
        return account.isSpecialClient() || getAmount(account) > 1_000_000.0;
    }

    private Double getAmount(BankAccount account) {
        return Objects.requireNonNull(
                account.getAmount(),
                "Cannot get amount of bank account, amount is null"
        );
    }
}
