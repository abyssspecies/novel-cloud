package io.abyssspecies.tech.novel.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description...
 *
 * @author abyss species 2021-05
 */
@EnableEurekaServer
@SpringBootApplication
public class NovelRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovelRegisterApplication.class, args);
    }

}
