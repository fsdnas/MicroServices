package com.cartapp.service;

import com.cartapp.model.Cart;
import com.cartapp.model.Mobile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class CartServiceImpl implements ICartService {
    String BASEURL = "http://MOBILE-SERVICE/mobile-api";

    List<Mobile> mobiles = new ArrayList<>();

    //    @Autowired
    RestTemplate restTemplate;

    //@Autowired not required for constructor based dependency injection
    public CartServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Mobile> getByBrand(String brand) {
        String uri = BASEURL + "/mobiles/brand/" + brand;
        return restTemplate.getForObject(uri, List.class);
    }

    @Override
    public Mobile getById(int mobileId) {
        String uri = BASEURL + "/mobiles/id/" + mobileId;
        return restTemplate.getForObject(uri, Mobile.class);
    }

    @Override
    public void addToCart(int mobileid) {
        String uri = BASEURL + "/mobiles/id/" + mobileid;
        Mobile mobile = restTemplate.getForObject(uri, Mobile.class);
        mobiles.add(mobile);
    }

    @Override
    public Cart showCart() {
        Cart cart = new Cart();
        cart.setCartId(1);
        cart.setMobiles(mobiles);
        cart.setQuantity(mobiles.size());
        double total = mobiles.stream().mapToDouble(Mobile::getPrice).sum();
        cart.setTotalPrice(total);
        return cart;
    }
}
