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
public class Category implements Serializable {

    private int id;
    private String name;
    private int rank;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(int id, String name, int rank) {
        this(id, name);
        this.rank = rank;
    }

    public int getID() {

        return id;
    }

    public void setID(int value) {

        id = value;
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
}
