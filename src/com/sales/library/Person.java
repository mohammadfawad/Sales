/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fawad
 */
public abstract class Person implements Serializable {

    private static int counter;

    private String name;
    private Date dateOfBirth;
    private List<ContactNumber> phones;
    private Address postalAddress;

    static {
        Person.counter = 0;
    }

    public Person() {
        Person.counter++;
    }

    public Person(String name) {
        this();
        this.name = name;
    }

    public static int getCounter() {
        
            return Person.counter;
    }

    public Address getPostalAddress() {
         
            return postalAddress;
    }
    public void setPostalAddress(Address value) {
         
            postalAddress = value;
    }

    public List<ContactNumber> getPhones(){
            return phones;
    }
     public void setPhones(List<ContactNumber> value){
        
            phones = value;
    }

    public Date getDateOfBirth() {
       
            return dateOfBirth;
    }
    public void setDateOfBirth(Date value) {
        
            dateOfBirth = value;
    }
    public String getName(){
      
            return name;
    }

    public void AddPhone(ContactNumber phone) {
        if (this.phones == null) {
            this.phones = new ArrayList<ContactNumber>();
        }
        this.phones.add(phone);
    }

    public int GetAge(Date dateOfBirth) {

    Calendar today = Calendar.getInstance();
    Calendar birthDate = Calendar.getInstance();

    int age = 0;

    birthDate.setTime(dateOfBirth);
    if (birthDate.after(today)) {
        throw new IllegalArgumentException("Can't be born in the future");
    }

    age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

    // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year   
    if ( (birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) ||
            (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){
        age--;

     // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
    }else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH )) &&
              (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){
        age--;
    }

    return age;
}
    /**
     * Abstract method to be implemented by each class according 
     * to its need.
     */
    public abstract void DoYourJob();
    
}
