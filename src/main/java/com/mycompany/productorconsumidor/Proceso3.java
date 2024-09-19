
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productorconsumidor;

/**
 *
 * @author luigi
 */
public class Proceso3 extends Thread{
    private Buffer buffer;
    private Buffer buffer2;
    private String nombre;
    private int delay;
    
    public Proceso3(Buffer buffer, Buffer buffer2, String nombre, int delay)
    {
        this.buffer = buffer;
        this.buffer2 = buffer2;
        this.nombre = nombre;
        this.delay = delay;
    }
    
    public void run()
    {
        try 
        {
        while(true)
            {
                int x  = buffer.consumir(nombre);
                int x2  = buffer.consumir(nombre);
                int resultado = x + x2;
                buffer2.producir(resultado, nombre);
                Thread.sleep((delay));
            }
        }
        catch (InterruptedException e)
            {
                return;
            }
    }
}

