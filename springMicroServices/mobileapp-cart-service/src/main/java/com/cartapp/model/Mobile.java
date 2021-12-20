package com.cartapp.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mobile {
    private Integer mobileId;
    private String brand;
    private String model;
    private double price;


}
