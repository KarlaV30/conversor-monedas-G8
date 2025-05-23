package com.sc30.conversor.controller;

import com.sc30.conversor.service.ConversorService;

import java.io.IOException;
import java.util.Scanner;


public class ConversorMenuController {

    private final ConversorService conversorService = new ConversorService();
    private final Scanner sc = new Scanner(System.in);

    public void conversorMenu() throws IOException, InterruptedException {

        System.out.println("**************Bienvenido al convertidor de monedas***********************");

        int opcion;

        do {
            System.out.printf(
                    """
                       \nMenu
                       1) Dollar a Colones Costarricense (CRC)
                       2) Colones Costarricense (CRC) a Dollar
                       3) Dollar a Real Brasileño
                       4) Real Brasileño a Dollar
                       5) Dollar a Peso Colombiano
                       6) Peso Colombiano a Dollar
                       7) Salir
                       """
            );

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                   manejarConversion("USD","CRC");
                    break;

                case 2:
                    manejarConversion("CRC","USD");
                    break;

                case 3:
                    manejarConversion("USD","BRL");
                    break;
                case 4:
                    manejarConversion("BRL","USD");
                    break;
                case 5:
                    manejarConversion("USD","COP");
                    break;

                case 6:
                    manejarConversion("COP","USD");
                    break;

                case 7:
                    System.out.println("Gracias, Vuelve Pronto.");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }
        while (opcion != 7);
        sc.close();
    }
    private void manejarConversion(String base, String destino) {
        System.out.println("Ingresa el valor que deseas convertir: ");
        double cantidad = sc.nextDouble();
        try {
            double resultado = conversorService.convertirMoneda(base, destino, cantidad);
            System.out.printf("Resultado de conversión: %.2f %s%n", resultado, destino);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al convertir moneda: " + e.getMessage());
        }
    }

}
