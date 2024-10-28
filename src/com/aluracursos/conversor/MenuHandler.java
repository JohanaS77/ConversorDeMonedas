package com.aluracursos.conversor;

import java.util.Scanner;
import javax.swing.JOptionPane;

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
//            int opcion = scanner.nextInt();
            var  opcion = JOptionPane .showInputDialog( "\nSea Bienvenid@ al Conversor de Moneda"
                    + "\n1. Dólar =>> Peso argentino "
                    + "\n2. Peso argentino =>> Dólar "
                    + "\n3. Dólar =>> Real brasileño "
                    + "\n4. Real brasileño =>> Dólar "
                    + "\n5. Dólar =>> Peso colombiano"
                    + "\n6. Peso colombiano =>> Dólar"
                    + "\n7. Salir"
                    + "\nElija una opción válida:");
            double monto;
            var valor = "";
            switch (Integer.parseInt(opcion)) {
                case 1:
                    System.out.print("Ingrese el monto en Dólares: ");
//                    monto = scanner.nextDouble();
                    valor = JOptionPane .showInputDialog( "Ingrese el monto en Dólares: ");
                    Double resultado1 = ApiConversion.convertir("USD", "ARS", Integer.parseInt(valor));
                    System.out.println("Resultado: " + resultado1 + " Pesos argentinos");
                    JOptionPane.showMessageDialog(null, "Resultado: " + resultado1 + " Pesos argentinos"
                            );
                    break;
                case 2:
                    System.out.print("Ingrese el monto en Pesos argentinos: ");
                    valor = JOptionPane .showInputDialog( "Ingrese el monto en Pesos argentinos: ");
//                    monto = scanner.nextDouble();
                    Double resultado2 = ApiConversion.convertir("ARS", "USD", Integer.parseInt(valor));
                    System.out.println("Resultado: " + resultado2 + " Dólares");
                    JOptionPane.showMessageDialog(null, "Resultado: " + resultado2 + " Dólares"
                    );
                    break;
                case 3:
                    System.out.print("Ingrese el monto en Dólares: ");
                    valor = JOptionPane .showInputDialog( "Ingrese el monto en Dólares: ");
//                    monto = scanner.nextDouble();
                    Double resultado3 = ApiConversion.convertir( "USD",  "BRL", Integer.parseInt(valor));
                    System.out.println("Resultado: " + resultado3 + " Reales brasileños");
                    JOptionPane.showMessageDialog(null, "Resultado: " + resultado3 + " Reales brasileños"
                    );
                    break;
                case 4:
                    System.out.print("Ingrese el monto en Reales brasileños: ");
                    valor = JOptionPane .showInputDialog( "Ingrese el monto en Reales brasileños: ");
//                    monto = scanner.nextDouble();
                    Double resultado4 = ApiConversion.convertir("BRL", "USD", Integer.parseInt(valor));
                    System.out.println("Resultado: " + resultado4 + " Dólares");
                    JOptionPane.showMessageDialog(null, "Resultado: " + resultado4 + " Dólares"
                    );
                    break;
                case 5:
                    System.out.print("Ingrese el monto en Dólares: ");
                    valor = JOptionPane .showInputDialog( "Ingrese el monto en Dólares: ");
//                    monto = scanner.nextDouble();
                    Double resultado5 = ApiConversion.convertir( "USD", "COP", Integer.parseInt(valor));
                    System.out.println("Resultado: " + resultado5 + " Pesos colombianos");
                    JOptionPane.showMessageDialog(null, "Resultado: " + resultado5 + " Pesos colombianos"
                    );
                    break;
                case 6:
                    System.out.print("Ingrese el monto en Pesos colombianos: ");
                    valor = JOptionPane .showInputDialog( "Ingrese el monto en Pesos colombianos: ");
//                    monto = scanner.nextDouble();
                    Double resultado6 = ApiConversion.convertir("COP", "USD", Integer.parseInt(valor));
                    System.out.println("Resultado: " + resultado6 + " Dólares");
                    JOptionPane.showMessageDialog(null, "Resultado: " + resultado6 + " Dólares"
                    );
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