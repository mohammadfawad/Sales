/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.library;

import java.io.Serializable;
import java.lang.Cloneable;

/**
 *
 * @author fawad When an object is copied to the other using assignment
 * operator, only reference of the object is copied. So change in one object
 * reflects in other. Java use clone() method of Object class to copy content of
 * one object to the other. The problem will arrive if the Class that needs to
 * be copied also contains reference to the other object. Classes can implements
 * Cloneable interface to overrides the clone() method of the Object class.
 */
public class Customer extends Person implements Serializable, Cloneable {

    private int membershipNumber;

    public Customer() {

    }

    public Customer(int memNo, String name) {
        super(name);
        this.membershipNumber = memNo;
    }

    public int getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(int value) {

        membershipNumber = value;
    }

    public String ToString() {
        return String.valueOf(this.getMembershipNumber() + "," + this.getName());
    }

    public Object Clone() {
        return null;
    }

    @Override
    public void DoYourJob() {
        System.out.println("Buy goods");
    }

}
