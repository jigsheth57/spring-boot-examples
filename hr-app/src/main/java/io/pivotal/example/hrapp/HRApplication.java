package io.pivotal.example.hrapp;

import io.pivotal.example.hrapp.domain.Employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@SpringBootApplication
@Import(RepositoryRestMvcConfiguration.class)
public class HRApplication extends RepositoryRestMvcConfiguration {
	
    @Override
    protected void configureRepositoryRestConfiguration( RepositoryRestConfiguration config) {
        config.exposeIdsFor(Employee.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(HRApplication.class, args);
    }
}
