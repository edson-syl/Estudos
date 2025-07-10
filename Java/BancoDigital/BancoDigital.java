package PROJETOS.BancoDigital;
import java.util.*;

public class BancoDigital {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        Conta cliente1 = new Conta(500);
        cliente1.realizarPix(37, 992281271);
        cliente1.realizarSaque(45);
        cliente1.realizarDeposito(200);
        cliente1.realizarSaque(4000);
    }
}
