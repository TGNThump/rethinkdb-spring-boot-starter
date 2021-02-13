package uk.me.pilgrim.rethinkdb;

import com.rethinkdb.net.Connection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicTests extends RethinkContainerBaseTest {

    @Autowired
    Connection connection;

    @Test
    public void connectionOpen(){
        assertThat(connection.isOpen());
    }
}
