package com.example.ms.proveedor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories

@SpringBootApplication
public class MsProveedorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProveedorApplication.class, args);
    }

}
