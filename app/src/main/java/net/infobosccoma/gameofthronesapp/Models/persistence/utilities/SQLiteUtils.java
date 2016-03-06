package net.infobosccoma.gameofthronesapp.Models.persistence.utilities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.infobosccoma.gameofthronesapp.Models.Business.Entities.Casa;
import net.infobosccoma.gameofthronesapp.Models.Business.Entities.Personatge;

import java.security.PublicKey;

/**
 * Created by Kevin on 29/02/2016.
 */
public class SQLiteUtils {

    static final String NOM_DB = "Casas.db";
    static final int VERSION_DB = 1;

    public static SQLiteDatabase getConnetion(Context context){
        return  new CasasSQLiteHelper(context, NOM_DB, null, VERSION_DB).getWritableDatabase();
    }

    public static Casa getCasa(Cursor reader){
        Casa casa = new Casa();

        casa.setCodi(reader.getInt(reader.getColumnIndex("codiCasa")));
        casa.setNomCasa(reader.getString(reader.getColumnIndex("nomCasa")));
        casa.setLema(reader.getString(reader.getColumnIndex("lemaCasa")));

        return casa;
    }

    public static Personatge getPersonatge(Cursor reader){
        Personatge personatge = new Personatge();

        personatge.setIdCodiPer(reader.getInt(reader.getColumnIndex("codiPer")));
        personatge.setNomPersonatge(reader.getString(reader.getColumnIndex("nomPer")));
        personatge.setDescPersonatge(reader.getString(reader.getColumnIndex("descCurta")));
        personatge.setDescLargePersonatge(reader.getString(reader.getColumnIndex("descLlarga")));
        personatge.setIdCasa(reader.getString(reader.getColumnIndex("codiCasa")));

        return personatge;
    }
}
