/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author Isabe
 */

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Clima {
    private Cidade cidade;

    public Clima(Cidade cidade){
        this.cidade = cidade;
    }

    public void buscarPrevisao(){

        OkHttpClient cliente = new OkHttpClient();


        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + cidade.getLatitude() + "&longitude=" + cidade.getLongitude() + "&hourly=temperature_2m&timezone=auto&forecast_days=" + cidade.NUM_DIAS;

        Request requisicaoHttp = new Request.Builder().url(url).build();


        try (Response respostaHttp = cliente.newCall(requisicaoHttp).execute()) {

            if (!respostaHttp.isSuccessful()) {
                throw new IOException("Erro ao obter resposta: " + respostaHttp);
            } else {

                String respostaBody = respostaHttp.body().string();

               
                double[][] temperaturas = parsearRespostaHttp(respostaBody);
                for (int i = 0; i < cidade.NUM_DIAS; i++) {
                    cidade.temperaturasPorDias[i] = temperaturas[i];
                }
                cidade.calcularEstatisticas();
            }
        } catch (IOException e) {
            System.err.println("Erro ao fazer requisição: " + e.getMessage());
        }
    }

    public double[][] parsearRespostaHttp(String respostaBody){
        Gson gson = new Gson();
        JsonObject objetoJson = gson.fromJson(respostaBody, JsonObject.class);
        JsonElement elementoHourly = objetoJson.get("hourly");
        JsonElement elementoTemperaturas = elementoHourly.getAsJsonObject().get("temperature_2m");
        JsonArray arrayTemperaturas = elementoTemperaturas.getAsJsonArray();

        double[][] temperaturas = new double[cidade.NUM_DIAS][24];
        int index = 0;
        for (int i = 0; i < cidade.NUM_DIAS; i++) {
            for (int j = 0; j < 24; j++) {
                temperaturas[i][j] = arrayTemperaturas.get(index).getAsDouble();
                index++;
            }
        }

        return temperaturas;
    }
}