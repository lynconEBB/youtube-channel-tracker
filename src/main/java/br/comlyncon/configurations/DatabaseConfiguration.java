package br.comlyncon.configurations;

import br.comlyncon.models.DatabaseProperties;
import org.apache.commons.configuration.ConfigurationException;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public DataSource dataSource() throws IOException, ConfigurationException {
        DatabaseProperties databaseProperties = new DatabaseProperties();
        return DataSourceBuilder.create()
                .password(databaseProperties.getPassword())
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://"+ databaseProperties.getHost() +":"+databaseProperties.getPort()+"/"+databaseProperties.getName())
                .username(databaseProperties.getUser())
                .build();
    }

}
