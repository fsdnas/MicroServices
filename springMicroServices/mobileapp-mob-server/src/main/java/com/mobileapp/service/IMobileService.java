package com.mobileapp.service;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

import java.util.List;

public interface IMobileService {

    Mobile addMobile(Mobile mobile);

    void updateMobile(Mobile mobile);

    void deleteMobile(int mobileId);

    Mobile getById(int mobileId) throws MobileNotFoundException;

    List<Mobile> getAll() throws MobileNotFoundException;

    List<Mobile> getByModel(String model) throws MobileNotFoundException;

    List<Mobile> getByBrand(String brand) throws MobileNotFoundException;

    List<Mobile> getByLessPrice(double price) throws MobileNotFoundException;

    List<Mobile> getByModelAndBrand(String model, String brand) throws MobileNotFoundException;

}
