package ru.romanchev.tacocloud.web.repository;

import org.springframework.core.convert.converter.Converter;
import ru.romanchev.tacocloud.web.Ingredient;
import ru.romanchev.tacocloud.web.IngredientUDT;

import java.util.Optional;

public class StringToIngredientConverter implements Converter<String, IngredientUDT> {
    private IngredientRepository ingredientRepository;

    public StringToIngredientConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientUDT convert(String id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isEmpty()) {
            return null;
        }

        return ingredient.map(i -> {
            return new IngredientUDT(i.getName(), i.getType());
        }).get();
    }
}
