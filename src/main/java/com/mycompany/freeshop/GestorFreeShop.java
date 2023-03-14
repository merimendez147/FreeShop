/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.freeshop;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Academica
 */
public class GestorFreeShop {

    int capacidadFreeShop = 20;
    int cantPasajerosIngresados;
//    int cantPasajerosCaja1 = 0, cantPasajerosCaja2 = 0;
    int capacidadCaja1 = 1, capacidadCaja2 = 1;
    char terminal;
    Semaphore ingresarFreeShop = new Semaphore(capacidadFreeShop, true);
    Semaphore pagarCaja1 = new Semaphore(capacidadCaja1, true);
    Semaphore esperarCaja1 = new Semaphore(0, true);
    Semaphore pagarCaja2 = new Semaphore(capacidadCaja2, true);
    Semaphore esperarCaja2 = new Semaphore(0, true);

    public GestorFreeShop(char nombreT) {
        this.terminal = nombreT;
        this.cantPasajerosIngresados = 0;
    }

    public void ingresarFreeShop() {
        try {
            ingresarFreeShop.acquire();
            cantPasajerosIngresados++;
            System.out.println(Thread.currentThread().getName() + " ingreso al Free Shop de la Terminal " + terminal);
            Random comprarFreeShop = new Random();
            if (comprarFreeShop.nextBoolean()) {
                System.out.println(Thread.currentThread().getName() + " esta comprando en el Free Shop de la Terminal " + terminal);
                Random libre = new Random();
                boolean caja1Libre = libre.nextBoolean();
                if (caja1Libre) {
                    System.out.println(Thread.currentThread().getName() + " quiere pagar en la caja 2");
                    pagarCaja2.acquire();
//                    cantPasajerosCaja2++;
                    System.out.println(Thread.currentThread().getName() + " ingreso a la caja 2 de la Terminal " + terminal);
                    esperarCaja2.release();
                } else {
                    System.out.println(Thread.currentThread().getName() + " quiere pagar en la caja 1");
                    pagarCaja1.acquire();
//                    cantPasajerosCaja1++;
                    System.out.println(Thread.currentThread().getName() + " ingreso a la caja 1 de la Terminal " + terminal);
                    esperarCaja1.release();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void salirFreeShop() {
//        cantPasajerosIngresados--;
        System.out.println(Thread.currentThread().getName() + " salio del Free Shop de la Terminal " + terminal);
        ingresarFreeShop.release();
    }

    public void cobrarFreeShopCaja1() {
        try {
            esperarCaja1.acquire();
//            cantPasajerosCaja1--;
            System.out.println(Thread.currentThread().getName() + " cobro a un Pasajero en la caja 1 de la Terminal " + terminal);
            pagarCaja1.release();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void cobrarFreeShopCaja2() {
        try {
            esperarCaja2.acquire();
//            cantPasajerosCaja2--;
            System.out.println(Thread.currentThread().getName() + " cobro a un Pasajero en la caja 2 de la Terminal " + terminal);
            pagarCaja2.release();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
