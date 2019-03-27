package logic;

import model.Paciente;

import java.util.List;

public class Relatorio {

    private List<Paciente> pacientes;

    public Relatorio(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void apresenta() {
        String[] relatorios = {
                obtemTotalPacientes(),
                obtemMediaIdadeHomens(),
                obtemTotalMulheresEspecificas(),
                obtemTotalPessoasComIdadeEspecifica(),
                obtemPacienteMaisVelho(),
                nomeMulherMaisBaixa(),
                obtemPerfilIMCLista()
        };

        System.out.println("Relatório:");
        for (String relatorio : relatorios)
            System.out.println(relatorio);
    }

    private String obtemTotalPacientes() {
        return String.format("I) Total pacientes: %d", pacientes.size());
    }

    private String obtemMediaIdadeHomens() {
        int totalPacientesHomens = 0;
        int totalIdadeHomens = 0;
        for(Paciente paciente : pacientes) {
            if(paciente.getSexo() == 'M') {
                totalPacientesHomens++;
                totalIdadeHomens += paciente.getIdade();
            }
        }

        return String.format("II) Média de de idade dos homens: %.2f", (double) totalIdadeHomens / totalPacientesHomens);
    }

    private String obtemTotalMulheresEspecificas() {
        int mulheresComAlturaEspecifica = 0;
        for(Paciente paciente : pacientes) {
            if (paciente.getSexo() == 'F' && paciente.getAltura() >= 1.6 && paciente.getAltura() <= 1.7 && paciente.getPeso() > 70) {
                mulheresComAlturaEspecifica++;
            }
        }

        return String.format("III) Total de mulheres com altura entre 1,60 e 1,70 e peso acima de 70kg: %d", mulheresComAlturaEspecifica);
    }

    private String obtemTotalPessoasComIdadeEspecifica() {
        int pessoasComIdadeEspecifica = 0;
        for(Paciente paciente : pacientes) {
            if (paciente.getIdade() >= 18 && paciente.getIdade() <= 25) {
                pessoasComIdadeEspecifica++;
            }
        }
        return String.format("IV) Total de pessoas com idade entre 18 e 25: %d", pessoasComIdadeEspecifica);
    }

    private String obtemPacienteMaisVelho() {
        Paciente pacienteMaisVelho = new Paciente("Nenhum", 'M', 0, 0, 0);
        for(Paciente paciente : pacientes) {
            if (pacienteMaisVelho.getIdade() < paciente.getIdade()) {
                pacienteMaisVelho = paciente;
            }
        }

        return String.format("IV) Nome do paciente mais velho: %s", pacienteMaisVelho.getNome());
    }

    private String nomeMulherMaisBaixa() {
        Paciente mulherMaisBaixa = new Paciente("Nenhum", 'F', 0, 0, 5000);
        for(Paciente paciente : pacientes) {
            if(mulherMaisBaixa.getAltura() > paciente.getAltura() && paciente.getSexo() == 'F') {
                mulherMaisBaixa = paciente;
            }

        }
        return String.format("V) Nome da mulher mais baixa: %s", mulherMaisBaixa.getNome());
    }

    private String obtemPerfilIMCLista() {
        double totalIMC = 0;
        for(Paciente paciente : pacientes) {
            totalIMC += (paciente.getPeso() / (paciente.getAltura() * paciente.getAltura()));
        }

        double media = totalIMC / pacientes.size();
        String perfil;
        if(media < 18.5)
             perfil = "Abaixo do peso";
         else if(media >= 18.5 && media < 25)
             perfil = "Peso Normal";
         else if(media >= 25 && media < 30)
             perfil = "Sobrepeso";
         else if(media >= 30 && media < 35)
             perfil = "Obesidade grau 1";
         else if(media >= 35 && media < 40)
            perfil = "Obesidade grau 2";
         else
            perfil = "Obesidade grau 3";

        return String.format("VI) Perfil IMC do grupo: %s", perfil);
    }
}
