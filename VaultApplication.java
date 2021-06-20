package com.cloud.config.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Cloud application.
 * layer 1 - Main layer.
 */
@EnableAdminServer
@EnableConfigServer
@SpringBootApplication
@RestController
public class VaultApplication {

    /**
     * The entry point of application.
     * First micro service to deploy
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(VaultApplication.class);
    }

}
