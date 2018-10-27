package com.example.a21_pc5.tareanivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button BtnIniciarJuego;
    private Button BtnPuntajes;
    private Button BtnNuevoJugador;

    //se inician los botones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.BtnNuevoJugador = (Button) findViewById(R.id.BtnNuevoJugador);
        this.BtnIniciarJuego = (Button) findViewById(R.id.BtnIniciarJuego);
        this.BtnPuntajes = (Button) findViewById(R.id.BtnPuntajes);
        this.BtnNuevoJugador.setOnClickListener(new View.OnClickListener() {

        //conexion con activitys
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Nuevo_Contrincante.class);
                startActivity(intent);
            }
        });
        this.BtnIniciarJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, JuegoIniciado.class);
                startActivity(intent);
            }
        });
        this.BtnPuntajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Puntajes.class);
                startActivity(intent);
            }
        });
    }
}
