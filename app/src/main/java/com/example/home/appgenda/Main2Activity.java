package com.example.home.appgenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "bd_clientes", null, 1);
    }

    public void onClick(View view){

        Intent miIntent=null;

        switch (view.getId()) {
            case R.id.btnRegistrar:
                miIntent = new Intent(Main2Activity.this,RegistroClientes.class);
                break;
        }


        switch (view.getId()){
            case R.id.btnBuscar:
                miIntent=new Intent(Main2Activity.this,BuscarClientes.class);
                break;
        }


            startActivity(miIntent);

    }

//public void clickexite(View v){
       // moveTaskToBack(true);
      //  android.os.Process.killProcess(android.os.Process.myPid());
    //    System.exit(1);
//}


}
