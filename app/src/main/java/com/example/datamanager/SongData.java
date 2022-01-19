package com.example.datamanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SongData extends AppCompatActivity {
    TextView contenuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_data);
        contenuto=(TextView)findViewById(R.id.contenuto);
        Intent i=getIntent();
        String titolo=i.getStringExtra("title");
        String autore=i.getStringExtra("author");
        String durata=i.getStringExtra("duration");
        String data=i.getStringExtra("date");
        String genere=i.getStringExtra("genre");
        contenuto.setText("La canzone "+titolo+", che come autore ha "+autore+", dura "+durata+" minuti ed è stata pubblicata il giorno "+data+" inoltre è di genere "+genere);
    }
}