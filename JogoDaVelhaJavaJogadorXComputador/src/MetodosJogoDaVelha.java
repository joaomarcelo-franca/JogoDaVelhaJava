import java.util.Random;

public class MetodosJogoDaVelha {
    public static void ImprimirTabela(char[][] mesa){
        System.out.println();
        System.out.println("    0   1   2");
        for (int i = 0; i < mesa.length; i++) {
            System.out.printf("%s %d %c %s %c %s %c \n"," ", i, mesa[i][0], "|", mesa[i][1], "|", mesa[i][2] );
        }
    }
    public static int VerificarGanhador(char[][] mesa, char jogador, int j){
//        Verificar Linhas
        for (int i = 0; i < mesa.length; i++) {
            if (mesa[i][0] == jogador && mesa[i][1] == jogador && mesa[i][2] == jogador){
                ImprimirTabela(mesa);
                System.out.printf("%s %c \n", "O Vencedor da rodada e o jogador: ", jogador);
                return 10;
            }
        }
//                Verificar Colunas
        for (int i = 0; i < mesa.length; i++) {
            if (mesa[0][i] == jogador && mesa[1][i] == jogador && mesa[2][i] == jogador){
                ImprimirTabela(mesa);
                System.out.printf("%s %c \n", "O Vencedor da rodada e o jogador: ", jogador);
                return 10;
            }
        }
//                Verificar diagonais
        for (int i = 0; i < mesa.length; i++) {
            if (mesa[0][0] == jogador && mesa[1][1] == jogador && mesa[2][2] == jogador){
                ImprimirTabela(mesa);
                System.out.printf("%s %c \n", "O Vencedor da rodada e o jogador: ", jogador);
                return 10;
            }
            if (mesa[0][2] == jogador && mesa[1][1] == jogador && mesa[2][0] == jogador){
                ImprimirTabela(mesa);
                System.out.printf("%s %c \n", "O Vencedor da rodada e o jogador: ", jogador);
                return 10;
            }
        }
        return j;
    }

    public static int VerificarVelha(int j){
        if (j == 9){
            System.out.println("O Jogo deu velha! Nenhum jogador venceu");
            return j = 10;
        }
        return j;
    }

    public class ComputadorJoga {
        static Random random = new Random();
        public static int ComputadorLinha(){
            int computadorLinha;
            computadorLinha = random.nextInt(3);
            return computadorLinha;
        }
        public static int ComputadorColuna(){
            int computadorColuna;
            computadorColuna = random.nextInt(3);
            return computadorColuna;
        }
    }
}
