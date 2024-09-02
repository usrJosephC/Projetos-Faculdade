package com.example;

import java.util.List;
import java.util.Scanner;

import com.example.biblioteca.BibliotecaLivro; 
import com.example.biblioteca.BibliotecaMembro;
import com.example.model.Membro;
import com.example.biblioteca.BibliotecaEmprestimo;

public class Main {
    public static void main(String[] args) {
        System.out.println("********************BEM-VINDO(A) À BIBLIOTECA BILBO********************");
        System.out.println("                  Selecione dentre as seguintes opções:                ");
        System.out.println("***********************************************************************");
        exibirMenu();

        Scanner input = new Scanner(System.in);

        BibliotecaLivro bibliotecaLivro = new BibliotecaLivro();
        BibliotecaMembro bibliotecaMembro = new BibliotecaMembro();
        BibliotecaEmprestimo bibliotecaEmprestimo = new BibliotecaEmprestimo();

        // Carregar membros do arquivo ao iniciar o programa
        List<Membro> listaDeMembros = Membro.carregarMembros();

        int escolha;
        int busqueLivro;
        int busqueMembro;
        int remocaoMembro;
        int remocaoLivro;

        do {
            escolha = input.nextInt();

            switch (escolha) {
                case 0:
                    System.out.println("Programa fechado.");
                    break;

                case 1:
                    System.out.println("Pressione 1 para buscar um livro pelo título.");
                    System.out.println("Pressione 2 para buscar um livro pelo autor.");
                    System.out.println("Pressione 3 para buscar um livro pelo ano de publicação.");
                    System.out.println("Pressione 4 para buscar um livro pelo gênero.");
                    System.out.println("Pressione 5 para buscar um livro pelo ISBN.");

                    busqueLivro = input.nextInt();

                    switch (busqueLivro) {
                        case 1:
                            bibliotecaLivro.busquePeloTitulo();
                            exibirMenu();
                            break;

                        case 2:
                            bibliotecaLivro.busquePeloAutor();
                            exibirMenu();
                            break;

                        case 3:
                            bibliotecaLivro.busquePeloAno();
                            exibirMenu();
                            break;

                        case 4:
                            bibliotecaLivro.busquePeloGenero();
                            exibirMenu();
                            break;

                        case 5:
                            bibliotecaLivro.busquePeloISBN();
                            exibirMenu();
                            break;

                        default:
                            System.out.println("Opção inválida para buscar livro.");
                            exibirMenu();
                    }
                    break;

                case 2:
                    bibliotecaLivro.adicionarLivro();
                    exibirMenu();
                    break;

                case 3:
                    System.out.println("Pressione 1 para remover um livro pelo título: ");
                    System.out.println("Pressione 2 para remover um livro pelo ISBN: ");

                    remocaoLivro = input.nextInt();

                    switch (remocaoLivro) {
                        case 1: 
                            bibliotecaLivro.removerLivroPorTitulo();
                            exibirMenu();
                            break;

                        case 2:
                            bibliotecaLivro.removerLivroPorISBN();
                            exibirMenu();
                            break;

                        default:
                            System.out.println("Opção inválida para remoção de livro. ");
                            exibirMenu();
                    }
                    break;

                case 4:
                    System.out.println("Pressione 1 para buscar um membro pelo nome.");
                    System.out.println("Pressione 2 para buscar um membro pelo ID.");
                    System.out.println("Pressione 3 para buscar um membro pela data de nascimento.");
                    System.out.println("Pressione 4 para buscar um membro pelo endereço.");

                    busqueMembro = input.nextInt();

                    switch (busqueMembro) {
                        case 1:
                            bibliotecaMembro.buscarPorNome();
                            exibirMenu();
                            break;

                        case 2:
                            bibliotecaMembro.buscarPorID();
                            exibirMenu();
                            break;

                        case 3:
                            bibliotecaMembro.buscarPorDataDeNascimento();
                            exibirMenu();
                            break;

                        case 4:
                            bibliotecaMembro.buscarPorEndereco();
                            exibirMenu();
                            break;

                        default:
                            System.out.println("Opção inválida para buscar membro.");
                            exibirMenu();
                    }
                    break;

                case 5:
                    bibliotecaMembro.adicionarMembro();
                    exibirMenu();
                    break;

                case 6:
                    System.out.println("Pressione 1 para remover um membro pelo nome: ");
                    System.out.println("Pressione 2 para remover um membro pelo ID: ");

                    remocaoMembro = input.nextInt();

                    switch (remocaoMembro) {
                        case 1:
                            bibliotecaMembro.removerMembroPorNome();
                            exibirMenu(); 
                            break;

                        case 2:
                            bibliotecaMembro.removerMembroPorID();
                            exibirMenu(); 
                            break;

                        default:
                            System.out.println("Opção inválida para remoção de membro. ");   
                            exibirMenu(); 
                    }
                    // Salvar membros após remover um membro
                    Membro.salvarMembros(listaDeMembros);
                    break;

                case 7:
                    bibliotecaEmprestimo.registrarEmprestimo();
                    exibirMenu();
                    break;

                case 8:
                    bibliotecaEmprestimo.devolverEmprestimo();
                    exibirMenu();
                    break;

                case 9:
                    bibliotecaEmprestimo.consultarEmprestimo();
                    exibirMenu();
                    break;

                default:
                    System.out.println("DIGITE UM NÚMERO ENTRE 0 E 9.");
            }

        } while (escolha != 0);

        input.close();
    }

    private static void exibirMenu() {
        System.out.println("\n");
        System.out.println("Pressione 0 para fechar o programa.");
        System.out.println("Pressione 1 para buscar um livro.");
        System.out.println("Pressione 2 para adicionar um livro.");
        System.out.println("Pressione 3 para remover um livro.");
        System.out.println("Pressione 4 buscar um membro.");
        System.out.println("Pressione 5 para adicionar um membro.");
        System.out.println("Pressione 6 para remover um membro.");
        System.out.println("Pressione 7 registrar um empréstimo de livro.");
        System.out.println("Pressione 8 para devolver um livro.");
        System.out.println("Pressione 9 para consultar os livros emprestados.");
    }
}