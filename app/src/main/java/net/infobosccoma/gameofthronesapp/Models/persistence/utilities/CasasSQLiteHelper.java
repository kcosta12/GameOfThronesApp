package net.infobosccoma.gameofthronesapp.Models.persistence.utilities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import net.infobosccoma.gameofthronesapp.R;

/**
 * Created by Kevin on 29/02/2016.
 */
public class CasasSQLiteHelper extends SQLiteOpenHelper {

    // Sentència SQL per crear la taula de Casas
    private final String SQL_CREATE_CASAS = "CREATE TABLE Casas(" +
            "codiCasa INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nomCasa TEXT, " +
            "lemaCasa TEXT)";

    // Sentència SQL per crear la taula de Personatges
    private final String SQL_CREATE_PERSONATGES = "CREATE TABLE Personatges(" +
            "codiPer INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nomPer TEXT, " +
            "descCurta TEXT, " +
            "descLlarga TEXT, " +
            "codiCasa INTEGER, " +
            "FOREIGN KEY(codiCasa) REFERENCES Casas(codiCasa))";
    private Context context;
    //Un altre string amb la query per crear la taula de personatges
    public CasasSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CASAS);
        db.execSQL(SQL_CREATE_PERSONATGES);
        db.execSQL("INSERT INTO Casas(nomCasa, lemaCasa) Values (?,?)", new String[]{context.getString(R.string.casa_stark),
                context.getString(R.string.lema_stark)});
        db.execSQL("INSERT INTO Casas(nomCasa, lemaCasa) Values (?,?)", new String[]{context.getString(R.string.casa_lanni),
                context.getString(R.string.lema_lanni)});
        db.execSQL("INSERT INTO Casas(nomCasa, lemaCasa) Values (?,?)", new String[]{context.getString(R.string.casa_bara),
                context.getString(R.string.lema_bara)});
        db.execSQL("INSERT INTO Casas(nomCasa, lemaCasa) Values (?,?)", new String[]{context.getString(R.string.casa_tyrell),
                context.getString(R.string.lema_tyrell)});
        db.execSQL("INSERT INTO Casas(nomCasa, lemaCasa) Values (?,?)", new String[]{context.getString(R.string.casa_grey),
                context.getString(R.string.lema_grey)});
        db.execSQL("INSERT INTO Casas(nomCasa, lemaCasa) Values (?,?)", new String[]{context.getString(R.string.casa_arryn),
                context.getString(R.string.lema_arryn)});
        db.execSQL("INSERT INTO Casas(nomCasa, lemaCasa) Values (?,?)", new String[]{context.getString(R.string.casa_bolton),
                context.getString(R.string.lema_bolton)});
        db.execSQL("INSERT INTO Personatges(nomPer, descCurta, descLlarga, codiCasa) VALUES(?,?,?,1)",
            new String[]{context.getString(R.string.eddardname),
                    context.getString(R.string.eddard_desc),
                    context.getString(R.string.eddard_desc_large),
                });
        db.execSQL("INSERT INTO Personatges(nomPer, descCurta, descLlarga, codiCasa) VALUES(?,?,?,2)",
                new String[]{context.getString(R.string.tywim_name),
                        context.getString(R.string.tywin_desc),
                        context.getString(R.string.tywin_desc_large),
                });
        db.execSQL("INSERT INTO Personatges(nomPer, descCurta, descLlarga, codiCasa) VALUES(?,?,?,3)",
                new String[]{context.getString(R.string.robert_name),
                        context.getString(R.string.robert_desc),
                        context.getString(R.string.robert_desc_large),
                });
        db.execSQL("INSERT INTO Personatges(nomPer, descCurta, descLlarga, codiCasa) VALUES(?,?,?,4)",
                new String[]{context.getString(R.string.mace_name),
                        context.getString(R.string.mace_desc),
                        context.getString(R.string.mace_desc_large),
                });
        db.execSQL("INSERT INTO Personatges(nomPer, descCurta, descLlarga, codiCasa) VALUES(?,?,?,5)",
                new String[]{context.getString(R.string.balon_name),
                        context.getString(R.string.balon_desc),
                        context.getString(R.string.balon_desc_large),
                });
        db.execSQL("INSERT INTO Personatges(nomPer, descCurta, descLlarga, codiCasa) VALUES(?,?,?,6)",
                new String[]{context.getString(R.string.jon_name),
                        context.getString(R.string.jon_desc),
                        context.getString(R.string.jon_desc_large),
                });
        db.execSQL("INSERT INTO Personatges(nomPer, descCurta, descLlarga, codiCasa) VALUES(?,?,?,7)",
                new String[]{context.getString(R.string.roose_name),
                        context.getString(R.string.roose_desc),
                        context.getString(R.string.roose_desc_large),
                });

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
