package com.atenea.practicaimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    private int[] imageIds = {R.drawable.hibrido,R.drawable.aerogeneradores,R.drawable.eficiencia};
    private String[] cardTiles = {"Free Energy","Wind Energy", "Efficiency"};
    private String[] cardDescriptions = {"Descripcion 1","Descripcion 2","Descripticion 3"};
    private int currentIndex = 0;
    private ImageView imageView;
    private MaterialTextView cardTitle;
    private MaterialTextView cardDescription;
    private MaterialButton botonNext;
    private MaterialButton botonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_card);
        cardTitle = findViewById(R.id.card_title);
        cardDescription = findViewById(R.id.card_SUBtitle);
        botonNext = findViewById(R.id.btn_next);
        botonBack = findViewById(R.id.btn_back);

        setterInitialValues();

        botonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accionesBotonSiguiente();
            }
        });
        botonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accionesBotonAtras();
            }
        });
    }

    private void accionesBotonAtras() {
        currentIndex--;
        if(currentIndex < 0)
        {
            currentIndex = imageIds.length - 1;
        }
        setterInitialValues();
    }

    protected void accionesBotonSiguiente() {
        currentIndex++;
        if(currentIndex >= imageIds.length)
        {
            currentIndex = 0;
        }
        setterInitialValues();
    }

    protected void setterInitialValues() {
        imageView.setImageResource(imageIds[currentIndex]);
        cardTitle.setText(cardTiles[currentIndex]);
        cardDescription.setText(cardDescriptions[currentIndex]);
    }
}