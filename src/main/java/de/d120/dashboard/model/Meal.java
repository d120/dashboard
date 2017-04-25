package de.d120.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * Represents a meal.
 *
 * @author Fabian Damken
 */
@Value
@Builder
@AllArgsConstructor
public class Meal {
    /**
     * The category this meal belongs to.
     *
     */
    private String category;
    /**
     * The name of the meal.
     *
     */
    private String name;
    /**
     * The price
     *
     */
    private int price;
}
