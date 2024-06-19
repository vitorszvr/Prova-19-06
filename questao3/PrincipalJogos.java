package questao3;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PrincipalJogos {
    private static ArrayList<Jogo> jogos = new ArrayList<>();

    public static void main(String[] args) {
        int op = 0;
        do {
            op = menu();
            switch (op) {
                case 1:
                    jogos.add(cadastrarJogo());
                    break;
                case 2:
                    listarTodosJogos();
                    break;
                case 3:
                    buscarPorPlataforma();
                    break;
                case 4:
                    buscarPorNota();
                    break;
                case 5:
                    jogoComMaiorNota();
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
        String m = "1 - Cadastrar Jogo\n"
                + "2 - Listar Todos os Jogos\n"
                + "3 - Buscar por Plataforma\n"
                + "4 - Buscar por Nota\n"
                + "5 - Jogo com Maior Nota para uma Plataforma e Ano\n"
                + "6 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }

    private static Jogo cadastrarJogo() {
        Jogo jogo = new Jogo();
        jogo.titulo = JOptionPane.showInputDialog("Digite o título do jogo:");
        jogo.anoLancamento = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de lançamento (1990-2024):"));
        jogo.plataforma = JOptionPane.showInputDialog("Digite a plataforma:");
        jogo.nota = Integer.parseInt(JOptionPane.showInputDialog("Digite a nota (1-5):"));
        return jogo;
    }

    private static void listarTodosJogos() {
        StringBuilder sb = new StringBuilder("Lista de todos os jogos:\n");
        for (Jogo jogo : jogos) {
            sb.append(jogo).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void buscarPorPlataforma() {
        String plataforma = JOptionPane.showInputDialog("Digite a plataforma:");
        StringBuilder sb = new StringBuilder("Jogos na plataforma " + plataforma + ":\n");
        for (Jogo jogo : jogos) {
            if (jogo.plataforma.equalsIgnoreCase(plataforma)) {
                sb.append(jogo).append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void buscarPorNota() {
        int nota = Integer.parseInt(JOptionPane.showInputDialog("Digite a nota (1-5):"));
        StringBuilder sb = new StringBuilder("Jogos com nota " + nota + ":\n");
        for (Jogo jogo : jogos) {
            if (jogo.nota == nota) {
                sb.append(jogo).append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void jogoComMaiorNota() {
        String plataforma = JOptionPane.showInputDialog("Digite a plataforma:");
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de lançamento:"));
        Jogo melhorJogo = null;
        for (Jogo jogo : jogos) {
            if (jogo.plataforma.equalsIgnoreCase(plataforma) && jogo.anoLancamento == ano) {
                if (melhorJogo == null || jogo.nota > melhorJogo.nota) {
                    melhorJogo = jogo;
                }
            }
        }
        if (melhorJogo != null) {
            JOptionPane.showMessageDialog(null, "O jogo com a maior nota para a plataforma " + plataforma + " no ano " + ano + " é:\n" + melhorJogo);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum jogo encontrado para essa plataforma e ano.");
        }
    }
}
