package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
public class DistributionRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private DistributionRepository repository;

    @Test
    public void findFirstByCodenameTest() {
        Distribution debian = new Distribution();
        debian.setName("Debian");
        debian.setVersion("12");
        debian.setCodename("bookworm");

        testEntityManager.persist(debian);

        Distribution result = repository.findFirstByCodename("bookworm");

        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals(debian.getName(), result.getName());
        Assertions.assertEquals(debian.getVersion(), result.getVersion());
        Assertions.assertEquals(debian.getCodename(), result.getCodename());
    }

    @Test
    public void whereCodenameTest() {
        Distribution debian = new Distribution();
        debian.setName("Debian");
        debian.setVersion("12");
        debian.setCodename("bookworm");

        testEntityManager.persist(debian);

        Distribution result = repository.whereCodename("bookworm");

        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals(debian.getName(), result.getName());
        Assertions.assertEquals(debian.getVersion(), result.getVersion());
        Assertions.assertEquals(debian.getCodename(), result.getCodename());
    }

}
