package ru.romanchev.tacocloud.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romanchev.tacocloud.web.TacoOrder;

public interface OrderRepository extends JpaRepository<TacoOrder, Long>/*CrudRepository<TacoOrder, Long>*/ {

}
