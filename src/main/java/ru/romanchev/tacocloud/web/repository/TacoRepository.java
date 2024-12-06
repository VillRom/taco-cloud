package ru.romanchev.tacocloud.web.repository;

import org.springframework.data.repository.CrudRepository;
import ru.romanchev.tacocloud.web.Taco;

public interface TacoRepository
        extends CrudRepository<Taco, Long> {

}
