package io.github.bhuwanupadhyay.tutorial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private CustomerRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void canAddCustomer() {
        String name = "Vault - " + UUID.randomUUID().toString();
        repository.save(new Customer(name));
        assertEquals(name, repository.findAll().get(0).getName());
    }

}
