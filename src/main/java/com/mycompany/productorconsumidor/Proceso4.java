
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productorconsumidor;

import com.mycompany.productorconsumidor.Buffer;

/**
 *
 * @author luigi
 */
public class Proceso4 extends Thread{
    private Buffer buffer2;
    private String nombre;
    private int delay;
    
    public Proceso4(Buffer buffer2, String nombre, int delay)
    {
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
                int x  = buffer2.consumir(nombre);
                Thread.sleep((delay));
            }
        }
        catch (InterruptedException e)
            {
                return;
            }
    }
}

