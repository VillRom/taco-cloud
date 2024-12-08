package ru.romanchev.tacocloud.web.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.romanchev.tacocloud.web.Taco;

public interface TacoRepository
        extends PagingAndSortingRepository<Taco, Long> {

}
