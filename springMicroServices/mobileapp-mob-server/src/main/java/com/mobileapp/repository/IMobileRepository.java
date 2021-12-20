package com.mobileapp.repository;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMobileRepository extends JpaRepository<Mobile, Integer> {

    List<Mobile> findByModel(String model) throws MobileNotFoundException;

    List<Mobile> findByBrand(String brand) throws MobileNotFoundException;

    List<Mobile> findByPriceLessThan(double price) throws MobileNotFoundException;

    List<Mobile> findByModelAndBrand(String model, String brand) throws MobileNotFoundException;

}
