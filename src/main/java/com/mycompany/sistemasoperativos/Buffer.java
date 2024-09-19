/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasoperativos;
import java.util.concurrent.Semaphore;
/**
 *
 * @author luigi
 */
public class Buffer
{
    private int[] buffer;
    private int size, entrada, salida, producidos, consumidos;
    private Semaphore mutex;
    private Semaphore vacio;
    private Semaphore lleno;
    private String nombre;
    public Buffer(int size, String nombre)
    {
        this.nombre = nombre;
        this.size = size;
        buffer = new int[size];
        for (int i = 0; i< size; i++)
        {
            buffer[i] = 0;
        }
        entrada = 0;
        salida = 0;
        mutex = new Semaphore(1);
        vacio = new Semaphore(size);
        lleno = new Semaphore(0);
        
        
    }
    
    public String getName()
    {
        return nombre;
    }
    public void producir(int item, String nombreProductor) throws InterruptedException {
    try
    {
        vacio.acquire();
        mutex.acquire();
        System.out.println(nombreProductor + " inserta " + item + " en el "+ nombre);
        if (buffer[entrada] == 0)
        {
            buffer[entrada] = item;
        }
        else
        {
            System.out.println("Cola llena");
            buffer[entrada] = item;
        }
        producidos++;
        entrada = (entrada++) % size;
        mutex.release();
        lleno.release();
    }
    catch(InterruptedException e)
        {
        }
    }
    public int consumir(String nombreConsumidor)
    {
        try
        {
            lleno.acquire();
            mutex.acquire();
            int item = buffer[salida];
            buffer[salida] = 0;
            consumidos++;
            salida = (salida++) % size;
            System.out.println(nombreConsumidor + " extrae " + item + " del " + nombre);
            mutex.release();
            lleno.release();
            return item;
        } 
        catch (InterruptedException e)
        {
            return 0;
        }
    }
}
