package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean victoria = false;
        char turn = '0';
        int fila;

        Scanner scanner = new Scanner(System.in);
        StringBuilder fila1 = new StringBuilder("        ");
        StringBuilder fila2 = new StringBuilder("        ");
        StringBuilder fila3 = new StringBuilder("        ");
        StringBuilder fila4 = new StringBuilder("        ");
        StringBuilder fila5 = new StringBuilder("        ");
        StringBuilder fila6 = new StringBuilder("        ");
        String[] filas;
        while(!victoria){
            fila = scanner.nextInt()-1;
            System.out.flush();
            if (fila < 0 || fila > 7) {
                System.out.println("Columna inválida. Intente de nuevo.");
                continue;
            }
            if (fila1.charAt(fila) == ' ') fila1.setCharAt(fila, turn);
            else if (fila2.charAt(fila) == ' ') fila2.setCharAt(fila, turn);
            else if (fila3.charAt(fila) == ' ') fila3.setCharAt(fila, turn);
            else if (fila4.charAt(fila) == ' ') fila4.setCharAt(fila, turn);
            else if (fila5.charAt(fila) == ' ') fila5.setCharAt(fila, turn);
            else if (fila6.charAt(fila) == ' ') fila6.setCharAt(fila, turn);
            else {System.out.println("INVALID"); continue;}

            System.out.printf("\n|%s|", fila6);
            System.out.printf("\n|%s|", fila5);
            System.out.printf("\n|%s|", fila4);
            System.out.printf("\n|%s|", fila3);
            System.out.printf("\n|%s|", fila2);
            System.out.printf("\n|%s|", fila1);
            System.out.println("\n\\--------/");
            if (turn == '0') turn = '1';
            else turn = '0';

            filas = new String[]{fila1.toString(), fila2.toString(), fila3.toString(), fila4.toString(), fila5.toString(), fila6.toString()};
            //comprovar si ha ganado alguien
            //victoria en fila
            for (String filaactual : filas){
                if (filaactual.contains("0000") || filaactual.contains("1111")){
                    victoria = true;
                    break;
                }
            }

            //victoria en columna

            for (int i = 0; i < 7; i++) {
                String columna = "";
                columna = columna + fila1.charAt(i);
                columna = columna + fila2.charAt(i);
                columna = columna + fila3.charAt(i);
                columna = columna + fila4.charAt(i);
                columna = columna + fila5.charAt(i);
                columna = columna + fila6.charAt(i);
                if (columna.contains("0000") || columna.contains("1111")){
                    victoria = true;
                    break;
                }
            }

            // victoria diagonal
            for (int i = 0; i < filas.length && !victoria; i++) {
                for (int j = 0; j < filas[i].length(); j++) {
                    char actual = filas[i].charAt(j);
                    if (actual == ' ') {
                        continue;
                    }

                    if (i >= 3 && j <= filas[0].length() - 4){
                        if (actual == filas[i-1].charAt(j+1) &&
                                actual == filas[i-2].charAt(j+2) &&
                                actual == filas[i-3].charAt(j+3)){
                            victoria = true;
                        }
                    }
                    if (i <= filas.length - 4 && j <= filas[0].length() - 4){
                        if (actual == filas[i+1].charAt(j+1) &&
                                actual == filas[i+2].charAt(j+2) &&
                                actual == filas[i+3].charAt(j+3)){
                            victoria = true;
                        }
                    }
                }
            }
        }
    }
}
