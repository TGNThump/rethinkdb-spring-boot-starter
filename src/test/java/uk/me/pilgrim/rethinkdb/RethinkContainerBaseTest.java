package uk.me.pilgrim.rethinkdb;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(RethinkDBExtension.class)
@SpringBootTest
public class RethinkContainerBaseTest {

    @SpringBootConfiguration
    @EnableAutoConfiguration
    public static class Configuration{}
}
