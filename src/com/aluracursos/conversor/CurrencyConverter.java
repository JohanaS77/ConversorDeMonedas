package com.aluracursos.conversor;

import java.util.Scanner;

public class CurrencyConverter {
    private ConversionService conversionService;

    public CurrencyConverter() {
        // Inicializa la instancia de ConversionService
        this.conversionService = new ConversionService();
    }

    public void convertir() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el monto en Dólares: ");
        double monto = scanner.nextDouble();

        // Aquí puedes llamar al método convertir de ConversionService
        Double resultado = conversionService.convertir("USD", "ARS", monto); // Ejemplo: convertir de USD a ARS

        if (resultado != null) {
            System.out.println("El monto convertido es: " + resultado);
        } else {
            System.out.println("Error al realizar la conversión.");
        }
    }
}


