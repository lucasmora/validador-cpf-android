package com.recursos.validadorcpf;

import android.util.Log;

import java.lang.String;

public class Validador {
    public static boolean isValid(String cpf) {
        // Verifica se os números foram preenchidos
        if (cpf.length() != 11) {
            Log.println(Log.INFO, "Anotação: ", "Não foram preenchidos todos os números.");
            return false;
        }

        // Verifica se os números não são todos iguais
        if (cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666")
                || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999")) {
            Log.println(Log.INFO, "Anotação: ", "Foram preenchidos números iguais.");
            return false;
        }

        int i = 0;
        char atual = cpf.charAt(i);
        char proximo = cpf.charAt(i + 1);

        // Verificação do primeiro dígito
        int iterador = 10;
        int total = 0;
        for (int posicao = 0; posicao < 9; posicao++) {
            int resultado = Character.getNumericValue(cpf.charAt(posicao)) * iterador;
            total += resultado;
            iterador--;
        }

        int resto = (total * 10) % 11;

        // Caso o resto seja igual ao 10. dígito, continuar a verificação do segundo dígito;
        // Caso contrário, retornar false
        if (resto == Character.getNumericValue(cpf.charAt(9))) {
            iterador = 11;
            total = 0;
            for (int posicao = 0; posicao < 10; posicao++) {
                int resultado = Character.getNumericValue(cpf.charAt(posicao)) * iterador;
                total += resultado;
                iterador--;
            }

            resto = (total * 10) % 11;

            // Caso o resto seja igual ao 11. dígito, retornar true (CPF válido)
            // Caso contrário, retornar false
            if (resto == Character.getNumericValue(cpf.charAt(10))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}