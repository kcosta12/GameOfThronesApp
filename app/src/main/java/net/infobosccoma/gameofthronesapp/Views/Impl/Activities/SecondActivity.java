package net.infobosccoma.gameofthronesapp.Views.Impl.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import net.infobosccoma.gameofthronesapp.Models.Business.Entities.Casa;
import net.infobosccoma.gameofthronesapp.Models.Business.Entities.Personatge;
import net.infobosccoma.gameofthronesapp.Models.persistence.daos.impl.CasasSQLiteDAO;
import net.infobosccoma.gameofthronesapp.R;
import net.infobosccoma.gameofthronesapp.Views.Impl.Adapters.PersonatgeAdapter;

import org.parceler.Parcels;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private PersonatgeAdapter adapterList;
    private ArrayList<Personatge> llistaPersonatge;
    final int intent_request = 1;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Casa dades = Parcels.unwrap(getIntent().getParcelableExtra("Personatges"));

        int codi = dades.getCodi();
        crearLlistaPersonatges(codi);

        ListView listView = (ListView) findViewById(R.id.second_list);

        adapterList = new PersonatgeAdapter(this, llistaPersonatge);
        listView.setAdapter(adapterList);
        listView.setOnItemClickListener(this);

        registerForContextMenu(listView);
    }

    private void crearLlistaPersonatges(int codi) {
        String codiId = String.valueOf(codi);
        llistaPersonatge = new ArrayList<>();
        CasasSQLiteDAO casasSQLiteDAO = new CasasSQLiteDAO(getBaseContext());
        llistaPersonatge = casasSQLiteDAO.getAllPersonatges(codiId);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(this, ThirdActivity.class);
        Personatge personatge = (Personatge) adapterView.getItemAtPosition(position);

        intent.putExtra("Descripcio", Parcels.wrap(personatge));

        startActivityForResult(intent, intent_request);
    }
}
