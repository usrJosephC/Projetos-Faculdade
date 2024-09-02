package com.example.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import com.example.model.Livro;

public class BibliotecaLivro {
    private ArrayList<Livro> listaDeLivros;
    private Scanner input;

    public BibliotecaLivro() {
        this.listaDeLivros = Livro.carregarLivros(); 
        this.input = new Scanner(System.in);
    }

    public void adicionarLivro() {
        System.out.println("Digite o título do livro: ");
        String titulo = input.nextLine().toUpperCase();

        System.out.println("Digite o autor do livro: ");
        String autor = input.nextLine().toUpperCase();

        System.out.println("Digite o ano de publicação do livro: ");
        int ano = input.nextInt();
        input.nextLine();  

        System.out.println("Digite o gênero do livro: ");
        String genero = input.nextLine().toUpperCase();

        System.out.println("Digite o ISBN do livro: ");
        String ISBN = input.nextLine().toUpperCase();

        Livro livro = new Livro(titulo, autor, ano, genero, ISBN);
        listaDeLivros.add(livro);
        salvarLivros(); 
        System.out.println("Livro adicionado com sucesso.");
    }

    public void removerLivroPorTitulo() {
        System.out.println("Digite o título do livro para remover: ");
        String titulo = input.nextLine().toUpperCase();

        for (int i = 0; i < listaDeLivros.size(); i++) {
            if (listaDeLivros.get(i).getTitulo().equals(titulo)) {
                listaDeLivros.remove(i);
                listaDeLivros.get(i).devolverLivro(); 
                salvarLivros(); 
                System.out.println("Livro removido com sucesso.");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void removerLivroPorISBN() {
        System.out.println("Digite o ISBN do livro: ");
        String ISBN = input.nextLine().toUpperCase();
        for (int i = 0; i < listaDeLivros.size(); i++) {
            if (listaDeLivros.get(i).getISBN().equals(ISBN)) {
                listaDeLivros.remove(i);
                listaDeLivros.get(i).devolverLivro(); 
                salvarLivros(); 
                System.out.println("Livro removido com sucesso.");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void busquePeloTitulo() {
        listaDeLivros = Livro.carregarLivros();
        System.out.println("Digite o título do livro: ");
        String titulo = input.nextLine().toUpperCase();
        exibirCabecalho();
        boolean encontrado = false;
        for (Livro livro : listaDeLivros) {
            if (livro.getTitulo().equals(titulo)) {
                System.out.println(livro.toColumnString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado.");
        }
    }

    public void busquePeloAutor() {
        listaDeLivros = Livro.carregarLivros();
        System.out.println("Digite o autor do livro: ");
        String autor = input.nextLine().toUpperCase();
        exibirCabecalho();
        boolean encontrado = false;
        for (Livro livro : listaDeLivros) {
            if (livro.getAutor().equals(autor)) {
                System.out.println(livro.toColumnString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado.");
        }
    }

    public void busquePeloAno() {
        listaDeLivros = Livro.carregarLivros();
        System.out.println("Digite o ano de publicação do livro: ");
        int ano = input.nextInt();
        input.nextLine();  
        exibirCabecalho();
        boolean encontrado = false;
        for (Livro livro : listaDeLivros) {
            if (livro.getAno() == ano) {
                System.out.println(livro.toColumnString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado.");
        }
    }

    public void busquePeloGenero() {
        listaDeLivros = Livro.carregarLivros();
        System.out.println("Digite o gênero do livro: ");
        String genero = input.nextLine().toUpperCase();
        exibirCabecalho();
        boolean encontrado = false;
        for (Livro livro : listaDeLivros) {
            if (livro.getGenero().equals(genero)) {
                System.out.println(livro.toColumnString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado.");
        }
    }

    public void busquePeloISBN() {
        listaDeLivros = Livro.carregarLivros();
        
        System.out.println("Digite o ISBN do livro: ");
        String ISBN = input.nextLine().toUpperCase();
        exibirCabecalho();
        
        boolean encontrado = false;
        for (Livro livro : listaDeLivros) {
            if (livro.getISBN().equals(ISBN)) {
                System.out.println(livro.toColumnString());
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("Livro não encontrado.");
        }
    }

    public void emprestarLivro() {
        System.out.println("Digite o ISBN do livro que deseja emprestar: ");
        String ISBN = input.nextLine().toUpperCase();
        for (Livro livro : listaDeLivros) {
            if (livro.getISBN().equals(ISBN)) {
                livro.emprestarLivro();
                salvarLivros(); 
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void devolverLivro() {
        System.out.println("Digite o ISBN do livro que deseja devolver: ");
        String ISBN = input.nextLine().toUpperCase();
        for (Livro livro : listaDeLivros) {
            if (livro.getISBN().equals(ISBN)) {
                livro.devolverLivro();
                salvarLivros(); 
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    private void salvarLivros() {
        Livro.salvarLivros(listaDeLivros); 
    }

    // Método para exibir cabeçalho na listagem
    private void exibirCabecalho() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println(String.format("%-20s %-20s %-10s %-30s %-20s %-20s", "Título", "Autor", "Ano", "Gênero", "ISBN", "Disponível"));
    }
}