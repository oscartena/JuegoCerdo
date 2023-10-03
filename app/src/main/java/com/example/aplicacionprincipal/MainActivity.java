package com.example.aplicacionprincipal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aplicacionprincipal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    int puntuacion1, puntuacion2, puntuacionActual=0;
    boolean turnoPlayer1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        binding.tirarDado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numero = (int) (Math.random() * 6 + 1);

                switch (numero){
                    case 1: binding.dado.setImageResource(R.drawable.dice_one);
                    break;
                    case 2: binding.dado.setImageResource(R.drawable.dice_two);
                    break;
                    case 3: binding.dado.setImageResource(R.drawable.dice_three);
                    break;
                    case 4: binding.dado.setImageResource(R.drawable.dice_four);
                    break;
                    case 5: binding.dado.setImageResource(R.drawable.dice_five);
                    break;
                    case 6: binding.dado.setImageResource(R.drawable.dice_six);
                    break;
                }

                if (turnoPlayer1) {
                    if (numero != 1) {
                        puntuacionActual = puntuacionActual + numero;
                        binding.contador1.setText("Puntuacion: " + puntuacionActual);
                    } else {
                        puntuacionActual=0;
                        binding.contador1.setText("Puntuacion: "+puntuacionActual);
                        turnoPlayer1=false;
                    }
                }
                else if (numero != 1) {
                    puntuacionActual = puntuacionActual + numero;
                    binding.contador2.setText("Puntuacion: " + puntuacionActual);
                } else {
                    puntuacionActual=0;
                    binding.contador2.setText("Puntuacion: "+puntuacionActual);
                    turnoPlayer1 = true;
                }

            }
        });

        binding.mantenerPuntos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turnoPlayer1){
                    puntuacionActual=0;
                    turnoPlayer1=false;
                }
                else {
                    puntuacionActual=0;
                    turnoPlayer1 = true;
                }
            }
        });

        binding.reinicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this.getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


    }
}