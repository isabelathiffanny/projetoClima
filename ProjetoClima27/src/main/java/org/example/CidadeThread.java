/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author Isabe
 */


public class CidadeThread implements Runnable{
    private Cidade[] cidades;

    public CidadeThread(Cidade[] cidades) {
        this.cidades = cidades;
    }

    @Override
    public void run() {
        for (Cidade cidade : cidades) {

            cidade.buscarPrevisao();
            

            try{
               
                cidade.estatisticas.acquire();

                cidade.mostrarEstatisticasDosDias(); 
                
                cidade.estatisticas.release();
            }catch(InterruptedException e){
                System.out.println("Thread interrompida.");
            }

        }
    }
}
