import java.util.Scanner;

abstract class ContaBancaria {
    protected double saldo;

    public void depositar(double valor) {
        saldo += valor;
    }

    public abstract void sacar(double valor);

    public void exibirSaldo() {
        System.out.println("Saldo: " + saldo);
    }
}

class ContaCorrente extends ContaBancaria {
    private static final double TAXA_SAQUE = 10.00;

    @Override
    public void sacar(double valor) {
        if (valor + TAXA_SAQUE <= saldo) {
            saldo -= (valor + TAXA_SAQUE);
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    @Override
    public void exibirSaldo() {
        System.out.println("Saldo da Conta Corrente: " + saldo);
    }
}

class ContaPoupanca extends ContaBancaria {

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    @Override
    public void exibirSaldo() {
        System.out.println("Saldo da Conta Poupança: " + saldo);
    }
}

public class Questao5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha o tipo de conta (1 para Conta Corrente, 2 para Conta Poupança):");
        int tipoConta = sc.nextInt();
        ContaBancaria conta = null;

        if (tipoConta == 1) {
            conta = new ContaCorrente();
            System.out.println("Você escolheu Conta Corrente.");
        } else if (tipoConta == 2) {
            conta = new ContaPoupanca();
            System.out.println("Você escolheu Conta Poupança.");
        } else {
            System.out.println("Tipo de conta inválido.");
            return;
        }

        System.out.println("Digite o valor de depósito:");
        double deposito = sc.nextDouble();
        conta.depositar(deposito);
        conta.exibirSaldo();

        System.out.println("Digite o valor para saque:");
        double saque = sc.nextDouble();
        conta.sacar(saque);
        conta.exibirSaldo();

        sc.close();
    }
}