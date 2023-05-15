package jogo_da_velha;

import java.util.Scanner;

class Entrada {

    Scanner sc = new Scanner(System.in);

    public String entradaTexto(String texto) {
        System.out.print(texto);
        texto = sc.nextLine();
        return texto;
    }
    
     public char entradaCharSN(String Texto) {
        boolean isChar = true;
        String aux;
        char letra = ' ';
        do {
            aux = entradaTexto(Texto);
            if (aux.length() != 1 && (aux.toLowerCase() != "s" || aux.toLowerCase()!= "n")){
                isChar = false;
                System.out.println("Digite um caractere Valido");
            }
            letra = aux.charAt(0);
        } while (isChar == false);
        return letra;
    }

    public int entradaInteiro(String Texto) {
        boolean isNum = true;
        int num = 0;
        do {
            String aux = entradaTexto(Texto);
            try {
                num = Integer.parseInt(aux);
            } catch (Exception e) {
                isNum = false;
                System.out.print("Digite um numero inteiro valido: ");
            }
        } while (isNum == false);
        return num;
    }

    public float entradaFloat(String Texto) {
        boolean isNum = true;
        float num = 0f;
        do {
            String aux = entradaTexto(Texto);
            try {
                num = Float.parseFloat(aux);
            } catch (Exception e) {
                isNum = false;
                System.out.print("Digite um numero inteiro valido: ");
            }
        } while (isNum == false);
        return num;
    }

}
