package com.kbebo.cazacupones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registro_2Activity extends AppCompatActivity {
    private Button btnComerciante,btnCuponero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_2);
        this.btnComerciante = findViewById(R.id.btnComerciante);
        this.btnCuponero = findViewById(R.id.btnCuponero);

        this.btnComerciante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ComercianteActivity.class);
                startActivity(intent);
            }
        });


    }
}
