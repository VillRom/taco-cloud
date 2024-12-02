package ru.romanchev.tacocloud.web.repository;

import org.springframework.data.repository.CrudRepository;
import ru.romanchev.tacocloud.web.TacoOrder;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, UUID>/*CrudRepository<TacoOrder, Long>*/ {

}
