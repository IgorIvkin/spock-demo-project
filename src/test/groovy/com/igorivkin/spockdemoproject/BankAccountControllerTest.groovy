package com.igorivkin.spockdemoproject

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
@AutoConfigureMockMvc
class BankAccountControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    def "hello world with status 200"() {
        expect: "Hello world method returns 200 and 'Hello world!'"
        mockMvc.perform(get("/hello-world"))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .response.contentAsString == "Hello world!"
    }

    def "404 for non-defined endpoint"() {
        expect: "Non-existing endpoint returns 404"
        mockMvc.perform(get("/something-undefined"))
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()))
    }
}
