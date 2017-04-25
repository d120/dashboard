package de.d120.dashboard.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.d120.dashboard.dto.MealCategoryDTO;
import de.d120.dashboard.dto.MealCategoryDTO.MealCategoryListDTO;
import de.d120.dashboard.dto.MealDTO.MealListDTO;
import de.d120.dashboard.model.Meal;
import de.d120.dashboard.service.CafeteriaService;

@RestController
@RequestMapping("/api/cafeteria")
public class CafeteriaRestController {
    @Autowired
    private CafeteriaService cafeteriaService;

    @GetMapping
    public ResponseEntity<MealListDTO> retrieveMeals() throws IOException {
        return ResponseEntity.ok(new MealListDTO(this.cafeteriaService.retrieveMeals()));
    }

    @GetMapping("/grouped")
    public ResponseEntity<MealCategoryListDTO> retrieveMealsGroupedByCategory() throws IOException {
        final List<Meal> meals = this.cafeteriaService.retrieveMeals();
        final Map<String, List<Meal>> categories = new HashMap<>();
        for (final Meal meal : meals) {
            final String category = meal.getCategory();
            List<Meal> categoryMeals = categories.get(category);
            if (categoryMeals == null) {
                categoryMeals = new ArrayList<>();
                categories.put(category, categoryMeals);
            }
            categoryMeals.add(meal);
        }
        final List<MealCategoryDTO> result = categories.entrySet().stream()
                .map(entry -> new MealCategoryDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new MealCategoryListDTO(result));
    }
}
