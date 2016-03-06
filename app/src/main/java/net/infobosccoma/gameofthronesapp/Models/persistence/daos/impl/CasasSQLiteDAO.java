package net.infobosccoma.gameofthronesapp.Models.persistence.daos.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.infobosccoma.gameofthronesapp.Models.Business.Entities.Casa;
import net.infobosccoma.gameofthronesapp.Models.Business.Entities.Personatge;
import net.infobosccoma.gameofthronesapp.Models.persistence.daos.interfaces.CasasDAO;
import net.infobosccoma.gameofthronesapp.Models.persistence.utilities.SQLiteUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 29/02/2016.
 */
public class CasasSQLiteDAO implements CasasDAO {

    private Context context;

    public CasasSQLiteDAO(Context context) {
        this.context = context;
    }

    @Override
    public Casa getById(int id) {

        Casa casa = null;

        SQLiteDatabase conn = SQLiteUtils.getConnetion(context);
        Cursor result = conn.query(true, "Casas",
                new String[]{"codiCasa", "nomCasa", "lemaCasa"}, "codiCasa = ?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        casa = SQLiteUtils.getCasa(result);

        conn.close();
        return casa;
    }

    @Override
    public ArrayList<Casa> getAll() {
        ArrayList<Casa> casas = new ArrayList<>();

        SQLiteDatabase conn = SQLiteUtils.getConnetion(context);
        Cursor result = conn.query(true, "Casas",
                new String[]{"codiCasa", "nomCasa", "lemaCasa"},
                null,null,null,null,null,null);

        while (result.moveToNext()){
            casas.add(SQLiteUtils.getCasa(result));
        }
        conn.close();
        return casas;
    }

    public ArrayList<Personatge> getAllPersonatges(String codi){
        ArrayList<Personatge> personatges = new ArrayList<>();

        SQLiteDatabase conn = SQLiteUtils.getConnetion(context);
        Cursor result = conn.rawQuery(
                "select codiPer, nomPer, descCurta, descLlarga, codiCasa FROM Personatges WHERE codiCasa = ?",
                new String[]{
                        codi
                }
        );

        while (result.moveToNext()){
            personatges.add(SQLiteUtils.getPersonatge(result));
        }

        conn.close();
        return personatges;
    }

    @Override
    public boolean save(Casa casa) {
        ContentValues dades = new ContentValues();
        SQLiteDatabase conn = SQLiteUtils.getConnetion(context);

        dades.put("codiCasa", casa.getCodi());
        dades.put("nomCasa", casa.getNomCasa());
        dades.put("lemaCasa", casa.getLema());

        try{
            long codi = conn.insertOrThrow("Casas", null, dades);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Casa casa) {
        return false;
    }

    @Override
    public boolean delete(Casa casa) {
        return false;
    }
}
