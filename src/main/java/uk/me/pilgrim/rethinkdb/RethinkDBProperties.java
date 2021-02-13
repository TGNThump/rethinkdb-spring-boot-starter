package uk.me.pilgrim.rethinkdb;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("rethinkdb")
public class RethinkDBProperties {
    String hostname;
    int port;
}
