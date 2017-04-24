package de.d120.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The main controller delivering the root page.
 *
 * @author Fabian Damken
 */
@Controller
@RequestMapping("/")
public class MainController {
    /**
     * Main method for delivering the root page.
     *
     * @return The name of the template to render.
     */
    @RequestMapping
    public String handleRequest() {
        return "main";
    }
}
