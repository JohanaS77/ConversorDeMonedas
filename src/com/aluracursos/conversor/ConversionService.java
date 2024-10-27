package com.aluracursos.conversor;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConversionService {
    private static final String API_KEY = "3abf15e6965fa59ba5ead818"; // Reemplaza con tu clave API

    public Double convertir(String monedaOrigen, String monedaDestino, double monto) {
        double resultado = 0;
        double cantidad = monto;
        String APIKey = "3abf15e6965fa59ba5ead818";

        try {
            // Construir la URL correctamente
            URL url = new URL("https://v6.exchangerate-api.com/v6/" + APIKey + "/pair/" + monedaOrigen + "/" + monedaDestino + "/" + cantidad);

            // Establecer la conexión HTTP
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            // Asegúrate de que conversionResponse no sea null
            if (request.getResponseCode() == 200) {
                // Analizar la respuesta JSON
                JsonObject root = JsonParser.parseReader(new InputStreamReader(request.getInputStream())).getAsJsonObject();

                // Verificar si los elementos necesarios no son nulos
                if (root.has("conversion_result") && root.has("conversion_rate") && root.has("time_last_update_utc")) {
                    // Obtener la tasa de conversión y reemplazar la coma por un punto
                    String tasaConversionStr = root.get("conversion_rate").getAsString();
                    tasaConversionStr = tasaConversionStr.replace(",", ".");
                    double tasaConversion = Double.parseDouble(tasaConversionStr);
                    String ultimaActualizacion = root.get("time_last_update_utc").getAsString();
                    //System.out.println("La tasa de conversión es de: $" + tasaConversion + "\nFecha: " + ultimaActualizacion);

                    // Obtener el resultado de la conversión
                    double conversionResult = root.get("conversion_result").getAsDouble();

                    // Formatear el resultado de la conversión
                    resultado = conversionResult;
                    //System.out.println("Resultado Total: " + conversionResult);
                } else {
                    System.out.println("La respuesta JSON no tiene los elementos esperados.");
                }
            } else {
                System.out.println("Error de Respuesta " + request.getResponseCode());
            }
            // Cerrar la conexión HTTP
            request.disconnect();
        } catch (MalformedURLException e) {
            System.out.println("URL mal formada: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de IO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return resultado;
    }


    // Este método no está implementado, puedes eliminarlo o implementarlo según sea necesario
    public ConversionResponse getConversionRates(String monedaOrigen) {
        return null;
    }
}


//public Double convertir(String monedaOrigen, String monedaDestino, double monto) {
//    try {
//        // Construir la URL correctamente
//        String url = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", API_KEY, monedaOrigen);
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        // Imprimir la respuesta de la API
//        System.out.println("Respuesta de la API: " + response.body());
//
//        Gson gson = new Gson();
//        ConversionResponse conversionResponse = gson.fromJson(response.body(), ConversionResponse.class);
//
//        // Asegúrate de que conversionResponse no sea null
//        if (conversionResponse != null && conversionResponse.getConversionRates() != null) {
//            // Verifica si la moneda destino está en la respuesta
//            Map<String, Double> conversionRates = conversionResponse.getConversionRates();
//            if (conversionRates.containsKey(monedaDestino)) {
//                double tasaCambio = conversionRates.get(monedaDestino);
//                return monto * tasaCambio; // Retorna el monto convertido
//            } else {
//                System.out.println("La moneda destino no está disponible.");
//                return null;
//            }
//        } else {
//            System.out.println("La respuesta de conversión es nula.");
//            return null;
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//        return null;
//    }
//}




