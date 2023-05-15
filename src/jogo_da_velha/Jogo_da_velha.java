package jogo_da_velha;

public class Jogo_da_velha {

    static String[][] Matriz = new String[3][3];
    static boolean valida = false;
    static boolean isX = true;
    static char replay = 'S';
    static String nome1, nome2;
    public static Entrada e = new Entrada();

    public static void main(String[] args) {
        gameLoop();
    }

    public static void gameLoop() {

        while (replay == 'S' || replay == 's') {
            entrada();
            zerarMatriz();
            imprime();

            for (int i = 0; i < 5; i++) {
                jogada();
                if (i == 4) {
                    imprime();
                    valida();
                    if (valida == true) {
                        break;
                    }
                    System.out.println("O jogo empatou!!");
                    replay();
                    break;
                }
                imprime();
                valida();
                if (valida == true) {
                    break;
                }
                jogada();
                imprime();
                valida();
                if (valida == true) {
                    break;
                }
            }
        }
    }

    public static void zerarMatriz() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Matriz[i][j] = " ";
            }
        }
    }

    public static void entrada() {
        nome1 = e.entradaTexto("Digite o nome do jogador X: ");
        nome2 = e.entradaTexto("Digite o nome do jogador O: ");
    }

    public static void jogada() {
        String play;
        int col = 0;
        String p1, p2;
        boolean validajog = false;
        String jog;

        do {
            if (isX == true) {
                play = "x";
                jog = e.entradaTexto("Digite a jogada do " + nome1 + ": ");
            } else {
                play = "o";
                jog = e.entradaTexto("Digite a jogada do " + nome2 + ": ");
            }
            if (jog.length() == 2) {
                p1 = jog.substring(0, 1).toLowerCase();
                p2 = jog.substring(1, 2);

                if ("012".contains(p2) && "abc".contains(p1)) {
                    switch (p1) {
                        case "a" ->
                            col = 0;
                        case "b" ->
                            col = 1;
                        case "c" ->
                            col = 2;
                    }
                    if (" ".equals(Matriz[Integer.parseInt(p2)][col])) {
                        Matriz[Integer.parseInt(p2)][col] = play;
                        validajog = true;
                        isX = !isX;
                    } else {
                        System.out.println("Jogada Invalida");
                        imprime();
                    }
                } else {
                    System.out.println("Jogada Invalida");
                    imprime();
                }
            } else {
                System.out.println("Jogada Invalida");
                imprime();
            }
        } while (validajog == false);
    }

    public static void imprime() {
        System.out.print("     A     B     C\n");
        for (int j = 0; j < 3; j++) {
            System.out.print(j + " |");
            for (int i = 0; i < 3; i++) {
                System.out.print("  " + Matriz[j][i] + "  |");
            }
            System.out.println();
        }
        System.out.println("");
    }

    public static void replay() {
        replay = e.entradaCharSN("Você Deseja Reiniciar o Jogo?(S/N)");
        if (replay == 's' || replay == 'S') {
            valida = false;
            isX = true;
            gameLoop();
        }
    }

    public static void valida() {

        //valida linha
        for (int i = 0; i < 3; i++) {
            if (Matriz[i][0] == Matriz[i][1] && Matriz[i][1] == Matriz[i][2]) {
                if (Matriz[i][0] == "x" && Matriz[i][1] == "x") {
                    System.out.println("O " + nome1 + " venceu o jogo");
                    valida = true;
                    replay();
                } else if (Matriz[i][1] == "o") {
                    System.out.println("O " + nome2 + " venceu o jogo");
                    valida = true;
                    replay();
                }
            }
        }

        //valida coluna 
        for (int i = 0; i < 3; i++) {
            if (Matriz[0][i] == Matriz[1][i] && Matriz[1][i] == Matriz[2][i]) {
                if (Matriz[0][i] == "x" && Matriz[1][i] == "x") {
                    System.out.println("O " + nome1 + " venceu o jogo");
                    valida = true;
                    replay();
                } else if (Matriz[1][i] == "o") {
                    System.out.println("O " + nome2 + " venceu o jogo");
                    valida = true;
                    replay();
                }
            }
        }

        // valida diagonal principal
        if (Matriz[0][0] == Matriz[2][2] && Matriz[0][0] == Matriz[1][1]) {
            if (Matriz[0][0] == "x" && Matriz[2][2] == "x") {
                System.out.println("O " + nome1 + " venceu o jogo");
                valida = true;
                replay();
            } else if (Matriz[2][2] == "o") {
                System.out.println("O " + nome2 + " venceu o jogo");
                valida = true;
                replay();
            }
        }

        //valida diagonal secundária
        if (Matriz[2][0] == Matriz[0][2] && Matriz[2][0] == Matriz[1][1]) {
            if (Matriz[2][0] == "x" && Matriz[0][2] == "x") {
                System.out.println("O " + nome1 + " venceu o jogo");
                valida = true;
                replay();
            } else if (Matriz[2][0] == "o") {
                System.out.println("O " + nome2 + " venceu o jogo");
                valida = true;
                replay();
            }
        }
    }
}
