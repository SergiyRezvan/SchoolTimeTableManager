package ua.kharkiv.riezvan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SchoolTimeTableManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolTimeTableManagerApplication.class, args);
    }

}
