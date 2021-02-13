package uk.me.pilgrim.rethinkdb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public class RethinkContainerRunsTest {

    @Container
    public static final GenericContainer<?> rethinkdb = new GenericContainer<>(DockerImageName.parse("rethinkdb:2.4"))
            .withExposedPorts(28015)
            .waitingFor(Wait.forLogMessage("Server ready.*", 1));

    @Test
    public void containerRuns(){
        Assertions.assertTrue(rethinkdb.isRunning());
    }
}
