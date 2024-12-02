package ru.romanchev.tacocloud.web.repository;

import org.springframework.data.repository.CrudRepository;
import ru.romanchev.tacocloud.web.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String>/*extends CrudRepository<Ingredient, String>*/ {

}
