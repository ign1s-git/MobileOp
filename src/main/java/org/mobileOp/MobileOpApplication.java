package org.mobileOp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.mobileOp.repositories")
@EntityScan(basePackages = "org.mobileOp.Objects")
public class MobileOpApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileOpApplication.class, args);
    }
}