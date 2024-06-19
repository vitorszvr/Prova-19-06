package questao4;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PrincipalCarros {

    public static void main(String[] args) {
        ArrayList<Carro> lista = new ArrayList<Carro>();
        int op = 0;
        do {
            op = menu();
            if(op == 1) lista.add(lerCarro());
            if(op == 2) localizarCarroPorPlaca(lista);
            if(op == 3) verificarCondutor(lista);
            if(op == 4) carrosFabricadosEm2024(lista);
            if(op == 5) listarCarrosPorCor(lista);
        }while(op != 6);
    }

    private static int menu() {
        String m = "1 - Cadastrar Carro\n"
                + "2 - Localizar um carro pela Placa\n"
                + "3 - Verificar quais carros um condutor pode dirigir\n"
                + "4 - Dados de todos os carros fabricados no ano 2024\n"
                + "5 - Listar todos os carros de uma determinada cor\n"
                + "6 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }

    private static void msg(String txt) {
        JOptionPane.showMessageDialog(null, txt);
    }

    private static String escreveCarro(Carro c) {
        String condutores = String.join(", ", c.condutores);
        return "Marca: " + c.marca + "\n" +
                "Modelo: " + c.modelo + "\n" +
                "Ano: " + c.ano + "\n" +
                "Cor: " + c.cor + "\n" +
                "Placa: " + c.placa + "\n" +
                "Condutores: " + condutores;
    }

    private static Carro lerCarro() {
        Carro c = new Carro();
        c.marca = lerString("Marca");
        c.modelo = lerString("Modelo");
        c.ano = lerInt("Ano de Fabricação");
        c.cor = lerString("Cor");
        c.placa = lerString("Placa");
        c.condutores = lerCondutores();
        return c;
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

    private static String[] lerCondutores() {
        int num = lerInt("Número de Condutores");
        String[] condutores = new String[num];
        for (int i = 0; i < num; i++) {
            condutores[i] = lerString("Nome do Condutor " + (i + 1));
        }
        return condutores;
    }

    private static void localizarCarroPorPlaca(ArrayList<Carro> lista) {
        String placa = lerString("Placa do Carro");
        for (Carro c : lista) {
            if(c.placa.equals(placa)) {
                msg("Condutores: " + String.join(", ", c.condutores));
                return;
            }
        }
        msg("Carro não encontrado!");
    }

    private static void verificarCondutor(ArrayList<Carro> lista) {
        String nome = lerString("Nome do Condutor");
        StringBuilder carros = new StringBuilder();
        for (Carro c : lista) {
            for (String condutor : c.condutores) {
                if (condutor.equalsIgnoreCase(nome)) {
                    carros.append(escreveCarro(c)).append("\n\n");
                    break;
                }
            }
        }
        msg(carros.length() > 0 ? carros.toString() : "Nenhum carro encontrado para o condutor " + nome);
    }

    private static void carrosFabricadosEm2024(ArrayList<Carro> lista) {
        StringBuilder carros = new StringBuilder();
        for (Carro c : lista) {
            if(c.ano == 2024) {
                carros.append(escreveCarro(c)).append("\n\n");
            }
        }
        msg(carros.length() > 0 ? carros.toString() : "Nenhum carro fabricado em 2024 encontrado!");
    }

    private static void listarCarrosPorCor(ArrayList<Carro> lista) {
        String cor = lerString("Cor do Carro");
        StringBuilder carros = new StringBuilder();
        for (Carro c : lista) {
            if(c.cor.equalsIgnoreCase(cor)) {
                carros.append(escreveCarro(c)).append("\n\n");
            }
        }
        msg(carros.length() > 0 ? carros.toString() : "Nenhum carro da cor " + cor + " encontrado!");
    }
}
