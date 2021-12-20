package com.cartapp.service;

import com.cartapp.model.Cart;
import com.cartapp.model.Mobile;

import java.util.List;

public interface ICartService {
  // to make API Calls
    List<Mobile> getByBrand(String brand);
    public Mobile getById(int id);
    public void addToCart(int mobileid);
    public Cart showCart();

}
