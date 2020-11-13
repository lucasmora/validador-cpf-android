package com.recursos.validadorcpf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class activity_validador extends AppCompatActivity {
    EditText cpfInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpf);

        cpfInput = (EditText) findViewById(R.id.cpf_edit);
        TextWatcher mascara = Mascara.mask(cpfInput, "###.###.###-##");  // Cria a máscara
        cpfInput.addTextChangedListener(mascara); // Adiciona a máscara ao EditText
    }

    public void validarCPF(View v) {
        String cpfPuro = cpfInput.getText().toString(); // cpfPuro: CPF com os dígitos formatadores, conforme máscara
        if (cpfPuro.equals("")) {
            Toast.makeText(getApplicationContext(), "Digite um CPF no campo indicado.", Toast.LENGTH_LONG).show();
        } else {
            String cpfNumero = Mascara.unmask(cpfPuro); // cpfNumero: String contendo apenas os dígitos do CPF

            boolean valido = Validador.isValid(cpfNumero); // Valida o CPF e retorna boolean

            String texto;
            if (valido) {
                texto = cpfPuro + " é um CPF válido!";
            } else {
                texto = cpfPuro + " não é um CPF válido.";
            }

            Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG).show(); // Cria Toast de acordo com o resultado
        }
    }
}