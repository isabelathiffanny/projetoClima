/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author Isabe
 */

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Main{
    private static final int NUM_THREADS = 9; 
    private static final int RODADAS = 10;
    public static void main(String[] args){
        Semaphore estatisticas = new Semaphore(1);
        Cidade[] cidades = inicializarCidades(estatisticas);
        Duration[] temposExecucao = new Duration[RODADAS];
        double soma = 0.0;

        for (int i = 0; i < RODADAS; i++){

            Thread[] threads = new Thread[NUM_THREADS];

            for (int j = 0; j < threads.length; j++) {
                int inicio = j * 3;
                int fim = Math.min(inicio + 3, cidades.length);
                Cidade[] cidadesGrupo = Arrays.copyOfRange(cidades, inicio, fim);
                threads[j] = new Thread(new CidadeThread(cidadesGrupo));
            }


            Instant instanteInicial = Instant.now();
            for (Thread thread : threads) {
                thread.start();
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Instant instanteFinal = Instant.now();

            temposExecucao[i] = Duration.between(instanteInicial, instanteFinal);

            soma += (double)temposExecucao[i].toMillis();

            System.out.println("Tempo de execução (" + (i+1) + "ª rodada): " + temposExecucao[i].toMillis() + " ms");
        }

        double media = soma / RODADAS;

        System.out.println();
        System.out.println("Média (tempos de execução) = " + media + " ms");
    }

    private static Cidade[] inicializarCidades(Semaphore estatisticas){
        Cidade[] cidades = new Cidade[]{
                new Cidade("Aracaju", -10.9167, -37.05, estatisticas),
                new Cidade("Belém", -1.4558, -48.5039, estatisticas),
                new Cidade("Belo Horizonte", -19.9167, -43.9333, estatisticas),
                new Cidade("Boa Vista", 2.81972, -60.67333, estatisticas),
                new Cidade("Brasília", -15.7939, -47.8828, estatisticas),
                new Cidade("Campo Grande", -20.44278, -54.64639, estatisticas),
                new Cidade("Cuiabá", -15.5989, -56.0949, estatisticas),
                new Cidade("Curitiba", -25.4297, -49.2711, estatisticas),
                new Cidade("Florianópolis", -27.5935, -48.55854, estatisticas),
                new Cidade("Fortaleza", -3.7275, -38.5275, estatisticas),
                new Cidade("Goiânia", -16.6667, -49.25, estatisticas),
                new Cidade("João Pessoa", -7.12, -34.88, estatisticas),
                new Cidade("Macapá", 0.033, -51.05, estatisticas),
                new Cidade("Maceió", -9.66583, -35.73528, estatisticas),
                new Cidade("Manaus", -3.1189, -60.0217, estatisticas),
                new Cidade("Natal", -5.7833, -35.2, estatisticas),
                new Cidade("Palmas", -10.16745, -48.32766, estatisticas),
                new Cidade("Porto Alegre", -30.0331, -51.23, estatisticas),
                new Cidade("Porto Velho", -8.76194, -63.90389, estatisticas),
                new Cidade("Recife", -8.05, -34.9, estatisticas),
                new Cidade("Rio Branco", -9.97472, -67.81, estatisticas),
                new Cidade("Rio de Janeiro", -22.9111, -43.2056, estatisticas),
                new Cidade("Salvador", -12.9747, -38.4767, estatisticas),
                new Cidade("São Luís", -2.5283, -44.3044, estatisticas),
                new Cidade("São Paulo", -23.55, -46.6333, estatisticas),
                new Cidade("Teresina", -5.08917, -42.80194, estatisticas),
                new Cidade("Vitória", -20.2889, -40.3083, estatisticas)
        };

        return cidades;
    }
}