package PROJETOS.Sudoku;

import java.util.Scanner;

public class Sudoku {
    private final int[][] tabuleiro = new int[9][9];
    private  final boolean[][] fixos = new boolean[9][9];
    private final Scanner scanner = new Scanner(System.in);

    public void iniciarJogo(int[][] numerosFixos) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                tabuleiro[i][j] = numerosFixos[i][j];
                fixos[i][j] = numerosFixos[i][j] != 0;
            }
    }

    public void mostrarTabuleiro() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0)
                System.out.println("------+-------+------");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0)
                    System.out.print("| ");
                System.out.print((tabuleiro[i][j] == 0 ? "." : tabuleiro[i][j]) + " ");
            }
            System.out.println();
        }
    }

    public boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < 9 && coluna >= 0 && coluna < 9;
    }

    public boolean colocarNumero(int num, int linha, int coluna) {
        if (!posicaoValida(linha, coluna))
            return false;
        if (fixos[linha][coluna])
            return false;
        if (num < 1 || num > 9)
            return false;
        if (tabuleiro[linha][coluna] != 0)
            return false;
        if (temConflito(num, linha, coluna))
            return false;
        tabuleiro[linha][coluna] = num;
        return true;
    }

    public boolean removerNumero(int linha, int coluna) {
        if (!posicaoValida(linha, coluna))
            return false;
        if (fixos[linha][coluna])
            return false;
        if (tabuleiro[linha][coluna] == 0)
            return false;
        tabuleiro[linha][coluna] = 0;
        return true;
    }

    public boolean temConflito(int num, int linha, int coluna) {
        for (int i = 0; i < 9; i++) {
            if (i != coluna && tabuleiro[linha][i] == num)
                return true;
            if (i != linha && tabuleiro[i][coluna] == num)
                return true;
        }
        int boxLinha = (linha / 3) * 3;
        int boxColuna = (coluna / 3) * 3;
        for (int i = boxLinha; i < boxLinha + 3; i++) {
            for (int j = boxColuna; j < boxColuna + 3; j++) {
                if ((i != linha || j != coluna) && tabuleiro[i][j] == num)
                    return true;
            }
        }
        return false;
    }

    public boolean temErro() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (tabuleiro[i][j] != 0 && temConflito(tabuleiro[i][j], i, j))
                    return true;
        return false;
    }

    public boolean estaCompleto() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (tabuleiro[i][j] == 0)
                    return false;
        return true;
    }

    public void limpar() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (!fixos[i][j])
                    tabuleiro[i][j] = 0;
    }

    public void menu() {
        boolean iniciado = false;
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Iniciar um novo jogo");
            System.out.println("2. Colocar um novo número");
            System.out.println("3. Remover um número");
            System.out.println("4. Verificar jogo");
            System.out.println("5. Verificar status do jogo");
            System.out.println("6. Limpar");
            System.out.println("7. Finalizar o jogo");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    iniciarJogo(carregarFixos());
                    iniciado = true;
                    mostrarTabuleiro();
                    break;
                case "2":
                    if (!iniciado) {
                        System.out.println("Jogo não iniciado.");
                        break;
                    }
                    System.out.print("Número (1-9): ");
                    int num = lerInteiro();
                    System.out.print("Linha (0-8): ");
                    int lin = lerInteiro();
                    System.out.print("Coluna (0-8): ");
                    int col = lerInteiro();
                    if (colocarNumero(num, lin, col))
                        System.out.println("Número colocado com sucesso.");
                    else
                        System.out.println("Não foi possível colocar o número nessa posição.");
                    break;
                case "3":
                    if (!iniciado) {
                        System.out.println("Jogo não iniciado.");
                        break;
                    }
                    System.out.print("Linha (0-8): ");
                    lin = lerInteiro();
                    System.out.print("Coluna (0-8): ");
                    col = lerInteiro();
                    if (removerNumero(lin, col))
                        System.out.println("Número removido.");
                    else
                        System.out.println("Não pode remover esse número.");
                    break;
                case "4":
                    if (!iniciado) {
                        System.out.println("Jogo não iniciado.");
                        break;
                    }
                    mostrarTabuleiro();
                    break;
                case "5":
                    if (!iniciado) {
                        System.out.println("Status: Não iniciado, sem erros.");
                    } else {
                        boolean erros = temErro();
                        boolean completo = estaCompleto();
                        if (completo && !erros)
                            System.out.println("Status: Completo, sem erros.");
                        else if (!completo && !erros)
                            System.out.println("Status: Incompleto, sem erros.");
                        else if (!completo && erros)
                            System.out.println("Status: Incompleto, com erros.");
                        else
                            System.out.println("Status: Completo, com erros.");
                    }
                    break;
                case "6":
                    if (!iniciado) {
                        System.out.println("Jogo não iniciado.");
                        break;
                    }
                    limpar();
                    System.out.println("Tabuleiro limpo.");
                    break;
                case "7":
                    if (!iniciado) {
                        System.out.println("Jogo não iniciado.");
                        break;
                    }
                    if (estaCompleto() && !temErro()) {
                        System.out.println("Parabéns! Você finalizou o jogo com sucesso.");
                        return;
                    } else {
                        System.out.println("O jogo não está completo ou contém erros.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private int lerInteiro() {
        while (true) {
            try {
                String linha = scanner.nextLine();
                int num = Integer.parseInt(linha);
                return num;
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Tente novamente: ");
            }
        }
    }

    private int[][] carregarFixos() {
        int[][] fixosExemplo = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        return fixosExemplo;
    }

    public static void main(String[] args) {
        new Sudoku().menu();
    }
}
