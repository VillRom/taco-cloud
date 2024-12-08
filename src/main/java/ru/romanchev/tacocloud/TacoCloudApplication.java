package ru.romanchev.tacocloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.romanchev.tacocloud.web.Ingredient;
import ru.romanchev.tacocloud.web.Ingredient.Type;
import ru.romanchev.tacocloud.web.Taco;
import ru.romanchev.tacocloud.web.repository.IngredientRepository;
import ru.romanchev.tacocloud.web.repository.TacoRepository;
import ru.romanchev.tacocloud.web.repository.UserRepository;

import java.util.List;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo, UserRepository userRepository,
                                        PasswordEncoder password, TacoRepository tacoRepository) {
        return args -> {
            Ingredient flourTortilla = new Ingredient("FLTO", "Flour Tortilla", Type.WRAP);
            Ingredient cornTortilla = new Ingredient("COTO", "Corn Tortilla", Type.WRAP);
            Ingredient groundBeef = new Ingredient("GRBF", "Ground Beef", Type.PROTEIN);
            Ingredient carnitas = new Ingredient("CARN", "Carnitas", Type.PROTEIN);
            Ingredient tomatoes = new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES);
            Ingredient lettuce = new Ingredient("LETC", "Lettuce", Type.VEGGIES);
            Ingredient cheddar = new Ingredient("CHED", "Cheddar", Type.CHEESE);
            Ingredient jack = new Ingredient("JACK", "Monterrey Jack", Type.CHEESE);
            Ingredient salsa = new Ingredient("SLSA", "Salsa", Type.SAUCE);
            Ingredient sourCream = new Ingredient("SRCR", "Sour Cream", Type.SAUCE);
            repo.save(flourTortilla);
            repo.save(cornTortilla);
            repo.save(groundBeef);
            repo.save(carnitas);
            repo.save(tomatoes);
            repo.save(lettuce);
            repo.save(cheddar);
            repo.save(jack);
            repo.save(salsa);
            repo.save(sourCream);

            Taco taco1 = new Taco();
            taco1.setName("Carnivore");
            taco1.setIngredients(List.of(flourTortilla, groundBeef, carnitas, sourCream, salsa, cheddar));
            tacoRepository.save(taco1);

            Taco taco2 = new Taco();
            taco2.setName("Carnivore");
            taco2.setIngredients(List.of(cornTortilla, groundBeef, cheddar, jack, sourCream));
            tacoRepository.save(taco2);

            Taco taco3 = new Taco();
            taco3.setName("Veg-Out");
            taco3.setIngredients(List.of(flourTortilla, cornTortilla, tomatoes, lettuce, salsa));
            tacoRepository.save(taco3);
        };
    }
}
