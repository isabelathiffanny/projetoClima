/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author Isabe
 */

public class Cidade {
    public static final int NUM_DIAS = 15; 

    private String nome;
    private double latitude;
    private double longitude;
    public double[][] temperaturasPorDias;
    private double[] mediasTemps;
    private double[] minTemps;
    private double[] maxTemps;

    public Cidade(String nome, double latitude, double longitude){
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperaturasPorDias = new double[NUM_DIAS][24];
        this.mediasTemps = new double[NUM_DIAS];
        this.minTemps = new double[NUM_DIAS];
        this.maxTemps = new double[NUM_DIAS];
    }

   
    public String getNome() { return nome; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public double[][] getTemperaturasPorDias() { return temperaturasPorDias; }
    public double[] getMediasTemps() { return mediasTemps; }
    public double[] getMinTemps() { return minTemps; }
    public double[] getMaxTemps() { return maxTemps; }

  
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public void setTemperaturasPorDias(double[][] temperaturasPorDias) {
        this.temperaturasPorDias = temperaturasPorDias;
    }
    public void setMediasTemps(double[] mediasTemps) {
        this.mediasTemps = mediasTemps;
    }
    public void setMinTemps(double[] minTemps) {
        this.minTemps = minTemps;
    }
    public void setMaxTemps(double[] maxTemps) {
        this.maxTemps = maxTemps;
    }

    // Chamar a API com dados climáticos
    public void buscarPrevisao(){
        Clima clima = new Clima(this);

        clima.buscarPrevisao();
    }

   
    public void calcularEstatisticas() {
        for (int i = 0; i < NUM_DIAS; i++) {
            double soma = 0;
            for (int j = 0; j < 24; j++) {
                soma += temperaturasPorDias[i][j];
            }
            mediasTemps[i] = soma / 24;

            minTemps[i] = temperaturasPorDias[i][0];
            maxTemps[i] = temperaturasPorDias[i][0];
            for (int j = 0; j < 24; j++) {
                if (temperaturasPorDias[i][j] < minTemps[i]) {
                    minTemps[i] = temperaturasPorDias[i][j];
                }
                if (temperaturasPorDias[i][j] > maxTemps[i]) {
                    maxTemps[i] = temperaturasPorDias[i][j];
                }
            }
        }
    }

   
    public void mostrarTemperaturasDosDias() {
        for (int i = 0; i < NUM_DIAS; i++) {
            System.out.println("Dia " + (i + 1) + ":");
            for (int j = 0; j < 24; j++) {
                System.out.print(temperaturasPorDias[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void mostrarEstatisticasDosDias() {
        System.out.println(this.nome);
        for (int i = 0; i < NUM_DIAS; i++) {
            System.out.println("    Dia " + String.format("%02d", i + 1) + ":   " +
                    "Média = " + String.format("%.1f", mediasTemps[i]) +
                    ", mínima = " + minTemps[i] +
                    ", MÁXIMA = " + maxTemps[i]);
        }
    }
}
