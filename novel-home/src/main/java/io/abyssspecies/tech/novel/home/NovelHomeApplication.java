package io.abyssspecies.tech.novel.home;

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
public class NovelHomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovelHomeApplication.class, args);
    }

}
