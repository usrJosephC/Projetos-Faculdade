package com.example.biblioteca;
import java.util.List;
import java.util.Scanner;
import com.example.model.Membro;

public class BibliotecaMembro {
    private List<Membro> listaDeMembros;
    private Scanner input;

    public BibliotecaMembro() {
        this.listaDeMembros = Membro.carregarMembros();
        this.input = new Scanner(System.in);
    }

    public void adicionarMembro() {
        System.out.println("Digite o seu nome: ");
        String nome = input.nextLine().toUpperCase();

        System.out.println("Digite o seu ID: ");
        String id = input.nextLine().toUpperCase();

        System.out.println("Digite a sua data de nascimento: ");
        String dataDeNascimento = input.nextLine().toUpperCase();

        System.out.println("Digite o seu endereço: ");
        String endereco = input.nextLine().toUpperCase();

        Membro membro = new Membro(nome, id, dataDeNascimento, endereco);
        listaDeMembros.add(membro);
        Membro.salvarMembros(listaDeMembros);

        System.out.println("Membro adicionado com sucesso.");
    }

    public void removerMembroPorNome() {
        System.out.println("Digite o nome do membro a ser removido: ");
        String nome = input.nextLine().toUpperCase();
        for (int i = 0; i < listaDeMembros.size(); i++) {
            if (listaDeMembros.get(i).getNome().equals(nome)) {
                listaDeMembros.remove(i);
                Membro.salvarMembros(listaDeMembros); 
                System.out.println("Membro removido com sucesso.");
                return;
            }
        }
        System.out.println("Membro não encontrado.");
    }

    public void removerMembroPorID() {
        System.out.println("Digite o ID do membro a ser removido: ");
        String id = input.nextLine().toUpperCase();
        for (int i = 0; i < listaDeMembros.size(); i++) {
            if (listaDeMembros.get(i).getID().equals(id)) {
                listaDeMembros.remove(i);
                Membro.salvarMembros(listaDeMembros); 
                System.out.println("Membro removido com sucesso.");
                return;
            }
        }
        System.out.println("Membro não encontrado.");
    }

    public void buscarPorNome() {
        System.out.println("Digite o nome do membro: ");
        String nome = input.nextLine().toUpperCase();
        exibirCabecalho();
        for (Membro membro : listaDeMembros) {
            if (membro.getNome().equals(nome)) {
                System.out.println(membro.toColumnString());
                return;
            }
        }
        System.out.println("Membro não encontrado.");
    }

    public void buscarPorID() {
        System.out.println("Digite o ID do membro: ");
        String id = input.nextLine().toUpperCase();
        exibirCabecalho();
        for (Membro membro : listaDeMembros) {
            if (membro.getID().equals(id)) {
                System.out.println(membro.toColumnString());
                return;
            }
        }
        System.out.println("Membro não encontrado.");
    }

    public void buscarPorDataDeNascimento() {
        System.out.println("Digite a data de nascimento do membro: ");
        String dataDeNascimento = input.nextLine().toUpperCase();
        exibirCabecalho();
        for (Membro membro : listaDeMembros) {
            if (membro.getDataDeNascimento().equals(dataDeNascimento)) {
                System.out.println(membro.toColumnString());
                return;
            }
        }
        System.out.println("Membro não encontrado.");
    }

    public void buscarPorEndereco() {
        System.out.println("Digite o endereço do membro: ");
        String endereco = input.nextLine().toUpperCase();
        exibirCabecalho();
        for (Membro membro : listaDeMembros) {
            if (membro.getEndereco().equals(endereco)) {
                System.out.println(membro.toColumnString());
                return;
            }
        }
        System.out.println("Membro não encontrado.");
    }

    private void exibirCabecalho() {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println(String.format("%-20s %-15s %-20s %-30s", "Nome", "ID", "Data de Nascimento", "Endereço"));
    }
}