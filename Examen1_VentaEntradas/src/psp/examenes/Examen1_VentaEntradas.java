/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp.examenes;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author alumno
 */
public class Examen1_VentaEntradas {

    /**
     * @param args the command line arguments
     */
    static final int NUM_USUARIOS = 500;
    public static void main(String[] args) {
        // TODO code application logic here
        Entradas entradas = new Entradas();
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Thread thread = null;
        for(int i = 0; i<NUM_USUARIOS; i++){
            Usuario usuario = new Usuario("Usuario" + (i+1), entradas);
            thread = new Thread(usuario);
            thread.start();
            usuarios.add(usuario);
        }
        
        
        try {
            thread.join(10000);
        } catch (InterruptedException e) {
            System.err.println("Error writing for the threads to finish: " + e.getLocalizedMessage());
            e.printStackTrace();
        }
        
        for(int i = 0; i<usuarios.size(); i++){
            System.out.println(usuarios.get(i).toString());
        }
        
        int contadorUsuariosConEntrada = 0;
        for(int i = 0; i<NUM_USUARIOS; i++){
            if(usuarios.get(i).isEntradaConfirmada()){
                contadorUsuariosConEntrada++;
            }
        }
        
        System.out.println("\nUsuarios con entrada: " + contadorUsuariosConEntrada);
        System.out.println("Usuarios sin entrada: " + (500 - contadorUsuariosConEntrada));
    }
}
