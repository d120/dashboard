package de.d120.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class of the application.
 *
 * @author Fabian Damken
 */
@SpringBootApplication
public class D120DashboardApplication {
    /**
     * The main method.
     *
     * @param args
     *            The CLI arguments.
     */
    public static void main(final String[] args) {
        SpringApplication.run(D120DashboardApplication.class, args);
    }
}
