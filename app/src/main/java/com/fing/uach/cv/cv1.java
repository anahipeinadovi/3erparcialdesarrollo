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


public class cv1 extends AppCompatActivity {

    private TextView textViewContactInfo;
    private TextView textViewObj;
    private TextView textViewEducation;
    private TextView textViewSkills;

    @SuppressLint({"CutPasteId", "WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv1);

        textViewContactInfo = findViewById(R.id.textViewContactInfo);
        textViewObj = findViewById(R.id.textViewObj);
        textViewEducation = findViewById(R.id.textViewEducation);
        textViewSkills = findViewById(R.id.textViewSkills);

        new GetHtmlTask().execute("https://joseconder.github.io/");
    }

    public void openWebsite(View view) {
        String url = "https://github.com/JoseConder";
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
                // Obtener la información correspondiente a cada sección
                String contactInfo = obtenerContenidoDespuesDeSeccion(document, "contact-info");
                String obj = obtenerContenidoDespuesDeSeccion(document, "exp");
                String education = obtenerContenidoDespuesDeSeccion(document, "education");
                String skills = obtenerContenidoDespuesDeSeccion(document, "skills");

                textViewContactInfo.setText(contactInfo);
                textViewObj.setText(obj);
                textViewEducation.setText(education);
                textViewSkills.setText(skills);
            } else {
                textViewContactInfo.setText("Error al obtener la información del enlace HTML.");
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
