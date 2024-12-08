package ru.romanchev.tacocloud.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import ru.romanchev.tacocloud.web.TacoOrder;
import ru.romanchev.tacocloud.web.User;
import ru.romanchev.tacocloud.web.repository.OrderRepository;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
@Slf4j
public class OrderController {

    private final OrderRepository orderRepository;
    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus status,
                               @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) return "orderForm";
        order.setUser(user);
        order.setPlacedAt(new Date());
        orderRepository.save(order);
        status.setComplete();
        log.info("Созданный заказ: {}", order);
        return "redirect:/";
    }
}
