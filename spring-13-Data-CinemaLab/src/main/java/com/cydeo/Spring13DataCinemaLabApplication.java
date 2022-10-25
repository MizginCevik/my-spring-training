package com.cydeo;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class Spring13DataCinemaLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring13DataCinemaLabApplication.class, args);
    }

    @Bean
    public MigrateResult migrateResult(DataSource dataSource) {
        return Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
    }

    //we are using flyway because we want to use version control.
    //whenever you put flyway dependency,
    //(spring.flyway.baseline-on-migrate=true) it's looking for database but table needs to be created already
    //(spring.flyway.enabled=false) -> come and look at in method which is in runner class

}
