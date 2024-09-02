package com.example.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Livro {

    private String titulo;
    private String autor;
    private int ano;
    private String genero;
    private String ISBN;
    private boolean disponivel;

    public Livro() {
        this.disponivel = true; 
    }

    public Livro(String titulo, String autor, int ano, String genero, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.genero = genero;
        this.ISBN = ISBN;
        this.disponivel = true; 
    }

    public Livro(String titulo, String autor, int ano, String genero, String ISBN, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.genero = genero;
        this.ISBN = ISBN;
        this.disponivel = disponivel;
    }


    public Livro(String titulo, String ISBN) {
        this.titulo = titulo;
        this.autor = null;
        this.ano = 0;
        this.genero = null;
        this.ISBN = ISBN;
        this.disponivel = true; 
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void emprestarLivro() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Livro emprestado com sucesso.");
        } else {
            System.out.println("Este livro já está emprestado.");
        }
    }

    public void devolverLivro() {
        if (!disponivel) {
            disponivel = true;
            System.out.println("Livro devolvido com sucesso.");
        } else {
            System.out.println("Este livro já está disponível.");
        }
    }

    public static void salvarLivros(List<Livro> livros) {
        String filePath = "demo/src/main/java/com/example/services/livros.txt"; 

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Livro livro : livros) {
                writer.println(livro.toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar livros de um arquivo
    public static ArrayList<Livro> carregarLivros() {
        ArrayList<Livro> livros = new ArrayList<>();
        String filePath = "demo/src/main/java/com/example/services/livros.txt"; 

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) { 
                    Livro livro = Livro.fromString(line);
                    if (livro != null) { 
                        livros.add(livro);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return livros;
    }

    // Método para converter livro em uma string formatada para arquivo
    public String toColumnString() {
        return String.format("%-20s %-20s %-10d %-30s %-20s %-20s", titulo, autor, ano, genero, ISBN, (disponivel ? "Sim" : "Não"));
    }

    // Método para converter uma string formatada em livro
    public String toFileString() {
        return String.format("%s;%s;%d;%s;%s;%s", titulo, autor, ano, genero, ISBN, disponivel);
    }
    
    public static Livro fromString(String linha) {
        String[] partes = linha.split(";");
        if (partes.length == 6) {
            return new Livro(partes[0], partes[1], Integer.parseInt(partes[2]), partes[3], partes[4], Boolean.parseBoolean(partes[5]));
        } else if (partes.length == 5) {
            return new Livro(partes[0], partes[1], Integer.parseInt(partes[2]), partes[3], partes[4]);
        } else {
            return null; 
        }
    }

    // Para debug
    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ano=" + ano +
                ", genero='" + genero + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }
}