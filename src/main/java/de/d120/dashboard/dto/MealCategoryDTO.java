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
@JsonRootName("category")
public class MealCategoryDTO {
    private String name;
    private List<Meal> meals;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonRootName("categories")
    public static class MealCategoryListDTO {
        @Getter(onMethod = @__(@JsonValue))
        private List<MealCategoryDTO> mealCategories;
    }
}
