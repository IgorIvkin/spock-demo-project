# Spock Testing framework

This application demonstrates some approaches to use **Spock Framework**,
a powerful testing framework written in Groovy. This framework is intended to
write unit- and integrations tests, has a strong support of Spring and can be used
in a practically any JVM project: Java, Kotlin, Groovy, Scala etc.

## Examples

### 1. Integration test with MVC layer testing
This integration test is located in `BankAccountControllerTest` class file. It demonstrates
that Spock Framework has a strong synergy to Spring. You can easily use Spring-related
annotations like `@WebMvcTest` to handle different scenarios.

It also displays a an approach to name the methods in Groovy using quoted strings.
It helps to write more self-describing test names.

### 2. Unit test with Data Driven Testing

Spock allows writing declarative tests. This approach is demonstrated in 
`BankAccountServiceTest` class file, method is `"bank account trustable check tests"()`
(yes, it is valid method name in Groovy).

Declarative data driven tests allow you to define scenario and provide a different cases
for this scenario in a declarative form.

For example:

```groovy
def test() {
    expect:
    a + b == c

    where:
    a | b | c
    3 | 4 | 7
}
```

The example contains a more detailed code that shows you can provide object-based
data for your test scenarios.

### 3. Unit test with mocking the external dependencies

Spock contains internal mocking mechanism. It supports all the mocking libraries
like `Mockito` but provides also its own implementation. 

The class file `BankAccountServiceTest` contains a test named `"get bank operations by period tests"()`.
This test shows how to mock an external dependency (in this case it's a client that
does REST API call) and write a test using this mock.

This approach also demonstrates an integration of Spock to Spring Framework.
For example an annotation `@SpringBean` allows to inject the mock to a required place
to use inside the application.

## Useful links

* [Spock framework official web-site](https://spockframework.org/)
