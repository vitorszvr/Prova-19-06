package questao3;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PrincipalJogos {

    public static void main(String[] args) {
        ArrayList<Jogo> lista = new ArrayList<Jogo>();
        int op = 0;
        do {
            op = menu();
            if (op == 1) lista.add(lerJogo());
            if (op == 2) listarJogos(lista);
            if (op == 3) buscarPorPlataforma(lista);
            if (op == 4) buscarPorNota(lista);
            if (op == 5) jogoMaiorNota(lista);
        } while (op != 6);
    }

    private static int menu() {
        String m = "1 - Cadastrar jogo\n"
                + "2 - Listar todos\n"
                + "3 - Buscar por plataforma\n"
                + "4 - Buscar por nota\n"
                + "5 - Jogo com maior nota para plataforma e ano\n"
                + "6 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }

    private static void msg(String txt) {
        JOptionPane.showMessageDialog(null, txt);
    }

    private static String escreveJogo(Jogo j) {
        return "Título: " + j.titulo + "\n" +
                "Ano: " + j.ano + "\n" +
                "Plataforma: " + j.plataforma + "\n" +
                "Nota: " + j.nota;
    }

    private static Jogo lerJogo() {
        Jogo j = new Jogo();
        j.titulo = lerString("Título");
        j.ano = lerInt("Ano de lançamento", 1990, 2024);
        j.plataforma = lerString("Plataforma");
        j.nota = lerInt("Nota", 1, 5);
        return j;
    }

    private static String lerString(String txt) {
        String str = JOptionPane.showInputDialog(txt);
        if (str.trim().equals("")) {
            return lerString(txt);
        }
        return str.toUpperCase();
    }

    private static int lerInt(String txt, int min, int max) {
        int i = Integer.parseInt(JOptionPane.showInputDialog(txt));
        if (i < min || i > max) {
            return lerInt(txt, min, max);
        }
        return i;
    }

    private static void listarJogos(ArrayList<Jogo> lista) {
        String ret = "";
        for (Jogo j : lista) {
            ret += escreveJogo(j) + "\n\n";
        }
        msg(ret);
    }

    private static void buscarPorPlataforma(ArrayList<Jogo> lista) {
        String plataforma = lerString("Informe a plataforma").toUpperCase();
        String ret = "";
        for (Jogo j : lista) {
            if (j.plataforma.equals(plataforma)) {
                ret += escreveJogo(j) + "\n\n";
            }
        }
        msg(ret);
    }

    private static void buscarPorNota(ArrayList<Jogo> lista) {
        int nota = lerInt("Informe a nota", 1, 5);
        String ret = "";
        for (Jogo j : lista) {
            if (j.nota == nota) {
                ret += escreveJogo(j) + "\n\n";
            }
        }
        msg(ret);
    }

    private static void jogoMaiorNota(ArrayList<Jogo> lista) {
        String plataforma = lerString("Informe a plataforma").toUpperCase();
        int ano = lerInt("Informe o ano de lançamento", 1990, 2024);
        Jogo maiorNota = null;
        for (Jogo j : lista) {
            if (j.plataforma.equals(plataforma) && j.ano == ano) {
                if (maiorNota == null || j.nota > maiorNota.nota) {
                    maiorNota = j;
                }
            }
        }
        if (maiorNota != null) {
            msg(escreveJogo(maiorNota));
        } else {
            msg("Nenhum jogo encontrado para a plataforma e ano informados.");
        }
    }
}
