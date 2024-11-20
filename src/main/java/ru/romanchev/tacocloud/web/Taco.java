package ru.romanchev.tacocloud.web;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class Taco {

    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Имя не может быть короче 5 символов")
    private String name;

    @NotNull
    @Size(min = 1, message = "Вы должны добавить хотя бы 1 ингредиент")
    private List<Ingredient> ingredients;
}
