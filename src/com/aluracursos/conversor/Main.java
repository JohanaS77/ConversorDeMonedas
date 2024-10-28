package com.aluracursos.conversor;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ConversionService res = new ConversionService();
        CurrencyConverter currencyConverter = new CurrencyConverter();
        MenuHandler menuHandler = new MenuHandler(currencyConverter);
        menuHandler.mostrarMenu();
        Scanner scanner = new Scanner(System.in);
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
            int opcion = scanner.nextInt();
            double monto;

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el monto en Dólares: ");
                    monto = scanner.nextDouble();
                    Double resultado1 = res.convertir("USD", "ARS", monto);
                    System.out.println("Resultado: " + resultado1 + " Pesos argentinos");
                    break;
//                case 2:
//                    System.out.print("Ingrese el monto en Pesos argentinos: ");
//                    monto = scanner.nextDouble();
//                    Double resultado2 = conversionService.convertir("ARS", "USD", monto);
//                    System.out.println("Resultado: " + resultado2 + " Dólares");
//                    break;
//                case 3:
//                    System.out.print("Ingrese el monto en Dólares: ");
//                    monto = scanner.nextDouble();
//                    Double resultado3 = conversionService.convertir("USD", "BRL", monto);
//                    System.out.println("Resultado: " + resultado3 + " Reales brasileños");
//                    break;
//                case 4:
//                    System.out.print("Ingrese el monto en Reales brasileños: ");
//                    monto = scanner.nextDouble();
//                    Double resultado4 = conversionService.convertir("BRL", "USD", monto);
//                    System.out.println("Resultado: " + resultado4 + " Dólares");
//                    break;
//                case 5:
//                    System.out.print("Ingrese el monto en Dólares: ");
//                    monto = scanner.nextDouble();
//                    Double resultado5 = conversionService.convertir("USD", "COP", monto);
//                    System.out.println("Resultado: " + resultado5 + " Pesos colombianos");
//                    break;
//                case 6:
//                    System.out.print("Ingrese el monto en Pesos colombianos: ");
//                    monto = scanner.nextDouble();
//                    Double resultado6 = conversionService.convertir("COP", "USD", monto);
//                    System.out.println("Resultado: " + resultado6 + " Dólares");
//                    break;
//                case 7:
//                    continuar = false;
//                    System.out.println("Gracias por usar el conversor de moneda. ¡Hasta luego!");
//                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del 1 al 7.");
            }
            System.out.println(); // Línea en blanco para mayor claridad
        }

        scanner.close();
    }
}
