package io.abyssspecies.tech.novel.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description...
 *
 * @author abyss species 2021-05
 */
@EnableEurekaClient
@SpringBootApplication
public class NovelUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(NovelUserApplication.class, args);
    }
}
