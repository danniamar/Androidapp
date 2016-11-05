package com.example.a64.imcapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "IMCApplication";
    private TextView txtresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         txtresultado = (TextView) findViewById(R.id.txt_result);
    }


    public void calcular(View view) {
        Log.d(TAG, "Entra a calcular con el click");
        EditText edtpeso = (EditText) findViewById(R.id.edt_peso);
        EditText edtaltura = (EditText) findViewById(R.id.edt_altura);

        String peso = edtpeso.getText().toString();
        String altura = edtaltura.getText().toString();

        if(altura.isEmpty() && peso.isEmpty()) return;
        if(altura.matches("\\d+") && peso.matches("\\d+")){
            float p = Float.parseFloat(peso);
            float a = Float.parseFloat(altura);

            calcularIMC(p, a);
        }
    }

    public void calcularIMC(float kg, float cm){
        
        cm = (cm / 100);
        float imc = kg / (cm * cm);
        String resultado;
        int color;
        if (imc <16){
            resultado = "BMI: " + imc + " ( Severamente Bajo )";
            color = Color.RED;
        }else if (imc < 18.5){
            resultado = "BMI: " + imc + " ( Bajo )";
            color = Color.YELLOW;
        }else if (imc < 25){
            resultado = "BMI: " + imc + " ( Normal )";
            color = Color.GREEN;
        }else if (imc < 30){
            resultado = "BMI: " + imc + " ( Sobre peso )";
            color = Color.YELLOW;
        }else{
            resultado = "BMI: " + imc + " ( Obeso )";
            color = Color.RED;
        }
        txtresultado.setTextColor(color);
        txtresultado.setText(resultado);
        //Log.i(TAG, resultado);
       // return resultado;
    }
}
