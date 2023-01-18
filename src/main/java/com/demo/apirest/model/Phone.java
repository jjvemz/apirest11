package com.demo.apirest.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Phone {

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    @Id
    @SequenceGenerator(
            name="phones_generator",
            sequenceName = "phones_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "phones_generator"
    )
    private long Id;
    private int number;
    private int cityCode;
    private int countryCode;

    public Phone(int number, int cityCode, int countryCode){
        this.number= number;
        this.cityCode = cityCode;
        this.countryCode= countryCode;
    }
    public int getNumber() {
        return (int) number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

}
