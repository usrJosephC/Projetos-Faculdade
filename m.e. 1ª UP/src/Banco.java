import java.util.*;

class ContaBancaria {
    private String numeroConta;
    private String nomeTitular;
    private double saldo;

    public ContaBancaria(String numeroConta, String nomeTitular, double depositoInicial) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = depositoInicial;
    }

    public void alterarNomeTitular(String novoNome) {
        this.nomeTitular = novoNome;
        System.out.printf("Nome do titular alterado para: %s%n", novoNome);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("Valor de depósito deve ser positivo.");
        }
    }

    public void solicitarSaque(double valor) {
        double taxaSaque = 5.00;
        double totalNecessario = valor + taxaSaque;

        while (totalNecessario > saldo) {
            System.out.printf("Saldo insuficiente para realizar o saque de R$ %.2f e pagar a taxa de R$ %.2f.%n", valor, taxaSaque);
            System.out.print("Informe um valor adicional para o saque: R$");
            Scanner sc = new Scanner(System.in);
            double valorAdicional = sc.nextDouble();
            depositar(valorAdicional);
            System.out.printf("Valor adicional de R$ %.2f depositado.%n", valorAdicional);
        }

        saldo -= totalNecessario;
        System.out.printf("Saque de R$ %.2f realizado com sucesso. Taxa de R$ %.2f aplicada.%n", valor, taxaSaque);
    }

    public void mostrarDados() {
        System.out.printf("Número da Conta: %s%n", numeroConta);
        System.out.printf("Nome do Titular: %s%n", nomeTitular);
        System.out.printf("Saldo Atual: R$ %.2f%n", saldo);
    }
}

public class Banco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.print("Informe o número da conta: ");
        String numeroConta = sc.nextLine();

        System.out.print("Informe o nome do titular: ");
        String nomeTitular = sc.nextLine();

        System.out.print("Informe o depósito inicial (digite 0 se não houver): R$");
        double depositoInicial = sc.nextDouble();

        ContaBancaria conta = new ContaBancaria(numeroConta, nomeTitular, depositoInicial);
        
       conta.mostrarDados();

        System.out.print("Deseja alterar o nome do titular? (s/n): ");
        char opcaoAlterarNome = sc.next().charAt(0);
        
        if (opcaoAlterarNome == 's' || opcaoAlterarNome == 'S') {
            System.out.print("Informe o novo nome do titular: ");
            sc.nextLine();
            String novoNome = sc.nextLine();
            conta.alterarNomeTitular(novoNome);
            conta.mostrarDados();
        }

        System.out.print("Informe o valor a ser depositado: R$");
        double valorDeposito = sc.nextDouble();
        conta.depositar(valorDeposito);
        
        conta.mostrarDados();

        System.out.print("Informe o valor a ser sacado: R$");
        double valorSaque = sc.nextDouble();
        
        conta.solicitarSaque(valorSaque);
        
        conta.mostrarDados();

        sc.close();
    }
}