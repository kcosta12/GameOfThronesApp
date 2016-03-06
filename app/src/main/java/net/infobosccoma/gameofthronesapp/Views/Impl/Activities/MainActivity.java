package net.infobosccoma.gameofthronesapp.Views.Impl.Activities;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import net.infobosccoma.gameofthronesapp.Models.Business.Entities.Casa;
import net.infobosccoma.gameofthronesapp.Models.Business.Entities.Personatge;
import net.infobosccoma.gameofthronesapp.Models.persistence.daos.impl.CasasSQLiteDAO;
import net.infobosccoma.gameofthronesapp.R;
import net.infobosccoma.gameofthronesapp.Views.Impl.Adapters.CasaAdapter;

import org.parceler.Parcels;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private CasaAdapter adapterList;
    private ArrayList<Casa> llistaCasa;
    final int intent_request = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.deleteDatabase("Casas.db");
        crearLlistaCasa();
        ListView listView = (ListView) findViewById(R.id.main_list);

        adapterList = new CasaAdapter(this, llistaCasa);
        listView.setAdapter(adapterList);
        listView.setOnItemClickListener(this);

        registerForContextMenu(listView);
    }

    private void crearLlistaCasa() {
        llistaCasa = new ArrayList<>();
        CasasSQLiteDAO casasSQLiteDAO = new CasasSQLiteDAO(getBaseContext());
        llistaCasa = casasSQLiteDAO.getAll();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent = new Intent(this, SecondActivity.class);
        Casa casa = (Casa) adapterView.getItemAtPosition(position);

        intent.putExtra("Personatges", Parcels.wrap(casa));

        startActivityForResult(intent, intent_request);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
