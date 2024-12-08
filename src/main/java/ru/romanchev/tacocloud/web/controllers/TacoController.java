package ru.romanchev.tacocloud.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.romanchev.tacocloud.web.Taco;
import ru.romanchev.tacocloud.web.TacoOrder;
import ru.romanchev.tacocloud.web.repository.OrderRepository;
import ru.romanchev.tacocloud.web.repository.TacoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/tacos", produces = "application/json")
@RequiredArgsConstructor
public class TacoController {

    private final TacoRepository tacoRepo;

    private final OrderRepository orderRepo;

    @GetMapping(params = "recent")
    public List<Taco> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        return tacoRepo.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public Optional<Taco> tacoById(@PathVariable Long id) {
        return tacoRepo.findById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco createdTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }

    @PutMapping(value = "/{orderId}", consumes = "application/json")
    public TacoOrder putOrder(@PathVariable Long orderId, @RequestBody TacoOrder putOrder) {
        putOrder.setId(orderId);
        return orderRepo.save(putOrder);
    }

    @PatchMapping(value = "/{orderId}", consumes = "application/json")
    public TacoOrder patchOrder(@PathVariable Long orderId, @RequestBody TacoOrder orderPatch) {
        TacoOrder order = orderRepo.findById(orderId).get();
        if (orderPatch.getDeliveryName() != null) {
            order.setDeliveryName(orderPatch.getDeliveryName());
        }
        if (orderPatch.getDeliveryStreet() != null) {
            order.setDeliveryStreet(orderPatch.getDeliveryStreet());
        }
        if (orderPatch.getDeliveryCity() != null) {
            order.setDeliveryCity(orderPatch.getDeliveryCity());
        }
        if (orderPatch.getDeliveryState() != null) {
            order.setDeliveryState(orderPatch.getDeliveryState());
        }
        if (orderPatch.getDeliveryZip() != null) {
            order.setDeliveryZip(orderPatch.getDeliveryZip());
        }
        if (orderPatch.getCcNumber() != null) {
            order.setCcNumber(orderPatch.getCcNumber());
        }
        if (orderPatch.getCcExpiration() != null) {
            order.setCcExpiration(orderPatch.getCcExpiration());
        }
        if (orderPatch.getCcCVV() != null) {
            order.setCcCVV(orderPatch.getCcCVV());
        }
        return orderRepo.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long orderId) {
        try {
            orderRepo.deleteById(orderId);
        }
        catch (EmptyResultDataAccessException e) {}
    }
}
