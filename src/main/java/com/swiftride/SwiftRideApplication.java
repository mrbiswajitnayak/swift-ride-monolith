package com.swiftride;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SwiftRideApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwiftRideApplication.class, args);
    }
}