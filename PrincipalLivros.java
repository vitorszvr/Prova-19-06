package biblioteca;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PrincipalLivros {
    private static ArrayList<Livro> livros = new ArrayList<>();

    public static void main(String[] args) {
        int op = 0;
        do {
            op = menu();
            switch (op) {
                case 1:
                    livros.add(cadastrarLivro());
                    break;
                case 2:
                    localizarLivroPorISBN();
                    break;
                case 3:
                    verificarLivrosPorPessoa();
                    break;
                case 4:
                    listarLivrosPublicadosEm2020();
                    break;
                case 5:
                    listarLivrosPorGenero();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (op != 6);
    }

    private static int menu() {
        String m = "1 - Cadastrar Livro\n"
                + "2 - Localizar livro pelo ISBN\n"
                + "3 - Verificar livros por pessoa\n"
                + "4 - Listar livros publicados em 2020\n"
                + "5 - Listar livros por gênero\n"
                + "6 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }

    private static Livro cadastrarLivro() {
        Livro livro = new Livro();
        livro.titulo = JOptionPane.showInputDialog("Digite o título do livro:");
        livro.autor = JOptionPane.showInputDialog("Digite o autor do livro:");
        livro.anoPublicacao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de publicação:"));
        livro.genero = JOptionPane.showInputDialog("Digite o gênero do livro:");
        livro.isbn = JOptionPane.showInputDialog("Digite o ISBN do livro:");
        return livro;
    }

    private static void localizarLivroPorISBN() {
        String isbn = JOptionPane.showInputDialog("Digite o ISBN do livro:");
        for (Livro livro : livros) {
            if (livro.isbn.equals(isbn)) {
                JOptionPane.showMessageDialog(null, livro + "\nPessoas que já pegaram o livro emprestado:\n" +
                        String.join("\n", livro.pessoasEmprestimo));
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Livro não encontrado.");
    }

    private static void verificarLivrosPorPessoa() {
        String nome = JOptionPane.showInputDialog("Digite o nome da pessoa:");
        StringBuilder sb = new StringBuilder("Livros que " + nome + " já pegou emprestado:\n");
        boolean encontrou = false;
        for (Livro livro : livros) {
            if (livro.pessoasEmprestimo.contains(nome)) {
                sb.append("- ").append(livro.titulo).append("\n");
                encontrou = true;
            }
        }
        if (!encontrou) {
            sb.append("Nenhum livro encontrado.");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarLivrosPublicadosEm2020() {
        StringBuilder sb = new StringBuilder("Livros publicados em 2020:\n");
        boolean encontrou = false;
        for (Livro livro : livros) {
            if (livro.anoPublicacao == 2020) {
                sb.append("- ").append(livro).append("\n");
                encontrou = true;
            }
        }
        if (!encontrou) {
            sb.append("Nenhum livro publicado em 2020.");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarLivrosPorGenero() {
        String genero = JOptionPane.showInputDialog("Digite o gênero:");
        StringBuilder sb = new StringBuilder("Livros do gênero " + genero + ":\n");
        boolean encontrou = false;
        for (Livro livro : livros) {
            if (livro.genero.equalsIgnoreCase(genero)) {
                sb.append("- ").append(livro).append("\n");
                encontrou = true;
            }
        }
        if (!encontrou) {
            sb.append("Nenhum livro encontrado.");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}