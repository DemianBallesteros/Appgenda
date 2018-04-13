package com.example.home.appgenda;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home.appgenda.utilidades.Utilidades;

class BuscarClientes extends AppCompatActivity {

    EditText campoId,campoNombre,campoTelefono,campoInformacion;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_clientes);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_clienes",null,1);

        campoId= (EditText) findViewById(R.id.campoId);
        campoNombre= (EditText) findViewById(R.id.campoNombre);
        campoTelefono= (EditText) findViewById(R.id.campoTelefono);
        campoInformacion= (EditText) findViewById(R.id.campoInformacion);
    }



    public void onClick(View view){

        Intent miIntent=null;

        switch (view.getId()){
            case R.id.btnBuscar:
                buscar();
                break;
            case R.id.btnActualizar: actualizarUsuario();
                break;
            case R.id.btnEliminar: eliminarUsuario();
                break;
            case R.id.btnMenu:
                miIntent=new Intent(BuscarClientes.this,Main2Activity.class);
                break;
        }
        startActivity(miIntent);
    }

    private void eliminarUsuario() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};

        db.delete(Utilidades.TABLA_CLIENTE,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Se eliminó el usuario",Toast.LENGTH_LONG).show();
       campoId.setText("");
        limpiar();
        db.close();

    }

    private void actualizarUsuario() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());

        db.update(Utilidades.TABLA_CLIENTE,values,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizó el usuario",Toast.LENGTH_LONG).show();
        db.close();
    }

    private void buscar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};
        String[] campos={Utilidades.CAMPO_NOMBRE ,Utilidades.CAMPO_TELEFONO,Utilidades.CAMPO_INFORMACION};

        try{
            Cursor cursor =db.query(Utilidades.TABLA_CLIENTE,campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null,null);
            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoTelefono.setText(cursor.getString(1));
            campoInformacion.setText(cursor.getString(2));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
            limpiar();

        }

    }

    private void limpiar() {
        campoNombre.setText("");
        campoTelefono.setText("");
        campoInformacion.setText("");
    }


}
