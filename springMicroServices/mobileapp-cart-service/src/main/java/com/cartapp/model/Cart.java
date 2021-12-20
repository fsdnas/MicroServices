package com.cartapp.model;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cart {

    Integer cartId;
    List<Mobile> mobiles;
    int quantity;
    double totalPrice;

}
