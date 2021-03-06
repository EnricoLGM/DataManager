package com.example.datamanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner genere;
    EditText titolo;
    EditText autore;
    EditText durata;
    EditText dataUscita;
    Button salva;
    Button leggi;
    String generi[]={"Rock", "Metal", "Pop", "KPop", "Classica", "Fristad Rock", "Rap"};

    String stringa;

    final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genere=(Spinner)findViewById(R.id.genere);
        titolo=(EditText)findViewById(R.id.titolo);
        autore=(EditText)findViewById(R.id.autore);
        durata=(EditText)findViewById(R.id.durata);
        dataUscita=(EditText)findViewById(R.id.dataUscita);
        salva=(Button)findViewById(R.id.salva);
        leggi=(Button)findViewById(R.id.leggi);

        ArrayAdapter<String> adapterSongs=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, generi);
        genere.setAdapter(adapterSongs);
        GestioneBrani g=new GestioneBrani();
        GestioneFile gF=new GestioneFile();

        /*salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.addBrano(titolo.getEditableText().toString(), autore.getEditableText().toString(), durata.getEditableText().toString(), dataUscita.getEditableText().toString(), genere.getSelectedItem().toString());
                Toast.makeText(getApplicationContext(), "Brano Aggiunto", Toast.LENGTH_LONG).show();
                Log.d(TAG, "Ho salvato il brano");
            }
        });*/
        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.addBrano(titolo.getEditableText().toString(), autore.getEditableText().toString(), durata.getEditableText().toString(), dataUscita.getEditableText().toString(), genere.getSelectedItem().toString());
                gF.writeFile("brani.txt", getApplicationContext(), g.listaCanzoni());
                Toast.makeText(getApplicationContext(), "Brano Aggiunto", Toast.LENGTH_LONG).show();
                Log.d(TAG, "Ho salvato il brano");
            }
        });
/*        leggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), SongData.class);
                stringa=g.listaCanzoni().toString();
                i.putExtra("result", stringa);
                startActivity(i);
            }
        });*/
        /*leggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringa=gF.leggiRawFile(getApplicationContext());
                Intent i=new Intent(getApplicationContext(), SongData.class);
                i.putExtra("result", stringa);
                startActivity(i);
            }
        });*/
        leggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringa=gF.readFile("brani.txt", getApplicationContext());
                if(stringa=="") {
                    stringa="Non sono stati aggiunti dei brani";
                }
                Intent i=new Intent(getApplicationContext(), SongData.class);
                i.putExtra("result", stringa);
                startActivity(i);
            }
        });
    }
}