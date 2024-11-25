package ru.romanchev.tacocloud.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romanchev.tacocloud.web.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, String>/*extends CrudRepository<Ingredient, String>*/ {

}
