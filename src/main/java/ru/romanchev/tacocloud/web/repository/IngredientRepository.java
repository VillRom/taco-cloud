package ru.romanchev.tacocloud.web.repository;

import org.springframework.data.repository.CrudRepository;
import ru.romanchev.tacocloud.web.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
