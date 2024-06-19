package questao1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PrincipalLivros {

    public static void main(String[] args) {
        ArrayList<Livro> lista = new ArrayList<Livro>();
        int op = 0;
        do {
            op = menu();
            if (op == 1) lista.add(lerLivro());
            if (op == 2) localizarLivroPorISBN(lista);
            if (op == 3) verificarLivrosPorPessoa(lista);
            if (op == 4) livrosPublicadosEm2020(lista);
            if (op == 5) listarLivrosPorGenero(lista);
        } while (op != 6);
    }

    private static int menu() {
        String m = "1 - Cadastrar Livro\n"
                + "2 - Localizar Livro por ISBN\n"
                + "3 - Verificar Livros por Pessoa\n"
                + "4 - Livros Publicados em 2020\n"
                + "5 - Listar Livros por Gênero\n"
                + "6 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }

    private static void msg(String txt) {
        JOptionPane.showMessageDialog(null, txt);
    }

    private static String escreveLivro(Livro l) {
        String emprestados = String.join(", ", l.pessoasQuePegaramEmprestado);
        return "Título: " + l.titulo + "\n"
                + "Autor: " + l.autor + "\n"
                + "Ano de Publicação: " + l.anoPublicacao + "\n"
                + "Gênero: " + l.genero + "\n"
                + "ISBN: " + l.isbn + "\n"
                + "Pessoas que pegaram emprestado: " + emprestados;
    }

    private static Livro lerLivro() {
        Livro l = new Livro();
        l.titulo = lerString("Título");
        l.autor = lerString("Autor");
        l.anoPublicacao = lerInt("Ano de Publicação");
        l.genero = lerString("Gênero");
        l.isbn = lerString("ISBN");
        l.pessoasQuePegaramEmprestado = lerPessoas("Pessoas que pegaram emprestado (separadas por vírgula)");
        return l;
    }

    private static String lerString(String txt) {
        String str = JOptionPane.showInputDialog(txt);
        if (str.trim().equals("")) {
            return lerString(txt);
        }
        return str.toUpperCase();
    }

    private static int lerInt(String txt) {
        int i = Integer.parseInt(JOptionPane.showInputDialog(txt));
        if (i < 0) {
            return lerInt(txt);
        }
        return i;
    }

    private static String[] lerPessoas(String txt) {
        String str = JOptionPane.showInputDialog(txt);
        if (str.trim().equals("")) {
            return lerPessoas(txt);
        }
        return str.split(",");
    }

    private static void localizarLivroPorISBN(ArrayList<Livro> lista) {
        String isbn = lerString("Digite o ISBN do livro");
        for (Livro l : lista) {
            if (l.isbn.equals(isbn)) {
                msg(escreveLivro(l));
                return;
            }
        }
        msg("Livro não encontrado");
    }

    private static void verificarLivrosPorPessoa(ArrayList<Livro> lista) {
        String nome = lerString("Digite o nome da pessoa");
        String ret = "";
        for (Livro l : lista) {
            for (String pessoa : l.pessoasQuePegaramEmprestado) {
                if (pessoa.trim().equalsIgnoreCase(nome)) {
                    ret += escreveLivro(l) + "\n\n";
                    break;
                }
            }
        }
        msg(ret.isEmpty() ? "Nenhum livro encontrado para a pessoa informada" : ret);
    }

    private static void livrosPublicadosEm2020(ArrayList<Livro> lista) {
        String ret = "";
        for (Livro l : lista) {
            if (l.anoPublicacao == 2020) {
                ret += escreveLivro(l) + "\n\n";
            }
        }
        msg(ret.isEmpty() ? "Nenhum livro publicado em 2020" : ret);
    }

    private static void listarLivrosPorGenero(ArrayList<Livro> lista) {
        String genero = lerString("Digite o gênero");
        String ret = "";
        for (Livro l : lista) {
            if (l.genero.equalsIgnoreCase(genero)) {
                ret += escreveLivro(l) + "\n\n";
            }
        }
        msg(ret.isEmpty() ? "Nenhum livro encontrado para o gênero informado" : ret);
    }
}