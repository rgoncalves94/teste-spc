import logic.LeitorPaciente;
import logic.Relatorio;
import model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        LeitorPaciente leitor = new LeitorPaciente();

        List<Paciente> pacientes = leitor.aguardaEntrada();

        new Relatorio(pacientes).apresenta();
    }
}
