package logic;

import model.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorPaciente {

    public List<Paciente> aguardaEntrada() {

        List<Paciente> pacientes = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        do {
            String nome;
            char sexo;
            int peso = 0, idade = 0;
            double altura = 0;

            nome = aguardaNome(scan);
            if(nome.equals("fim") || nome.equals("FIM")) {
                System.out.println("Operação finalizada pelo usuário");
                break;
            }
            sexo = aguardaSexo(scan);
            peso = aguardaPeso(scan);
            idade = aguardaIdade(scan);
            altura = aguardaAltura(scan);

            pacientes.add(new Paciente(nome, sexo, peso, idade, altura));
        }while(true);

        System.out.println("Pacientes registrados:");
        System.out.println("Paciente|Sexo|Peso|Idade|Altura");
        for(Paciente paciente : pacientes) System.out.println(paciente.toString());

        return pacientes;
    }

    private double aguardaAltura(Scanner scan) {
        double altura = 0.0;
        boolean isValid = true;

        System.out.println("Informe o altura do Paciente (Ex: 1.79):");

        do {
            if(!isValid) System.out.println("Digite uma altura válida (Ex: 1.79).");
            try {
                altura = Double.parseDouble(scan.nextLine());
                isValid = String.valueOf(altura).matches("^[0-9]{1}\\.[0-9]{1,2}$");
            } catch(Exception e) {
                isValid = false;
            }
        }while(!isValid);
        return altura;
    }

    private int aguardaIdade(Scanner scan) {
        int idade = 0;
        boolean isValid = true;

        System.out.println("Informe a idade do Paciente (Ex: 25):");

        do {
            if(!isValid) System.out.println("Digite uma idade válida (Ex: 22).");
            try {
                idade = Integer.parseInt(scan.nextLine());
                isValid = String.valueOf(idade).matches("^[0-9]+$");
            } catch(Exception e) {
                isValid = false;
            }

        }while(!isValid);

        return idade;
    }

    private int aguardaPeso(Scanner scan) {
        int peso = 0;
        boolean isValid = true;

        System.out.println("Informe o peso do Paciente (Ex: 62):");

        do {
            if(!isValid) System.out.println("Digite um peso válido (Ex: 67).");
            try {
                peso = Integer.parseInt(scan.nextLine());
                isValid = String.valueOf(peso).matches("^[0-9]+$");
            } catch(Exception e) {
                isValid = false;
            }
        }while(!isValid);

        return peso;
    }

    private char aguardaSexo(Scanner scan) {
        boolean isValid = true;
        char sexo;

        System.out.println("Informe o sexo do Paciente (M/F):");

        do {
            if(!isValid) System.out.println("Digite um sexo válido (M/F).");
            sexo = scan.nextLine().charAt(0);
            isValid = String.valueOf(sexo).matches("^(M|F)$");
        }while(!isValid);

        return sexo;
    }

    private String aguardaNome(Scanner scan) {
        String nome;
        boolean isValid = true;

        System.out.println("Informe o nome do Paciente (digite 'fim' para encerrar):");
        do {
            if(!isValid) System.out.println("Digite um nome de Paciente válido.");
            nome = new String(scan.nextLine());

            if(nome.equals("fim") || nome.equals("FIM"))
                break;

            isValid = nome.matches("^([a-zA-Z]+\\s?)+$");
            System.out.println(nome);
        }while(!isValid);

        return nome;
    }
}
