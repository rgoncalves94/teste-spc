package model;

public class Paciente {
    private String nome;
    private char sexo;
    private int peso;
    private int idade;
    private double altura;

    public Paciente(String nome, char sexo, int peso, int idade, double altura) {
        this.nome = nome;
        this.sexo = sexo;
        this.peso = peso;
        this.idade = idade;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public int getPeso() {
        return peso;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    public String toString() {
        return String.format("%s|%s|%d|%d|%.2f", nome, sexo, peso, idade, altura);
    }
}
