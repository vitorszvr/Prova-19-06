package questao2;

public class Paciente {
    String nome;
    String dataNascimento;  // Formato: DD/MM/YYYY
    String genero;
    String numeroCartaoSUS;
    String[] diagnosticos;

    public Paciente() {
        diagnosticos = new String[5];  // Supondo que cada paciente pode ter até 5 diagnósticos
    }
}