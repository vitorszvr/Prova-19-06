package questao1;

import java.util.ArrayList;

public class Livro {
    String titulo;
    String autor;
    int anoPublicacao;
    String genero;
    String isbn;
    ArrayList<String> pessoasEmprestimo;

    public Livro() {
        pessoasEmprestimo = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + "\n" +
                "Autor: " + autor + "\n" +
                "Ano de Publicação: " + anoPublicacao + "\n" +
                "Gênero: " + genero + "\n" +
                "ISBN: " + isbn;
    }
}