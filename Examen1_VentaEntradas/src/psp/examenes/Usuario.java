/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp.examenes;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author alumno
 */
public class Usuario implements Runnable{
    private String name;
    private Entradas entradas;
    private boolean consigueEntrada;
    private boolean entradaConfirmada;

    public Usuario(String name, Entradas entradas) {
        this.name = name;
        this.entradas = entradas;
        entradaConfirmada = false;
        consigueEntrada = false;
    }

    public boolean isConsigueEntrada() {
        return consigueEntrada;
    }

    public void setConsigueEntrada(boolean consigueEntrada) {
        this.consigueEntrada = consigueEntrada;
    }

    public void setEntradaConfirmada(boolean entradaConfirmada) {
        this.entradaConfirmada = entradaConfirmada;
    }

    public boolean isEntradaConfirmada() {
        return entradaConfirmada;
    }
    
    public String GetNombre(){
        return name;
    }

    @Override
    public String toString() {
        return name + " - " + (consigueEntrada? "Consigue" : "No consigue") + " - " + (entradaConfirmada? "Confirma" : "No confirma");
    }

    @Override
    public void run() {
        while(entradas.getNumEntradas() > 0 || !entradaConfirmada){
            consigueEntrada = entradas.VenderEntrada();
            long waitingTime = ThreadLocalRandom.current().nextInt(1000, 2000);
            try{
                Thread.sleep(waitingTime);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            
            Random random = new Random();
            int num = random.nextInt(0, 100);
            
            if(num > 20){
                entradas.ConfirmarEntrada();
                Confirmar(true);
            } else {
                entradas.NoConfirmarEntrada();
                Confirmar(false);
            }
            //System.out.println(toString());
            try{
                Thread.sleep(waitingTime);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
    
    public void Confirmar(boolean b){
        setEntradaConfirmada(b);
    }
}
