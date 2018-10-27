package com.example.a21_pc5.tareanivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class JuegoIniciado extends AppCompatActivity {

    Button btnPiedra, btnPapel, btnTijera;
    TextView Datos, Datos2, Datos3;
    int JugadorPuntaje=0;
    int CPUpuntaje=0;
    ImageView imgJugador, imgCPU;
    int userinput = 0;
    int pierde=0;
    int gana=0;
    int  empate=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_iniciado);

        btnPiedra=(Button)findViewById(R.id.btnPiedra);
        btnPapel=(Button)findViewById(R.id.btnPapel);
        btnTijera=(Button)findViewById(R.id.btnTijera);

        Datos=(TextView)findViewById(R.id.Datos);
        Datos2=(TextView)findViewById(R.id.Datos2);
        Datos3=(TextView)findViewById(R.id.Datos3);

        imgJugador = (ImageView)findViewById(R.id.imgJugador);
        imgCPU = (ImageView)findViewById(R.id.imgCPU);

    btnPiedra.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
             imgJugador.setImageResource(R.drawable.piedra);
             String mensaje = turno("PIEDRA");
            Toast.makeText(JuegoIniciado.this,mensaje,Toast.LENGTH_LONG).show();
           // txtGanados.setText(" "+Integer.toString(JugadorPuntaje);
            //txtPerdidos.setText(" "+Integer.toString(CPUpuntaje));

        }
    });

        btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgJugador.setImageResource(R.drawable.papel);
                String mensaje = turno("PAPEL");
                Toast.makeText(JuegoIniciado.this,mensaje,Toast.LENGTH_LONG).show();
                //txtGanados.setText(" "+Integer.toString(JugadorPuntaje);
                //txtPerdidos.setText(" "+Integer.toString(CPUpuntaje));

            }
        });
        btnTijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgJugador.setImageResource(R.drawable.tijeras);
                String mensaje = turno("PIEDRA");
                Toast.makeText(JuegoIniciado.this,mensaje,Toast.LENGTH_LONG).show();
                //txtGanados.setText(" "+Integer.toString(JugadorPuntaje);
                //txtPerdidos.setText(" "+Integer.toString(CPUpuntaje));

            }
        });

    }

    public String turno(String elegido) {

        String dispositivo_selecciono = " ";
        Random r = new Random();
        int dispos_selecciono_numero = r.nextInt(3) + 1;
        if (dispos_selecciono_numero == 1) {
            dispositivo_selecciono = "PIEDRA";
        } else if (dispos_selecciono_numero == 2) {
            dispositivo_selecciono = "PAPEL";
        } else if (dispos_selecciono_numero == 3) {
            dispositivo_selecciono = "TIJERA";
        }


        if (dispositivo_selecciono == "PIEDRA") {
            imgCPU.setImageResource(R.drawable.piedra);
        }else if (dispositivo_selecciono=="PAPEL"){
            imgCPU.setImageResource(R.drawable.papel);
        }else if (dispositivo_selecciono=="TIJERAS") {
            imgCPU.setImageResource(R.drawable.tijeras);

        }
        if (dispositivo_selecciono==elegido){
            return "EMPATADOS";
        }
        else if (elegido=="PIEDRA"&&dispositivo_selecciono=="TIJERAS"){
            JugadorPuntaje++;
            return "PIEDRA GANA A TIJERAS";
        }
        else if (elegido=="PIEDRA"&&dispositivo_selecciono=="PAPEL"){
            CPUpuntaje++;
            return "PAPEL GANA A PIEDRA, PERDISTE...";
        }
        else if (elegido=="TIJERAS"&&dispositivo_selecciono=="PIEDRA"){
            CPUpuntaje++;
            return "PIEDRA ROMPE A TIJERAS, PERDISTE...";
        }
        else if (elegido=="TIJERAS"&&dispositivo_selecciono=="PAPEL"){
            JugadorPuntaje++;
        return "TIJERAS GANA A PAPEL, FELICIDADES GANASTE";
        }
        else if (elegido=="PAPEL"&&dispositivo_selecciono=="PIEDRA") {
            JugadorPuntaje++;
            return "PAPEL GANA A PIEDRA, FELICIDADES GANASTE";
        }
        else if (elegido=="PAPEL"&&dispositivo_selecciono=="TIJERAS") {
            CPUpuntaje++;
            return "TIJERAS GANA A PAPEL, PERDISTE";
        } else return "NO VALIDO";
    }

    //metodo para enviar resultados a un segundo activity
    public void irAresultados(View view){

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra( "dato1",gana );
        intent.putExtra( "dato2",pierde );
        intent.putExtra( "dato3",empate );


        //startActivity(intent);
    }


    public void irAhome(View view){
        Intent irar = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(irar);
    }


    public void recibirdatos(){
        Bundle extras = getIntent().getExtras();


        int d1= extras.getInt( "dato2" );
        int d2= extras.getInt(  "dato2");
        int d3= extras.getInt(  "dato3");

        // TextView para mostrar los datos
        Datos= findViewById( R.id.Datos );
        Datos2= findViewById( R.id.Datos2 );
        Datos3=findViewById( R.id.Datos3 );

        Datos.setText( "Ganadas:"+d1);
        Datos2.setText("Perdidas:"+d2);
        Datos3.setText("PEmpate: "+d3);
    }
}

