/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.freeshop;

/**
 *
 * @author Academica
 */
public class Pasajero implements Runnable{
    
    GestorFreeShop gestorFreeShop;
    
    public Pasajero(GestorFreeShop gestorFS){
        this.gestorFreeShop=gestorFS;
    }
    
    @Override
    public void run(){
        gestorFreeShop.ingresarFreeShop();
        gestorFreeShop.salirFreeShop();
    }
}
