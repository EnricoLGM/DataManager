package com.example.datamanager;

import java.util.ArrayList;

public class GestioneBrani {
    ArrayList<Brano> lista=new ArrayList<>();

    public GestioneBrani() {
        this.lista=new ArrayList<Brano>();
    }

    public void addBrano(String t, String a, String d, String du, String g) {
        Brano b=new Brano(t,a,d,du,g);
        lista.add(b);
    }

    public void addBrano(Brano b) {
        lista.add(b);
    }

    public String listaCanzoni(){
        StringBuilder sb = new StringBuilder();
        for(Brano b: lista){
            sb.append(b.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
