package com.example.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Emprestimo {
    private Membro membro;
    private Livro livro;
    private Date dataDeEmprestimo;
    private Date dataDeDevolucaoPrevista;
    private Date dataDeDevolucaoReal;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Emprestimo() {
    }

    public Emprestimo(Membro membro, Livro livro, Date dataDeEmprestimo, Date dataDeDevolucaoPrevista) {
        this.membro = membro;
        this.livro = livro;
        this.dataDeEmprestimo = dataDeEmprestimo;
        this.dataDeDevolucaoPrevista = dataDeDevolucaoPrevista;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Date getDataDeEmprestimo() {
        return dataDeEmprestimo;
    }

    public void setDataDeEmprestimo(Date dataDeEmprestimo) {
        this.dataDeEmprestimo = dataDeEmprestimo;
    }

    public Date getDataDeDevolucaoPrevista() {
        return dataDeDevolucaoPrevista;
    }

    public void setDataDeDevolucaoPrevista(Date dataDeDevolucaoPrevista) {
        this.dataDeDevolucaoPrevista = dataDeDevolucaoPrevista;
    }

    public Date getDataDeDevolucaoReal() {
        return dataDeDevolucaoReal;
    }

    public void setDataDeDevolucaoReal(Date dataDeDevolucaoReal) {
        this.dataDeDevolucaoReal = dataDeDevolucaoReal;
        if (dataDeDevolucaoReal != null) {
            membro.setNome("");
             
        }
    }

    // Método para converter uma string em um objeto Emprestimo
    public static Emprestimo fromString(String linha) {
        String[] campos = linha.split(";");
    
        if (campos.length != 7) {
            return null; 
        }
    
        try {
            Membro membro = new Membro(campos[0], campos[1]); 
            Livro livro = new Livro(campos[2], campos[3]);   
            Date dataDeEmprestimo = sdf.parse(campos[4]);     
            Date dataDeDevolucaoPrevista = sdf.parse(campos[5]); 
            Date dataDeDevolucaoReal = null;
            if (!campos[6].isEmpty()) {
                dataDeDevolucaoReal = sdf.parse(campos[6]); 
            }
    
            Emprestimo emprestimo = new Emprestimo(membro, livro, dataDeEmprestimo, dataDeDevolucaoPrevista);
            emprestimo.setDataDeDevolucaoReal(dataDeDevolucaoReal); 
            return emprestimo;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para converter o empréstimo em uma string formatada para arquivo
    public String toFileString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataDeEmprestimoStr = dataDeEmprestimo != null ? sdf.format(dataDeEmprestimo) : "";
        String dataDeDevolucaoPrevistaStr = dataDeDevolucaoPrevista != null ? sdf.format(dataDeDevolucaoPrevista) : "";
        String dataDeDevolucaoRealStr = dataDeDevolucaoReal != null ? sdf.format(dataDeDevolucaoReal) : "";
        
        
        String nomeMembro = membro.getNome();
    
        return String.format("%s;%s;%s;%s;%s;%s;%s", 
                membro.getID(), 
                nomeMembro, 
                livro.getISBN(), 
                livro.getTitulo(), 
                dataDeEmprestimoStr, 
                dataDeDevolucaoPrevistaStr, 
                dataDeDevolucaoRealStr);
    }


    
    @Override
    public String toString() {
        return "Emprestimo{" +
                "membro=" + membro +
                ", livro=" + livro +
                ", dataDeEmprestimo=" + dataDeEmprestimo +
                ", dataDeDevolucaoPrevista=" + dataDeDevolucaoPrevista +
                '}';
    }
}