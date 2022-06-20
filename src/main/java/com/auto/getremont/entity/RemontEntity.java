package com.auto.getremont.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;


@Getter
@Setter
@Entity(name = "remont")
@Table(name = "remont")
public class RemontEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String malfunction;

    @NotBlank
    private String car_brand;

    @NotBlank
    private String car_model;

    @NotNull
    private int car_year;

    @NotBlank
    private String price;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss")
    private Date created = new Date();


    @Getter
    @Setter
    @ManyToOne(fetch=FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JoinColumn(name = "user_id")
    private UserEntity user;


    public RemontEntity(){
        super();
    }


    public String getImage() {
        if (this.user == null) {
            return null;
        }
        return this.user.getImage();
    }

    public String getName() {
        if (this.user == null) {
            return null;
        }
        return this.user.getName();
    }

    public Long getUserId() {
        if (this.user == null) {
            return null;
        }
        return this.user.getId();
    }


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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


}