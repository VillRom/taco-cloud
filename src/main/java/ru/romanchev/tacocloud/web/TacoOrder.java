package ru.romanchev.tacocloud.web;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class TacoOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    @NotBlank(message = "Требуется указать наименование доставки")
    private String deliveryName;

    @NotBlank(message = "Требуется указать название улицы")
    private String deliveryStreet;

    @NotBlank(message = "Требуется указать наименование города")
    private String deliveryCity;

    @NotBlank(message = "Требуется указать наименование области")
    private String deliveryState;

    @NotBlank(message = "Требуется указать zip код")
    private String deliveryZip;

    @CreditCardNumber(message = "Не валидный номер карты")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message="Должен быть формат MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Не валидный код CVV")
    private String ccCVV;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
