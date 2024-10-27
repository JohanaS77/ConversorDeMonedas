package com.aluracursos.conversor;

import java.util.Scanner;

public class MenuHandler {
    //private static final ConversionService conversionService = new ConversionService();
    private static final Scanner scanner = new Scanner(System.in);

    public MenuHandler(CurrencyConverter currencyConverter) {

    }

    public static void mostrarMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("******************************************");
            System.out.println("Sea Bienvenid@ al Conversor de Moneda");
            System.out.println("1. Dólar =>> Peso argentino");
            System.out.println("2. Peso argentino =>> Dólar");
            System.out.println("3. Dólar =>> Real brasileño");
            System.out.println("4. Real brasileño =>> Dólar");
            System.out.println("5. Dólar =>> Peso colombiano");
            System.out.println("6. Peso colombiano =>> Dólar");
            System.out.println("7. Salir");
            System.out.print("Elija una opción válida: ");
            ConversionService ApiConversion = new ConversionService();
            int opcion = scanner.nextInt();
            double monto;

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el monto en Dólares: ");
                    monto = scanner.nextDouble();
                    Double resultado1 = ApiConversion.convertir("USD", "ARS", monto);
                    System.out.println("Resultado: " + resultado1 + " Pesos argentinos");
                    break;
                case 2:
                    System.out.print("Ingrese el monto en Pesos argentinos: ");
                    monto = scanner.nextDouble();
                    Double resultado2 = ApiConversion.convertir("ARS", "USD", monto);
                    System.out.println("Resultado: " + resultado2 + " Dólares");
                    break;
                case 3:
                    System.out.print("Ingrese el monto en Dólares: ");
                    monto = scanner.nextDouble();
                    Double resultado3 = ApiConversion.convertir( "USD",  "BRL", monto);
                    System.out.println("Resultado: " + resultado3 + " Reales brasileños");
                    break;
                case 4:
                    System.out.print("Ingrese el monto en Reales brasileños: ");
                    monto = scanner.nextDouble();
                    Double resultado4 = ApiConversion.convertir("BRL", "USD", monto);
                    System.out.println("Resultado: " + resultado4 + " Dólares");
                    break;
                case 5:
                    System.out.print("Ingrese el monto en Dólares: ");
                    monto = scanner.nextDouble();
                    Double resultado5 = ApiConversion.convertir( "USD", "COP", monto);
                    System.out.println("Resultado: " + resultado5 + " Pesos colombianos");
                    break;
                case 6:
                    System.out.print("Ingrese el monto en Pesos colombianos: ");
                    monto = scanner.nextDouble();
                    Double resultado6 = ApiConversion.convertir("COP", "USD", monto);
                    System.out.println("Resultado: " + resultado6 + " Dólares");
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Gracias por usar el conversor de moneda. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del 1 al 7.");
            }
            System.out.println(); // Línea en blanco para mayor claridad
        }

        scanner.close();
    }
}