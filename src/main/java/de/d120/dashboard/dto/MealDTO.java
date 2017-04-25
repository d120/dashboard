package de.d120.dashboard.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonValue;

import de.d120.dashboard.model.Meal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("meal")
public class MealDTO {
    private String category;
    private String name;
    private int price;

    public MealDTO(final Meal meal) {
        this.category = meal.getCategory();
        this.name = meal.getName();
        this.price = meal.getPrice();
    }

    public Meal toMeal() {
        return Meal.builder()
                .category(this.category)
                .name(this.name)
                .price(this.price)
                .build();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonRootName("meals")
    public static class MealListDTO {
        @Getter(onMethod = @__(@JsonValue))
        private List<Meal> meals;
    }
}
