package com.mobileapp.service;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import com.mobileapp.repository.IMobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileServiceImpl implements IMobileService {
    private IMobileRepository mobileRepository;

    @Autowired
    public void setMobileRepository(IMobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }

    @Override
    public Mobile addMobile(Mobile mobile) {
        return mobileRepository.save(mobile);
    }

    @Override
    public void updateMobile(Mobile mobile) {
        mobileRepository.save(mobile);
    }

    @Override
    public void deleteMobile(int mobileId) {
        mobileRepository.deleteById(mobileId);
    }

    @Override
    public Mobile getById(int mobileId) throws MobileNotFoundException {
        return mobileRepository.findById(mobileId).orElseThrow(() -> new MobileNotFoundException("Mobile not found"));
    }

    @Override
    public List<Mobile> getAll() throws MobileNotFoundException {
        return mobileRepository.findAll();
    }

    @Override
    public List<Mobile> getByModel(String model) throws MobileNotFoundException {
        return mobileRepository.findByModel(model);
    }

    @Override
    public List<Mobile> getByBrand(String brand) throws MobileNotFoundException {
        return mobileRepository.findByBrand(brand);
    }

    @Override
    public List<Mobile> getByLessPrice(double price) throws MobileNotFoundException {
        return mobileRepository.findByPriceLessThan(price);
    }


    @Override
    public List<Mobile> getByModelAndBrand(String model, String brand) throws MobileNotFoundException {
        return mobileRepository.findByModelAndBrand(model, brand);
    }
}
