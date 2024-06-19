package questao2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PrincipalPacientes {

    public static void main(String[] args) {
        ArrayList<Paciente> lista = new ArrayList<Paciente>();
        int op = 0;
        do {
            op = menu();
            if(op == 1) lista.add(lerPaciente());
            if(op == 2) localizarPacienteSUS(lista);
            if(op == 3) buscarDiagnosticosPorNome(lista);
            if(op == 4) dadosPacientesAno2000(lista);
            if(op == 5) listarPacientesPorGenero(lista);
        } while(op != 6);
    }

    private static int menu() {
        String m = "1 - Cadastrar Paciente\n"
                + "2 - Localizar paciente pelo Número do Cartão SUS\n"
                + "3 - Verificar diagnósticos por nome\n"
                + "4 - Dados de todos os pacientes nascidos no ano 2000\n"
                + "5 - Listar todos os pacientes de um determinado gênero\n"
                + "6 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }

    private static void msg(String txt) {
        JOptionPane.showMessageDialog(null, txt);
    }

    private static String escrevePaciente(Paciente p) {
        String diagnosticosStr = String.join(", ", p.diagnosticos);
        return "Nome: " + p.nome + "\n" +
                "Data de Nascimento: " + p.dataNascimento + "\n" +
                "Gênero: " + p.genero + "\n" +
                "Número do Cartão SUS: " + p.numeroCartaoSUS + "\n" +
                "Diagnósticos: " + diagnosticosStr;
    }

    private static Paciente lerPaciente() {
        Paciente p = new Paciente();
        p.nome = lerString("Nome");
        p.dataNascimento = lerDataNascimento();
        p.genero = lerGenero();
        p.numeroCartaoSUS = lerString("Número do Cartão SUS");
        for (int i = 0; i < 5; i++) {
            p.diagnosticos[i] = lerString("Diagnóstico " + (i + 1) + " (deixe em branco se não houver mais diagnósticos)");
            if (p.diagnosticos[i].isEmpty()) break;
        }
        return p;
    }

    private static String lerString(String txt) {
        String str = JOptionPane.showInputDialog(txt);
        if (str.trim().equals("")) {
            return (lerString(txt));
        }
        return str.toUpperCase();
    }

    private static String lerDataNascimento() {
        String str = JOptionPane.showInputDialog("Data de Nascimento (DD/MM/YYYY)").trim();
        if (str.matches("\\d{2}/\\d{2}/\\d{4}")) {
            return str;
        }
        return lerDataNascimento();
    }

    private static String lerGenero() {
        String str = JOptionPane.showInputDialog("Gênero (M/F)").trim().toUpperCase();
        if (str.equals("M") || str.equals("F")) {
            return str;
        }
        return lerGenero();
    }

    private static void localizarPacienteSUS(ArrayList<Paciente> lista) {
        String numeroSUS = JOptionPane.showInputDialog("Insira o número do Cartão SUS");
        for (Paciente p : lista) {
            if (p.numeroCartaoSUS.equals(numeroSUS)) {
                msg("Diagnósticos: " + String.join(", ", p.diagnosticos));
                return;
            }
        }
        msg("Paciente não encontrado!");
    }

    private static void buscarDiagnosticosPorNome(ArrayList<Paciente> lista) {
        String nome = JOptionPane.showInputDialog("Insira o nome do paciente");
        for (Paciente p : lista) {
            if (p.nome.equalsIgnoreCase(nome)) {
                msg("Diagnósticos: " + String.join(", ", p.diagnosticos));
                return;
            }
        }
        msg("Paciente não encontrado!");
    }

    private static void dadosPacientesAno2000(ArrayList<Paciente> lista) {
        String mensagem = "";
        for (Paciente p : lista) {
            if (p.dataNascimento.endsWith("2000")) {
                mensagem += escrevePaciente(p) + "\n\n";
            }
        }
        if (mensagem.isEmpty()) {
            msg("Não há pacientes nascidos no ano 2000!");
        } else {
            msg(mensagem);
        }
    }

    private static void listarPacientesPorGenero(ArrayList<Paciente> lista) {
        String genero = lerGenero();
        String mensagem = "";
        for (Paciente p : lista) {
            if (p.genero.equals(genero)) {
                mensagem += escrevePaciente(p) + "\n\n";
            }
        }
        if (mensagem.isEmpty()) {
            msg("Não há pacientes do gênero selecionado!");
        } else {
            msg(mensagem);
        }
    }
}