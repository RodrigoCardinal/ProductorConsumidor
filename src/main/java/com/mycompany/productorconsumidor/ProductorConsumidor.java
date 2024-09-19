/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productorconsumidor;

/**
 *
 * @author luigi
 */
public class ProductorConsumidor {

    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(50, "Buffer 1");
        Buffer buffer2 = new Buffer(50, "Buffer 2");

        Proceso1 proceso1 = new Proceso1(buffer, "P1", 1000);
        Proceso2 proceso2 = new Proceso2(buffer, "P2", 750);
        Proceso3 proceso3 = new Proceso3(buffer, buffer2, "P3", 1800);
        Proceso4 proceso4 = new Proceso4(buffer2, "P4", 2500);

        proceso1.start();    
        proceso2.start();
        proceso3.start();
        proceso4.start();
        
        Thread.sleep(15000);
        
        proceso1.interrupt();
        proceso2.interrupt();
        proceso3.interrupt();
        proceso4.interrupt();
        
        System.out.println(
        "Fin de la operacion"
        );
    }
}
