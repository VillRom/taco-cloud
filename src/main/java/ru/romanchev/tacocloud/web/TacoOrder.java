package ru.romanchev.tacocloud.web;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table("orders")
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1;

    @PrimaryKey
    private UUID id;

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

    @Column("tacos")
    private List<TacoUDT> tacos = new ArrayList<>();

    public void addTaco(TacoUDT taco) {
        this.tacos.add(taco);
    }
}
