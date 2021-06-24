package com.igorivkin.spockdemoproject

import com.igorivkin.spockdemoproject.client.BankOperationsClient
import com.igorivkin.spockdemoproject.model.BankAccount
import com.igorivkin.spockdemoproject.model.BankOperation
import com.igorivkin.spockdemoproject.model.BankOperationType
import com.igorivkin.spockdemoproject.service.BankAccountService
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import java.time.LocalDate

@ContextConfiguration(classes = [
        BankAccountService.class,
        BankOperationsClient.class,
        RestTemplate.class
])
class BankAccountServiceTest extends Specification {

    @Autowired
    BankAccountService bankAccountService

    @SpringBean
    BankOperationsClient bankOperationsClient = Mock()

    def "bank account trustable check tests"() {
        expect:
        bankAccountService.isAccountTrustable(bankAccount) == trustable

        where:
        bankAccount                                              | trustable
        new BankAccount(specialClient: false, amount: 100.0)     | false
        new BankAccount(specialClient: false, amount: 999999.0)  | false
        new BankAccount(specialClient: true, amount: 100.0)      | true
        new BankAccount(specialClient: false, amount: 1200000.0) | true
    }


    def "get bank operations by period tests"() {
        when:
        List<BankOperation> operations = bankAccountService.getOperationsByPeriod(LocalDate.now(), LocalDate.now())

        then:
        1 * bankOperationsClient.getOperationsByPeriod(_, _) >> [
                new BankOperation(type: BankOperationType.DEBIT, delta: 3455.0, bankAccountNumber: 1213L),
                new BankOperation(type: BankOperationType.DEBIT, delta: 10200.0, bankAccountNumber: 1213L)
        ]

        then:
        operations.size() == 2
    }

}
