package uk.me.pilgrim.rethinkdb;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Log4j2
@Configuration
@Import(RethinkDBProperties.class)
public class RethinkDBAutoConfiguration {

    public static final RethinkDB r = RethinkDB.r;

    @Bean
    @ConditionalOnMissingBean(Connection.class)
    public Connection connection(RethinkDBProperties rethinkDBProperties){
        log.info(rethinkDBProperties);
        return r.connection().hostname(rethinkDBProperties.getHostname()).port(rethinkDBProperties.getPort()).connect();
    }
}
