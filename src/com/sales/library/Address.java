/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.library;

import java.io.Serializable;

/**
 *
 * @author fawad
 */
public class Address implements Serializable {

    private String streetAddress;
    private String city;
    private String country;

    public Address() {
    }

    public Address(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }

    public Address(String streetAddress, String city) {
        this(streetAddress, city, "Pakistan");

    }

    public String getCountry() {
        return country;

    }

    public void setCountry(String value) {

        country = value;
    }

    public String getCity() {
        return city;

    }

    public void setCity(String value) {

        city = value;
    }

    public String getStreetAddress() {
        return streetAddress;

    }

    public void setStreetAddress(String value) {

        streetAddress = value;
    }
}
