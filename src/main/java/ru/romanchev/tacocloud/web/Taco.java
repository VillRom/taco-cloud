package ru.romanchev.tacocloud.web;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@Table
public class Taco {

    @Id
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Имя не может быть короче 5 символов")
    private String name;

    @NotNull
    @Size(min = 1, message = "Вы должны добавить хотя бы 1 ингредиент")
    private List<IngredientRef> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient taco) {
        this.ingredients.add(new IngredientRef(taco.getId()));
    }
}
