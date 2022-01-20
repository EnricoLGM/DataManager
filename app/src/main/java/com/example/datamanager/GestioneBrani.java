package com.example.datamanager;

import java.util.ArrayList;

public class GestioneBrani {
    ArrayList<Brano> lista=new ArrayList<>();

    public GestioneBrani(ArrayList<Brano> lista) {
        this.lista = lista;
    }

    public void addBrano(Brano b) {
        lista.add(b);
    }
}
