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
public class SalesPerson extends Employee implements Serializable {

    private float commissionRate;

    public SalesPerson() {

    }

    public SalesPerson(int empCode, String name) {
        super(empCode, name);

    }

    public SalesPerson(int empCode, String name, float commRate) {
        this(empCode, name);
        this.commissionRate = commRate;
    }

    public float getCommissionRate() {

        return this.commissionRate;
    }

    public void setCommissionRate(float value) {

        this.commissionRate = value;
    }

    @Override
    public void DoYourJob() {
        System.out.println("Sale goods");
    }

    public String ToString() {
        return String.valueOf(this.getEmployeeCode() + "," + this.getName() + "," + this.getCommissionRate());
    }
}
