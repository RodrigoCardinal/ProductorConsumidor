
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productorconsumidor;

/**
 *
 * @author luigi
 */
public class Proceso2 extends Thread{
    private Buffer buffer;
    private String nombre;
    private int delay;
    
    public Proceso2(Buffer buffer, String nombre, int delay)
    {
        this.buffer = buffer;
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
                int resultado = x * x;
                buffer.producir(resultado, nombre);
                Thread.sleep((delay));
            }
        }
        catch (InterruptedException e)
            {
                return;
            }
    }
}

