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
public class Supplier extends Person implements Serializable{
    private int id;

        public Supplier() 
        { 

        }

        public Supplier(int id, String name)
        {
             super(name);
            this.id = id;            
        }

        public int getID()
        {
             return id; 
        }
        public void getID(int value)
        {
              id = value; 
        }

    @Override
    public void DoYourJob() {
        System.out.println("Supply Goods");
    }
    
}
