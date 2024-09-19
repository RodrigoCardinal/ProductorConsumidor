/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productorconsumidor;

/**
 *
 * @author luigi
 */
public class Proceso1 extends Thread{
    private Buffer buffer;
    private String nombre;
    private int delay;
    
    public Proceso1(Buffer buffer, String nombre, int delay)
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
                int item  = (int) (Math.random() * 100);
                buffer.producir(item, nombre);
                Thread.sleep(delay);
            }
        }
        catch (InterruptedException e)
            {
                return;
            }
    }
}
