package com.example.datamanager;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        leggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), SongData.class);
                i.putExtra("title", titolo.getEditableText().toString());
                i.putExtra("author", autore.getEditableText().toString());
                i.putExtra("duration", durata.getEditableText().toString());
                i.putExtra("date", dataUscita.getEditableText().toString());
                i.putExtra("genre", genere.getSelectedItem().toString());
                startActivity(i);
            }
        });
    }
}