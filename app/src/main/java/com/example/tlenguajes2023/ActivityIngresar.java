package com.example.tlenguajes2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tlenguajes2023.configuracion.ConfigDB;
import com.example.tlenguajes2023.configuracion.SQLiteConnection;

public class ActivityIngresar extends AppCompatActivity {

    EditText id, nombres, apellidos,  direccion, edad, correo;
    Spinner genero;
    Button btningresar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        id = (EditText) findViewById(R.id.txtid);
        nombres = (EditText) findViewById(R.id.txtnomb);
        apellidos = (EditText) findViewById(R.id.txtapel);
        genero = (Spinner) findViewById(R.id.cmbgenero);
        direccion = (EditText) findViewById(R.id.txtdireccion);
        edad = (EditText) findViewById(R.id.txtedad);
        correo = (EditText) findViewById(R.id.txtcorreo);
        btningresar = (Button) findViewById(R.id.btningresar);

        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertar_datos();
            }
        });

    }

    private void insertar_datos()
    {
        SQLiteConnection conexion = new SQLiteConnection(this, ConfigDB.namebd, null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ConfigDB.nombres,nombres.getText().toString());
        values.put(ConfigDB.apellidos,apellidos.getText().toString());
        values.put(ConfigDB.genero,genero.getSelectedItem().toString());
        values.put(ConfigDB.direccion,direccion.getText().toString());
        values.put(ConfigDB.edad,edad.getText().toString());
        values.put(ConfigDB.correo,correo.getText().toString());

        Long resultado = db.insert(ConfigDB.tblpersonas, ConfigDB.id, values);
        if(resultado > 0)
        {
            Toast.makeText(getApplicationContext(), "Registro ingresado con exito",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Registro no se ingreso",Toast.LENGTH_LONG).show();
        }

        db.close();

        ClearScreen();
    }

    private void ClearScreen()
    {
        nombres.setText(ConfigDB.Empty);
        apellidos.setText(ConfigDB.Empty);
        direccion.setText(ConfigDB.Empty);
        edad.setText(ConfigDB.Empty);
        correo.setText(ConfigDB.Empty);
    }
}