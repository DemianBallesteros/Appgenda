package com.example.home.appgenda;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home.appgenda.utilidades.Utilidades;

public class RegistroClientes extends AppCompatActivity {

    EditText campoId,campoNombre,campoTelefono,campoInformacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_clientes);

        campoId= (EditText) findViewById(R.id.campoId);
        campoNombre = (EditText) findViewById(R.id.campoNombre);
        campoTelefono = (EditText) findViewById(R.id.campoTelefono);
        campoInformacion = (EditText) findViewById(R.id.campoInformacion);

    }

    public void onClick(View view){
        registrarClientes();

        Intent miIntent=null;

        switch (view.getId()){
            case R.id.btnMenu:
                miIntent=new Intent(RegistroClientes.this,Main2Activity.class);
                break;
        }

        switch (view.getId()){
            case R.id.btnRegistro:
                miIntent=new Intent(RegistroClientes.this,Main2Activity.class);
                break;
        }
        startActivity(miIntent);
    }



    private void registrarClientes(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_clientes",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();


        ContentValues values=new ContentValues();

        values.put(Utilidades.CAMPO_ID,campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());
        values.put(Utilidades.CAMPO_INFORMACION,campoInformacion.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_CLIENTE, Utilidades.CAMPO_ID, values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }




}
