package ru.romanchev.tacocloud.web.repository;

import org.springframework.data.repository.CrudRepository;
import ru.romanchev.tacocloud.web.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}
