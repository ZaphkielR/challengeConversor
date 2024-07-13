package com.challenge.ConversorDeMonedas;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private String URL_BASE = "https://v6.exchangerate-api.com/v6/";
    private ConsumoAPI api = new ConsumoAPI();

    @Value("${api.key}")
    private String APIKEY;

    public void muestraElMenu() {
        var opcion = -1;

        while (opcion != 0 ) {
            var menu = """
                    ****************************************************
                    Sea bienvenido/a al conversor de moneda
                    
                    1) Dólar => Peso Argentina
                    2) Peso argentino => Dolar
                    3) Dólar => Real Brasileño
                    4) Real Brasileño => Dólar
                    5) Dólar => Peso Colombiano
                    6) Peso Colombiano => Colombiano => Dólar
                    7) Salir
                    
                    Elige una opción Valida: 
                    ****************************************************
                    """;

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    cambioMoneda("USD", "ARS");
                    break;
                case 2:
                    cambioMoneda("ARS", "USD");
                    break;
                case 3:
                    cambioMoneda("USD", "BRL");
                    break;
                case 4:
                    cambioMoneda("BRL", "USD");
                    break;
                case 5:
                    cambioMoneda("USD", "COP");
                    break;
                case 6:
                    cambioMoneda("COP", "USD");
                    break;
                case 7:
                    System.out.println("#### - Cerrando la Apicacion - ####");
                    opcion = 0;
                    break;
                default:
                    System.out.println("Opción Invalida");
                    break;
            }
        }

    }

    private void cambioMoneda(String monedaOrigen, String monedaConversion) {
        System.out.println("Ingrese el valor que desea convertir");
        var valor = teclado.nextDouble();
        teclado.nextLine();

        var json = api.obtenerDatos(URL_BASE + "4dbf510e4de721ea2b5d6bf7" + "/latest/"+ monedaOrigen);

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        Map<String, Double> cambio = gson.fromJson(conversionRates, Map.class);

        System.out.println("El valor de " + String.format("%.2f",valor)
                + " [" +monedaOrigen + "] " + "corresponde al valor de => "
                + String.format("%.2f",valor*cambio.get(monedaConversion))
                + " [" + monedaConversion + "]");
        return;
    }
}
