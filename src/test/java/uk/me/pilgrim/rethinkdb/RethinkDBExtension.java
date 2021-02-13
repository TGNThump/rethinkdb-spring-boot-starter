package uk.me.pilgrim.rethinkdb;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

public class RethinkDBExtension  implements BeforeAllCallback, AfterAllCallback {
    private GenericContainer<?> rethinkdb;

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        rethinkdb = new GenericContainer<>(DockerImageName.parse("rethinkdb:2.4"))
                .withExposedPorts(28015)
                .waitingFor(Wait.forLogMessage("Server ready.*", 1));

        rethinkdb.start();
        System.setProperty("rethinkdb.hostname", rethinkdb.getHost());
        System.setProperty("rethinkdb.port", rethinkdb.getFirstMappedPort().toString());
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        rethinkdb.stop();
    }
}
