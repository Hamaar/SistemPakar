package com.example.hilmi.sistempakar.models;

import java.io.Serializable;


public class Gejala implements Serializable {
    private int id;
    private String gid,gejala;

    public Gejala(int id, String gid, String gejala) {
        this.id = id;
        this.gid = gid;
        this.gejala = gejala;
    }

//    public Gejala( String gejala) {
//
//        this.gejala = gejala;
//    }
    public Gejala( String kode_gejala, String gejala) {

        this.gejala = gejala;
        this.gid = gejala;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGejala() {
        return gejala;
    }

    public void setGejala(String gejala) {
        this.gejala = gejala;
    }
}
