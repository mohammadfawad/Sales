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
public class ContactNumber extends Object implements Serializable {
        private short countryCode;
        private short networkCode;
        private int number;
        private ContactNumberType type;

        
        public ContactNumber(short cc, short nc, int number, ContactNumberType t)
        {
            this.countryCode = cc;
            this.networkCode = nc;
            this.number = number;
            this.type = t;
        }

        public ContactNumber(short nc, int number) 
        {
            //this(92,nc,number,ContactNumberType.Cell);
        }



        //+92-300-4102039
        public ContactNumber(String fullNumber, ContactNumberType t) throws InvalidDataException
        {
            String[] parts = fullNumber.split("-");
            InvalidDataException ex = new InvalidDataException("Inavlid phone number format, valif format e.g. +92-300-4102039");
            if (parts.length != 3) throw ex;
            //Short.parseShort(g);
            this.countryCode = (short)Integer.parseInt(parts[0], 16);
            this.networkCode = (short)Integer.parseInt(parts[1], 16);
            this.number = Integer.parseInt(parts[2]);
            this.type = t;
        }

        public ContactNumber(String fullNumber) throws InvalidDataException 
        {
             this(fullNumber,ContactNumberType.Cell);
        }
        

        public short CountryCode()
        {
             return this.countryCode;            
        }

        public short NetworkCode()
        {
             return this.networkCode; 
        }

        public int Number()
        {
             return this.number; 
        }

        public ContactNumberType Type()
        {
             return this.type; 
        }


        //+92-300-4102039
        public String GetFullNumber()
        {
           
           
            return "+" + Short.toString(this.CountryCode()) + "-" + Short.toString(this.NetworkCode()) + "-" + Integer.toString(this.Number());
        }

    }

