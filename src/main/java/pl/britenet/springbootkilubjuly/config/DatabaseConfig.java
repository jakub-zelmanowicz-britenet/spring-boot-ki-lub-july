package pl.britenet.springbootkilubjuly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.britenet.campuslu.database.DatabaseService;

@Configuration
public class DatabaseConfig {

    @Bean
    public DatabaseService getDatabaseService() {
        return new DatabaseService();
    }

}
