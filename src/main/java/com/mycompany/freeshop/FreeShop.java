/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.freeshop;

/**
 *
 * @author Academica
 */
public class FreeShop {

    public static void main(String[] args) {
        
        int cantPasajeros=24;
        GestorFreeShop gestorFreeShop=new GestorFreeShop('0');
        Thread cajero1= new Thread(new Cajero(gestorFreeShop, '0', 1, cantPasajeros));
        cajero1.setName("Cajero1");
        cajero1.start();
        Thread cajero2= new Thread(new Cajero(gestorFreeShop, '0', 2, cantPasajeros));
        cajero2.setName("Cajero2");
        cajero2.start();
        Thread[] pasajeros = new Thread[cantPasajeros];
        for (int j = 0; j < cantPasajeros; j++) {
            pasajeros[j] = new Thread(new Pasajero(gestorFreeShop));
            pasajeros[j].setName("Pasajero" + (j + 1));
            pasajeros[j].start();
        }
    }
}
