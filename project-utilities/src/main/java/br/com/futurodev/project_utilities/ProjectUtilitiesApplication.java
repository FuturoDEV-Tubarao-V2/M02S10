package br.com.futurodev.project_utilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProjectUtilitiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectUtilitiesApplication.class, args);
    }

}
