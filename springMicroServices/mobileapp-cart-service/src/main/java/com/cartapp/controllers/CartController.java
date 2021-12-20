package com.cartapp.controllers;


import com.cartapp.model.Cart;
import com.cartapp.model.Mobile;
import com.cartapp.service.ICartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart-api")
public class CartController {

    ICartService cartService;

    public CartController(ICartService cartService) {
        this.cartService = cartService;
    }
    @GetMapping("/cart/mobiles/brand/{brand}")
     public List<Mobile> showByBrand(@PathVariable("brand") String brand) {
        return cartService.getByBrand(brand);
    }

    @GetMapping("/cart/mobiles/mobileId/{mobileId}")
    public Mobile showById(@PathVariable("mobileId") int mobileId) {
        return cartService.getById(mobileId);
    }

    @GetMapping("/cart/add/mobile/{mobileId}")
    public Mobile addToCart(@PathVariable("mobileId") int mobileId) {
        cartService.addToCart(mobileId);
        return cartService.getById(mobileId);
    }

    @GetMapping("/cart/show")
    public Cart showCart() {
        return cartService.showCart();
    }

}
