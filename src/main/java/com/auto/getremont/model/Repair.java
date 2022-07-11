package com.auto.getremont.model;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@Data
public class Repair {

    //private Long id;
    @Column(name = "malfunction")
    private String malfunction;
    @Column(name = "car_brand")
    private String car_brand;
    @Column(name = "car_model")
    private String car_model;
    @Column(name = "car_year")
    private int car_year;
    @Column(name = "price")
    private String price;
    @Column(name = "price")
    private String image;
    @Column(name = "created")
    private Date created;
    @Column(name = "name")
    private String name;
    @Column(name = "user_id")
    private Long user_id;

    public String getMalfunction() {
        return malfunction;
    }

    public void setMalfunction(String malfunction) {
        this.malfunction = malfunction;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public int getCar_year() {
        return car_year;
    }

    public void setCar_year(int car_year) {
        this.car_year = car_year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

}