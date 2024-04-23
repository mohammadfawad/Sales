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
public class Item implements Serializable {

    private int code;
    private String name;
    private float price;
    private int rank;
    private String imageURL;
    private String description;
    private Category category;

    public Item() {
    }

    public Item(int id, String name) {
        this.code = id;
        this.name = name;
    }

    public Item(int id, String name, float price) {
        this(id, name);
        this.price = price;
    }

    public Item(int id, String name, float price, int rank, String imageURL) {
        this(id, name, price);
        this.rank = rank;
        this.imageURL = imageURL;
    }

    public Item(int id, String name, float price, int rank, String imageURL, String description) {
        this(id, name, price, rank, imageURL);
        this.description = description;
    }

    public int getCode() {

        return code;

    }

    public void setCode(int value) {

        code = value;
    }

    public float getPrice() {

        return price;
    }

    public void setPrice(float value) {

        price = value;
    }

    public String getName() {

        return name;
    }

    public void setName(String value) {

        name = value;
    }

    public int getRank() {

        return rank;
    }

    public void setRank(int value) {

        rank = value;
    }

    public String setImageURL() {

        return imageURL;
    }

    public void setImageURL(String value) {

        imageURL = value;
    }

    public String getDescription() {

        return description;

    }

    public void setDescription(String value) {

        description = value;
    }

    public Category getCategory() {

        return this.category;
    }

    public void getCategory(Category value) {

        this.category = value;

    }

}
