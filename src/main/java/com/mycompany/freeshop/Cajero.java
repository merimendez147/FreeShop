/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.freeshop;

/**
 *
 * @author Academica
 */
public class Cajero implements Runnable {

    GestorFreeShop gestorFreeShop;
    char terminal;
    int nroCaja;
    int cantPasajeros;

    public Cajero(GestorFreeShop gestorFreeShop, char terminal, int nroCaja, int cantPasajeros) {
        this.terminal = terminal;
        this.nroCaja = nroCaja;
        this.gestorFreeShop = gestorFreeShop;
        this.cantPasajeros = cantPasajeros;
    }

    @Override
    public void run() {
        for (int i = 1; i <= cantPasajeros; i++) {
            switch (nroCaja) {
                case 1 -> {
                    gestorFreeShop.cobrarFreeShopCaja1();
                    System.out.println("El " + Thread.currentThread().getName() + " esta cobrando en la caja " + nroCaja + " de la terminal " + terminal);
                }
                case 2 -> {
                    gestorFreeShop.cobrarFreeShopCaja2();
                    System.out.println("El " + Thread.currentThread().getName() + " esta cobrando en la caja " + nroCaja + " de la terminal " + terminal);
                }
            }
        }
    }
}
