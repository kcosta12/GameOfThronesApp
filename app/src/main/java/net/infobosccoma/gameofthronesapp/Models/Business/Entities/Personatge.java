package net.infobosccoma.gameofthronesapp.Models.Business.Entities;

import org.parceler.Parcel;

import java.io.Serializable;

/**
 * Created by Kevin on 16/02/2016.
 */
@Parcel
public class Personatge implements Serializable {

    private String nomPersonatge;
    private String descPersonatge;
    private String descLargePersonatge;
    private String idCasa;
    private int idCodiPer;

    public Personatge() {
    }

    public Personatge(String nomPersonatge, String descPersonatge, String descLargePersonatge, String idCasa) {
        this.nomPersonatge = nomPersonatge;
        this.descPersonatge = descPersonatge;
        this.descLargePersonatge = descLargePersonatge;
        this.idCasa = idCasa;
    }

    public String getNomPersonatge() {
        return nomPersonatge;
    }

    public void setNomPersonatge(String nomPersonatge) {
        this.nomPersonatge = nomPersonatge;
    }

    public String getDescPersonatge() {
        return descPersonatge;
    }

    public void setDescPersonatge(String descPersonatge) {
        this.descPersonatge = descPersonatge;
    }

    public String getDescLargePersonatge() {
        return descLargePersonatge;
    }

    public void setDescLargePersonatge(String descLargePersonatge) {
        this.descLargePersonatge = descLargePersonatge;
    }

    public String getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(String idCasa) {
        this.idCasa = idCasa;
    }

    public int getIdCodiPer() {
        return idCodiPer;
    }

    public void setIdCodiPer(int idCodiPer) {
        this.idCodiPer = idCodiPer;
    }
}
