package net.infobosccoma.gameofthronesapp.Models.Business.Entities;

import org.parceler.Parcel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Kevin on 15/02/2016.
 */
@Parcel
public class Casa {

    private String nomCasa;
    private String lema;
    private ArrayList<Personatge> llistaPersonatge;
    private Personatge personatge;
    private int codi;

    public Casa() {

    }

    public Casa(String nomCasa, String lema, ArrayList<Personatge> llistaPersonatge) {
        this.nomCasa = nomCasa;
        this.lema = lema;
        this.llistaPersonatge = llistaPersonatge;
    }

    public Personatge getPersonatge() {
        return personatge;
    }

    public ArrayList<Personatge> getLlistaPersonatge() {
        return llistaPersonatge;
    }

    public void setLlistaPersonatge(ArrayList<Personatge> llistaPersonatge) {
        this.llistaPersonatge = llistaPersonatge;
    }

    public void setNomCasa(String nomCasa) {
        this.nomCasa = nomCasa;
    }

    public String getNomCasa() {
        return nomCasa;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    public String getLema() {
        return lema;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }
}
