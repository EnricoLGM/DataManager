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
        String risultato=i.getStringExtra("result");
        contenuto.setText(risultato);
    }
}