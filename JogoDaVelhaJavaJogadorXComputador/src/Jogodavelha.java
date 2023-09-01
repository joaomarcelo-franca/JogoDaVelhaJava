import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogodavelha{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char jogador = 'X';
        int j = 0;
        int coluna, linha;
        System.out.println("Bem Vindo ao Jogo da Velha!!!!");
        char[][] mesa = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

        do {
            try {
//              Imprimir Tabela
                MetodosJogoDaVelha.ImprimirTabela(mesa);

//                Caso de velha = 9 jogadas e nenhum vencedor
                j = MetodosJogoDaVelha.VerificarVelha(j);
                if (j == 10){break;}

//              Informa o jogador e pega os dados
                if (jogador == 'X'){
                    System.out.println("Vez do jogador: " + jogador);
                    System.out.print("Digite a coluna: ");
                    coluna = scanner.nextInt();
                    System.out.print("Digite a linha: ");
                    linha = scanner.nextInt();
                } else {
                    System.out.printf("%s", "Vez do computador");
                    coluna = MetodosJogoDaVelha.ComputadorJoga.ComputadorColuna();
                    linha = MetodosJogoDaVelha.ComputadorJoga.ComputadorLinha();
                }


//                Caso o jogador tente jogar em uma posicao da ocupada
                if(mesa[linha][coluna] == 'X' || mesa[linha][coluna] == '0'){
                    System.out.println("Posição ocupada, jogue novamente");
                    if (jogador == 'X'){
                        jogador = '0';
                    } else {
                        jogador = 'X';
                        System.out.println("Computador jogou em uma posicao ocupada");
                    }
                    j--;
                } else {
                    mesa[linha][coluna] = jogador;
                    System.out.println();
                    if (jogador == 'X'){
                        System.out.printf("%s %c %s %d %s %d \n","Jogador: ", jogador, " jogou na posicao coluna: ", coluna, " na linha: ", linha);
                    } else{
                        System.out.printf("%s %d %s %d", "Computador jogou na posicao coluna:", coluna, "na linha:", linha);
                    }
                    System.out.println();
                }

//                Verificar Ganhador
                j = MetodosJogoDaVelha.VerificarGanhador(mesa,jogador,j);

            }

//            Error de entrada
            catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.out.println();
                System.out.println("O que voce nos informou não é uma coluna ou linha");
                System.out.println("Colunas e linhas: 0,1,2");
                System.out.println("Jogada Invalida, Jogue novamente!");
                System.out.println();
                if (jogador == 'X'){
                    jogador = '0';
                } else {
                    jogador = 'X';
                }
                j--;
            }

            finally {
                j++;
                if (jogador == 'X'){
                    jogador = '0';
                } else {
                    jogador = 'X';
                }
            }
        }
        while(j <= 9);
        System.out.println("Caso queira jogar novamente digite: Jogar, ou caso deseje sair digite sair: Sair");
        String confirmacao = scanner.next();
        if (confirmacao.equalsIgnoreCase("jogar")){
            main(args);
        } else{
            System.out.println("Obrigado por jogar o Jogo da Velha");
            System.out.println("Feito por: Joao Marcelo Franca");
        }
    }
}