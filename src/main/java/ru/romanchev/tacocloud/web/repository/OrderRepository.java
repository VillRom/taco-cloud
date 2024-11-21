package ru.romanchev.tacocloud.web.repository;

import ru.romanchev.tacocloud.web.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
