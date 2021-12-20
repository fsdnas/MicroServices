package com.mobileapp.controllers;

import com.mobileapp.model.Mobile;
import com.mobileapp.service.IMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mobile-api")
@Profile("dev")

public class MobileController {
    IMobileService mobileService;

    public String greetings;

    public String getGreetings() {
        return greetings;
    }

    @Value("${message}")
    public void setGreetings(String greetings) {
        this.greetings = greetings;
    }

    @Autowired
    public void setMobileService(IMobileService mobileService) {
        this.mobileService = mobileService;
    }

    @RequestMapping("/greet/{name}")
    public String greet(@PathVariable("name") String name) {
        return name.concat(" ").concat(getGreetings());
    }

    @PostMapping("/mobiles")
    void addMobile(@RequestBody Mobile mobile) {
        mobileService.addMobile(mobile);
    }

    @PutMapping("/mobiles")
    void updateMobile(@RequestBody Mobile mobile) {
        mobileService.updateMobile(mobile);
    }

    @GetMapping("/mobiles/id/{mobileId}")
    Mobile getById(@PathVariable("mobileId") int mobileId) {
        return mobileService.getById(mobileId);
    }

    @DeleteMapping("/mobiles/{mobileId}")
    void deleteMobile(@PathVariable("mobileId") int mobileId) {
        mobileService.deleteMobile(mobileId);
    }

    @GetMapping("/mobiles")
    List<Mobile> getAll() {
        return mobileService.getAll();
    }

    @GetMapping("/mobiles/brand/{brand}")
    List<Mobile> getByBrand(@PathVariable("brand") String brand) {
        return mobileService.getByBrand(brand);
    }

    @GetMapping("mobiles/model/{model}")
    List<Mobile> getByModel(@PathVariable("model") String model) {
        return mobileService.getByModel(model);
    }

    @GetMapping("/mobiles/brand/{brand}/model/{model}")
    List<Mobile> getByBrandAndModel(@PathVariable("brand") String brand, @PathVariable("model") String model) {
        return mobileService.getByModelAndBrand(brand, model);
    }

    @GetMapping("/mobiles/price/{price}")
    List<Mobile> getByLesserPrice(@PathVariable("price") double price) {
        return mobileService.getByLessPrice(price);
    }
}
