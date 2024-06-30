/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author Isabe
 */

import java.time.Instant;
import java.time.Duration;

public class Main {
    public static void main(String[] args){
       
        Cidade[] cidades = inicializarCidades();
        Duration[] temposExecucao = new Duration[10];
        double somaTemposExecucao = 0.0;
        double mediaTemposExecucao = 0.0;

        for (int i = 0; i < 10; i++){
            Instant inicioInstante = Instant.now();
            for(Cidade cidade: cidades) {
                cidade.buscarPrevisao(); 
                cidade.mostrarEstatisticasDosDias();
            }
            Instant fimInstante = Instant.now();
            temposExecucao[i] = Duration.between(inicioInstante, fimInstante);

            System.out.println("Tempo de execução (" + (i + 1) + "ª rodada): " + temposExecucao[i].toMillis() + " ms");

            somaTemposExecucao += (double)temposExecucao[i].toMillis();
        }

        mediaTemposExecucao = somaTemposExecucao / 10;
        System.out.println();
        System.out.println("Média (tempos de execução): " + mediaTemposExecucao + " ms");
    }

    private static Cidade[] inicializarCidades(){
        Cidade[] cidades = new Cidade[]{
                new Cidade("Aracaju", -10.9167, -37.05),
                new Cidade("Belém", -1.4558, -48.5039),
                new Cidade("Belo Horizonte", -19.9167, -43.9333),
                new Cidade("Boa Vista", 2.81972, -60.67333),
                new Cidade("Brasília", -15.7939, -47.8828),
                new Cidade("Campo Grande", -20.44278, -54.64639),
                new Cidade("Cuiabá", -15.5989, -56.0949),
                new Cidade("Curitiba", -25.4297, -49.2711),
                new Cidade("Florianópolis", -27.5935, -48.55854),
                new Cidade("Fortaleza", -3.7275, -38.5275),
                new Cidade("Goiânia", -16.6667, -49.25),
                new Cidade("João Pessoa", -7.12, -34.88),
                new Cidade("Macapá", 0.033, -51.05),
                new Cidade("Maceió", -9.66583, -35.73528),
                new Cidade("Manaus", -3.1189, -60.0217),
                new Cidade("Natal", -5.7833, -35.2),
                new Cidade("Palmas", -10.16745, -48.32766),
                new Cidade("Porto Alegre", -30.0331, -51.23),
                new Cidade("Porto Velho", -8.76194, -63.90389),
                new Cidade("Recife", -8.05, -34.9),
                new Cidade("Rio Branco", -9.97472, -67.81),
                new Cidade("Rio de Janeiro", -22.9111, -43.2056),
                new Cidade("Salvador", -12.9747, -38.4767),
                new Cidade("São Luís", -2.5283, -44.3044),
                new Cidade("São Paulo", -23.55, -46.6333),
                new Cidade("Teresina", -5.08917, -42.80194),
                new Cidade("Vitória", -20.2889, -40.3083)
        };

        return cidades;
    }
}