package com.recursos.validadorcpf;

public class Validador {

    public static void main(String[] args) {
        String meucpf = "08308808956";
        System.out.println(cpfValido(meucpf));
    }

    public static char cpfValido(String cpf) {
        return cpf.charAt(0);
    }

    
}
