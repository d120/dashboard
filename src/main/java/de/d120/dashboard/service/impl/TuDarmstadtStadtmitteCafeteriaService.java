package de.d120.dashboard.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import de.d120.dashboard.model.Meal;
import de.d120.dashboard.service.CafeteriaService;

/**
 * {@link CafeteriaService} implementation for the TU Darmstadt, Mensa
 * Stadtmitte.
 *
 * @author Fabian Damken
 */
@Service
public class TuDarmstadtStadtmitteCafeteriaService implements CafeteriaService {
    /**
     * The URL of the cafeteria food plan.
     *
     */
    private static final String URL_CAFETERIA = "http://www.imensa.de/darmstadt/mensa-stadtmitte/index.html";

    /**
     * {@inheritDoc}
     *
     * @see de.d120.dashboard.service.CafeteriaService#retrieveMeals()
     */
    @Override
    public List<Meal> retrieveMeals() throws IOException {
        final Document document = Jsoup.connect(TuDarmstadtStadtmitteCafeteriaService.URL_CAFETERIA)
                .validateTLSCertificates(false)
                .userAgent("Mozilla")
                .get();
        final Elements mealCategories = document.select(".aw-meal-category");

        final List<Meal> result = new ArrayList<>();
        for (final Element mealCategory : mealCategories) {
            for (final Meal meal : this.parseMealCategory(mealCategory)) {
                result.add(meal);
            }
        }
        return result;
    }

    private List<Meal> parseMealCategory(final Element mealCategory) {
        final String name = mealCategory.select(".aw-meal-category-name").text();
        final List<Meal> meals = new ArrayList<>();
        for (final Element meal : mealCategory.select(".aw-meal")) {
            meals.add(this.parseMeal(name, meal));
        }
        return meals;
    }

    private Meal parseMeal(final String category, final Element meal) {
        final String name = meal.select(".aw-meal-description").text();
        final int price = Integer.parseInt(meal.select(".aw-meal-price").text().replaceAll("\\D", ""));
        return Meal.builder()
                .category(category)
                .name(name)
                .price(price)
                .build();
    }
}
