package com.recursos.validadorcpf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.EditText;

public class activity_validador extends AppCompatActivity {
    EditText cpfInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpf);

        cpfInput = (EditText) findViewById(R.id.cpf_edit);
        TextWatcher mascara = Mascara.mask(cpfInput, "###.###.###-##");
        cpfInput.addTextChangedListener(mascara);
    }
}