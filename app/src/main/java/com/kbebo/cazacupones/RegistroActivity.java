package com.kbebo.cazacupones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kbebo.cazacupones.Modelo.DTOContactos;

import java.util.UUID;

public class RegistroActivity extends AppCompatActivity {

    private EditText txtnombre,txtapellidos,txtcorreo,txtpass,txtconfpass;
    private Button btnsiguiente;

    /*
    Variables requeridas para la base de datos Firebase
     */
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtnombre = findViewById(R.id.txtNombre);
        txtapellidos = findViewById(R.id.txtApellidos);
        txtcorreo = findViewById(R.id.txtCorrero);
        txtpass = findViewById(R.id.txtPassword);
        txtconfpass = findViewById(R.id.txtconfPass);
        btnsiguiente = findViewById(R.id.btnSiguiente);

        iniciarFirebase();

        this.btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarCampos();
            }
        });

    }

    /*
    Metodo para iniciar la base de datos
     */
    private void iniciarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    /*
    Validamos que los campos no esten vacios
     */
    public void validarCampos(){
        String nombre = txtnombre.getText().toString();
        String ape = txtapellidos.getText().toString();
        String email = txtcorreo.getText().toString();
        String pass = txtpass.getText().toString();
        String confpass = txtconfpass.getText().toString();

        if (nombre.equals("")){
            txtnombre.setError("Campo Requerido");
        }
        else if (ape.equals("")){
            txtapellidos.setError("Campo Requerido");
        }
        else if (email.equals("")){
            txtcorreo.setError("Campo Requerido");
        }
        else if (pass.equals("")){
            txtpass.setError("Campo Requerido");
            if (confpass.equals("")){
                txtconfpass.setError("Campo Requerido");
            }
        }
        else if (confpass.equals(pass)){
            Toast.makeText(this,"LA CONTRASEÑA SON IGUALES",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Registro_2Activity.class);
            startActivity(intent);
        }
    }

    public void guardar(){
        DTOContactos con = new DTOContactos();
        con.setId(UUID.randomUUID().toString());
        con.setNombre(txtnombre.getText().toString());
        con.setNombre(txtapellidos.getText().toString());
        con.setNombre(txtcorreo.getText().toString());
        con.setNombre(txtpass.getText().toString());
        con.setNombre(txtconfpass.getText().toString());
        databaseReference.child("Usuarios").child(con.getId()).setValue(con);
        Toast.makeText(this,"Se agrego correctamente",Toast.LENGTH_LONG).show();
    }

}
