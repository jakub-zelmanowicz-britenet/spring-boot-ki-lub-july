package pl.britenet.springbootkilubjuly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.britenet.campuslu.database.DatabaseService;
import pl.britenet.campuslu.service.ProductService;
import pl.britenet.campuslu.service.UserService;

@Configuration
public class ServiceConfig {

    private final DatabaseService databaseService;

    @Autowired
    public ServiceConfig(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @Bean
    public ProductService getProductService() {
        return new ProductService(this.databaseService);
    }

    @Bean
    public UserService getUserService() {
        return new UserService(this.databaseService);
    }
}
