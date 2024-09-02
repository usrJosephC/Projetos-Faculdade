package com.example.biblioteca;

import com.example.model.Emprestimo;
import com.example.model.Livro;
import com.example.model.Membro;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BibliotecaEmprestimo {
    private List<Emprestimo> emprestimos;
    private List<Membro> membros;
    private List<Livro> livros;
    private Scanner input;
    private SimpleDateFormat sdf; 

    public BibliotecaEmprestimo() {
        this.emprestimos = carregarEmprestimos(); 
        this.membros = carregarMembros();
        this.livros = carregarLivros();
        this.input = new Scanner(System.in);
        this.sdf = new SimpleDateFormat("dd/MM/yyyy"); 
    }

    // Método para carregar membros de um arquivo
    private List<Membro> carregarMembros() {
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

    // Método para carregar livros de um arquivo
    private List<Livro> carregarLivros() {
        List<Livro> livros = new ArrayList<>();
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

    private List<Emprestimo> carregarEmprestimos() {
    List<Emprestimo> emprestimos = new ArrayList<>();
    String filePath = "demo/src/main/java/com/example/services/emprestimos.txt"; 

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.trim().isEmpty()) { 
                Emprestimo emprestimo = Emprestimo.fromString(line);
                if (emprestimo != null) { 
                    emprestimos.add(emprestimo);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return emprestimos;
}

    // Método para buscar um membro pelo ID
    private Membro buscarMembroPorID(String membroID) {
        for (Membro membro : membros) {
            if (membro.getID().equals(membroID)) {
                return membro;
            }
        }
        return null; 
    }

    // Método para buscar um livro pelo ISBN
    private Livro buscarLivroPorISBN(String livroISBN) {
        for (Livro livro : livros) {
            if (livro.getISBN().equals(livroISBN)) {
                return livro;
            }
        }
        return null; 
    }

    // Regra 1: Verifica a quantidade de empréstimos do membro
    private int contarEmprestimosDoMembro(String membroID) {
        int count = 0;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getMembro().getID().equals(membroID) && emprestimo.getDataDeDevolucaoPrevista() == null) {
                count++;
            }
        }
        return count;
    }

    // Regra 2: Verifica se o livro já está emprestado
    
    // Método para registrar um empréstimo
    public void registrarEmprestimo() {
        System.out.println("Digite o ID do membro: ");
        String membroID = input.nextLine();
    
        System.out.println("Digite o ISBN do livro: ");
        String livroISBN = input.nextLine();
    
        // Verificar se o membro existe
        Membro membro = buscarMembroPorID(membroID);
        if (membro == null) {
            System.out.println("Membro não encontrado.");
            return;
        }
    
        // Verificar se o livro existe
        Livro livro = buscarLivroPorISBN(livroISBN);
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }
    
        // Regra 1: Não permitir empréstimos se o membro já tiver 3 livros emprestados
        if (contarEmprestimosDoMembro(membroID) >= 3) {
            System.out.println("O membro já possui 3 livros emprestados. Não é possível registrar novo empréstimo.");
            return;
        }
    
        // Verificar se o livro está disponível diretamente
        if (!livro.isDisponivel()) {
            System.out.println("O livro já está emprestado. Não é possível registrar novo empréstimo.");
            return;
        }
    
        Date dataDeEmprestimo = new Date(); 
    
        // Calcula a data de devolução prevista como uma semana após a data de empréstimo
        Date dataDeDevolucaoPrevista = new Date(dataDeEmprestimo.getTime() + 7 * 24 * 60 * 60 * 1000); // Adiciona 7 dias em milissegundos
    
        Emprestimo emprestimo = new Emprestimo(membro, livro, dataDeEmprestimo, dataDeDevolucaoPrevista);
        emprestimos.add(emprestimo);
        livro.setDisponivel(false);
    
        // Salvar a lista de livros atualizada
        Livro.salvarLivros(livros);
    
        System.out.println("Empréstimo registrado com sucesso! A data de empréstimo é: " + dataDeEmprestimo + " e a data de devolução é: " + dataDeDevolucaoPrevista);
    
        // Salvar empréstimos no arquivo emprestimo.txt
        salvarEmprestimos();
    }

    // Método para salvar os empréstimos no arquivo emprestimo.txt
    private void salvarEmprestimos() {
        String filePath = "demo/src/main/java/com/example/services/emprestimos.txt";
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Emprestimo emprestimo : emprestimos) {
                writer.println(emprestimo.toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void consultarEmprestimo() {
        System.out.println("Digite o título do livro para consulta: ");
        String tituloLivro = input.nextLine().toUpperCase();
        boolean encontrouEmprestimo = false;

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().getTitulo().equalsIgnoreCase(tituloLivro)) {
                encontrouEmprestimo = true;
                System.out.println("Empréstimo encontrado: ");
                System.out.println("Nome do Membro: " + emprestimo.getMembro().getNome());
                System.out.println("Título do Livro: " + emprestimo.getLivro().getTitulo());
                System.out.println("Data de Empréstimo: " + sdf.format(emprestimo.getDataDeEmprestimo()));
                System.out.println("Data de Devolução Prevista: " + sdf.format(emprestimo.getDataDeDevolucaoPrevista()));
            }
        }

        if (!encontrouEmprestimo) {
            System.out.println("Empréstimo não encontrado para o título: " + tituloLivro);
        }
    }
    public void devolverEmprestimo() {
        System.out.println("Digite o título do livro que deseja devolver: ");
        String tituloLivro = input.nextLine().toUpperCase();
        System.out.println("Digite o seu ID: ");
        String idMembro = input.nextLine().toUpperCase();
    
        boolean emprestimoEncontrado = false;
    
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().getTitulo().equalsIgnoreCase(tituloLivro) && emprestimo.getMembro().getID().equalsIgnoreCase(idMembro)) {
                Date dataAtual = new Date(); 
    
                
                emprestimo.setDataDeDevolucaoPrevista(dataAtual);
    
                emprestimo.getLivro().setDisponivel(true);
                atualizarLivroNoArquivo(emprestimo.getLivro());
    
                emprestimo.getMembro().setNome("");
    
                emprestimo.setDataDeDevolucaoReal(dataAtual);

                emprestimos.remove(emprestimo);
    
                System.out.println("Livro devolvido com sucesso.");
                System.out.println("Data de Devolução Real: " + sdf.format(dataAtual));
    
                emprestimoEncontrado = true;
                break; 
            }
        }
    
        if (!emprestimoEncontrado) {
            System.out.println("Empréstimo não encontrado para o livro: " + tituloLivro);
        }
    
        salvarEmprestimos();
    }
    

    private void atualizarLivroNoArquivo(Livro livro) {
        for (Livro l : livros) {
            if (l.getISBN().equals(livro.getISBN())) {
                l.setDisponivel(true); 
                Livro.salvarLivros(livros); 
                break;
            }
        }
    }
}    