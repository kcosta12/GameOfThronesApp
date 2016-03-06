package net.infobosccoma.gameofthronesapp.Views.Impl.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import net.infobosccoma.gameofthronesapp.Models.Business.Entities.Personatge;
import net.infobosccoma.gameofthronesapp.R;

import org.parceler.Parcels;

public class ThirdActivity extends AppCompatActivity {

    private String descripcio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Personatge dades = Parcels.unwrap(getIntent().getParcelableExtra("Descripcio"));
        crearDescripcioPersonatge(dades);

        TextView textView = (TextView) findViewById(R.id.descripcio_large);
        textView.setText(descripcio);
        setTitle(dades.getNomPersonatge());

        registerForContextMenu(textView);
    }

    private void crearDescripcioPersonatge(Personatge dades) {
        descripcio = dades.getDescLargePersonatge();
    }
}
