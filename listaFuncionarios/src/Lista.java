import java.util.*;

class Funcionario {
    private Integer id;
    private String nome;
    private double salario;

    public Funcionario(Integer id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void aumentarSalario(double porcentagem) {
        if (porcentagem > 0) {
            this.salario += this.salario * (porcentagem / 100);
        }
    }

    @Override
    public String toString() {
        return "ID:" + id + ", Nome: " + nome + ", Salário: " + salario;
    }
}

public class Lista {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n, id, idAumento;
        String nome;
        double salario, percentualAumento;

        Map<Integer, Funcionario> funcionarios = new HashMap<>();

        System.out.print("Quantos funcionários vão ser registrados? ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o id do funcionário: ");
            id = sc.nextInt();
            sc.nextLine();

            if (funcionarios.containsKey(id)) {
                System.out.println("ID já existe. Tente novamente");
                i--;
                continue;
            }

            System.out.print("Digite o nome do funcionário: ");
            nome = sc.nextLine();

            System.out.print("Digite o salário do funcionário: ");
            salario = sc.nextDouble();

            funcionarios.put(id, new Funcionario(id, nome, salario));
        }

        System.out.print("Digite o ID do funcionário que irá receber o aumento: ");
        idAumento = sc.nextInt();

        if (!funcionarios.containsKey(idAumento)) {
            System.out.println("ID não encontrado. Operação cancelada!");
        } else {
            System.out.print("Digite o percentual de aumento: ");
            percentualAumento = sc.nextDouble();

            Funcionario funcionario = funcionarios.get(idAumento);

            funcionario.aumentarSalario(percentualAumento);

            System.out.println("Sálario atualizado com sucesso!");
        }

        System.out.println("\nLista de Funcionários Atualizada:");
        for (Funcionario f : funcionarios.values()) {
            System.out.println(f);
        }

        sc.close();
    }
}
