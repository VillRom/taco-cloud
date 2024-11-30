package ru.romanchev.tacocloud.web;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Taco {

    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Имя не может быть короче 5 символов")
    private String name;

    @Size(min = 1, message = "Вы должны добавить хотя бы 1 ингредиент")
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add((ingredient));
    }
}
