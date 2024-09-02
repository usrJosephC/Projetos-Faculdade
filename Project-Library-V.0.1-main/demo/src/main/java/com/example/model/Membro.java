package com.example.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Membro {

    private String nome;
    private String ID;
    private String dataDeNascimento;
    private String endereco;

    public Membro() {
    }

    public Membro(String nome, String ID, String dataDeNascimento, String endereco) {
        this.nome = nome;
        this.ID = ID;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereco;
    }

    public Membro(String nome, String ID) {
        this.nome = nome;
        this.ID = ID;
        this.dataDeNascimento = null; 
        this.endereco = null; 
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public static void salvarMembros(List<Membro> membros) {
        String filePath = "demo/src/main/java/com/example/services/membros.txt"; 

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Membro membro : membros) {
                writer.println(membro.toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar membros de um arquivo
    public static List<Membro> carregarMembros() {
        List<Membro> membros = new ArrayList<>();
        String filePath = "demo/src/main/java/com/example/services/membros.txt"; 

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) { 
                    Membro membro = Membro.fromString(line);
                    if (membro != null) { 
                        membros.add(membro);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return membros;
    }

    // Método para converter membro em string formatada para arquivo
    public String toFileString() {
        return nome + ";" + ID + ";" + dataDeNascimento + ";" + endereco;
    }

    // Método para criar um membro a partir de uma string formatada de arquivo
    public static Membro fromString(String linha) {
        String[] partes = linha.split(";");
        if (partes.length == 4) { 
            return new Membro(partes[0], partes[1], partes[2], partes[3]);
        } else {
            System.err.println("Linha inválida no arquivo: " + linha);
            return null;
        }
    }

    // Método para converter membro em uma string formatada para exibição em colunas
    public String toColumnString() {
        return String.format("%-20s %-15s %-20s %-30s", nome, ID, dataDeNascimento, endereco);
    }


    @Override
    public String toString() {
        return "Membro{" +
                "nome='" + nome + '\'' +
                ", ID='" + ID + '\'' +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}