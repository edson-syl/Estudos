package PROJETOS.BancoDigital;

public class Conta {
    private float saldo;

    public Conta(float saldo) {
        this.saldo = saldo;
    }

    public void realizarDeposito(float valor) {
        saldo += valor;
        System.out.println("Voce depositou R$" + valor + "\nSaldo atual: " + saldo);
    }
    public void realizarSaque(float valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Voce sacou R$" + valor + "\nSaldo atual: " + saldo);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
    public void realizarPix(float valor, int chavepix) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Transferencia concluida com sucesso!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}
