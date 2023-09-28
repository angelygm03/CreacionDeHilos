package com.mycompany.borrador.practica2;

import java.util.concurrent.atomic.AtomicInteger;


/**
 *
 * @author Usuario
 */
public class BorradorPractica2 {

        public static int numero = 0;
        
        public static synchronized void incrementarNumero() {
            numero++;
        }
    
        public static class Proceso implements Runnable {
        
        @Override
        public void run() {
            for(int i = 0; i < 10000; i++) {
                incrementarNumero();
            }
        } //FORMA 2 DE EJECUTARLOS CON SYNCHRONIZED
    }

     

    public static void main(String[] args) throws InterruptedException {
        Thread hilo1 = new Thread(new Proceso());
        Thread hilo2 = new Thread(new Proceso());
        
        hilo1.start();
        hilo2.start();
        
        hilo1.join();
        hilo2.join();
        
        System.out.println(numero);
    }
} 