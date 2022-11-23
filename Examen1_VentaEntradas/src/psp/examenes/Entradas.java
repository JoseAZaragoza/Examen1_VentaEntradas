/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp.examenes;

/**
 *
 * @author alumno
 */
public class Entradas {

    private int numEntradas;

    public Entradas() {
        this.numEntradas = 250;
    }

    public int getNumEntradas() {
        return numEntradas;
    }

    public synchronized boolean VenderEntrada() {
        while (numEntradas == 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        // Application logic
        return true;
    }

    public synchronized void ConfirmarEntrada() {
        this.numEntradas--;
    }
    
    public synchronized void NoConfirmarEntrada() {
        notifyAll();
    }
}
