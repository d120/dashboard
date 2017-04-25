package de.d120.dashboard.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
                .userAgent("Mozilla")
                .get();
        final Elements mealCategories = document.select(".aw-meal-category");

        return mealCategories.stream()
                .flatMap(mealCategory -> this.parseMealCategory(mealCategory).stream())
                .collect(Collectors.toList());
    }

    private List<Meal> parseMealCategory(final Element mealCategory) {
        final String name = mealCategory.select(".aw-meal-category-name").text();
        return mealCategory.select(".aw-meal").stream()
                .map(mealElement -> this.parseMeal(name, mealElement))
                .collect(Collectors.toList());
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
