package com.example.demo;

import org.hibernate.sql.ast.tree.expression.Distinct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class DistributionServiceTest {

    @TestConfiguration
    public static class DistributionServiceTestContext {

        @Bean
        public DistributionService distributionService() {
            return new DistributionService();
        }

    }

    @Autowired
    private DistributionService service;

    @MockBean
    private DistributionRepository repository;

    @Test
    public void selectAllTest() {
        Mockito.when(repository.findAll()).thenReturn(List.of(new Distribution()));

        List<Distribution> result = service.selectAll();

        Assertions.assertEquals(1, result.size());
    }

}
