package PROJETOS.ContaBanco;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("CADASTRO DA CONTA");
        System.out.print("Numero da conta (ex: 0000): ");
        var num = scanner.nextInt();
        System.out.print("Agencia da conta (ex: 000-0): ");
        var agencia = scanner.next();
        System.out.print("Seu nome: ");
        var nome = scanner.next();
        System.out.print("Seu saldo: ");
        var saldo = scanner.nextInt();
        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %S e seu saldo %s já está disponível para saque!", nome, agencia, num, saldo);
    }
}
