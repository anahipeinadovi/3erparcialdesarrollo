package com.fing.uach.cv;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PipedInputStream;


public class cv2 extends AppCompatActivity {

    private TextView textViewContactInfo2;
    private TextView textViewObjective;
    private TextView textViewExperiencia;
    private TextView textViewPreparacion;
    private TextView textViewHabilidades;


    @SuppressLint({"CutPasteId", "WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv2);

        textViewContactInfo2 = findViewById(R.id.textViewContactInfo2);
        textViewObjective = findViewById(R.id.textViewObjective);
        textViewExperiencia = findViewById(R.id.textViewExperiencia);
        textViewPreparacion = findViewById(R.id.textViewPreparacion);
        textViewHabilidades = findViewById(R.id.textViewHabilidades);


        new GetHtmlTask().execute("https://anahipeinadovi.github.io/");
    }

    public void openWebsite(View view) {
        String url = "https://github.com/anahipeinadovi";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }


    private class GetHtmlTask extends AsyncTask<String, Void, Document> {

        @Override
        protected Document doInBackground(String... params) {
            String url = params[0];
            try {
                return Jsoup.connect(url).get();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(Document document) {
            if (document != null) {

                String contactInfo2 = obtenerContenidoDespuesDeSeccion(document, "info-personal");
                String objective = obtenerContenidoDespuesDeSeccion(document, "objective");
                String experiencia = obtenerContenidoDespuesDeSeccion(document, "experiencia");
                String preparacion = obtenerContenidoDespuesDeSeccion(document, "preparacion");
                String habilidades = obtenerContenidoDespuesDeSeccion(document, "habilidades");


                textViewContactInfo2.setText(contactInfo2);
                textViewObjective.setText(objective);
                textViewExperiencia.setText(experiencia);
                textViewPreparacion.setText(preparacion);
                textViewHabilidades.setText(habilidades);

            } else {
                textViewContactInfo2.setText("Error al obtener la información del enlace HTML.");
            }
        }

        private String obtenerContenidoDespuesDeSeccion(Document document, String seccion) {
            Elements seccionElements = document.select("." + seccion);
            StringBuilder contenidoBuilder = new StringBuilder();
            boolean seccionEncontrada = false;

            for (Element seccionElement : seccionElements) {
                if (seccionElement.className().equals(seccion)) {
                    seccionEncontrada = true;
                }

                if (seccionEncontrada) {
                    contenidoBuilder.append(seccionElement.text()).append("\n");
                }
            }

            return contenidoBuilder.toString().trim();
        }




    }
}