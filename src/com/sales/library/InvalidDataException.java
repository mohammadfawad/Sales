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
public class InvalidDataException extends Exception implements Serializable{
    public InvalidDataException(){
        super("Invalid Data");}
        public InvalidDataException(String msg){
            super(msg); 
        }
}
