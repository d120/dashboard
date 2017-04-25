package de.d120.dashboard.service;

import java.io.IOException;
import java.util.List;

import de.d120.dashboard.model.Meal;

/**
 * A service for accessing the cafeteria food plan.
 *
 * @author Fabian Damken
 */
public interface CafeteriaService {
    /**
     * Retrieves the current meals in the cafeteria.
     *
     * @return The retrieved meals.
     * @throws IOException
     *             if any I/O error occurs.
     */
    List<Meal> retrieveMeals() throws IOException;
}
