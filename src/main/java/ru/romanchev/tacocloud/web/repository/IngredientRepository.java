package ru.romanchev.tacocloud.web.repository;

import ru.romanchev.tacocloud.web.Ingredient;

import java.util.Optional;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
