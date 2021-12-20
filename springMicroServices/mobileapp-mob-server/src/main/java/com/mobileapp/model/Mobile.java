package com.mobileapp.model;

import javax.persistence.*;

@Entity
public class Mobile {
    @Id
    @GeneratedValue(generator = "mobile_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mobile_seq", sequenceName = "mobile_sequence", initialValue = 100, allocationSize = 10)
    private Integer mobileId;
    private String brand;
    private String model;
    private double price;


    public Mobile() {
        super();
    }

    public Mobile(String brand, String model, double price) {
        super();
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Integer getMobileId() {
        return mobileId;
    }

    public void setMobileId(Integer mobileId) {
        this.mobileId = mobileId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "mobileId=" + mobileId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
