package org.mobileOp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class MobileOpApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileOpApplication.class, args);
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
        System.out.println(System.currentTimeMillis());
    }
}