package net.infobosccoma.gameofthronesapp.Views.Impl.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.infobosccoma.gameofthronesapp.Models.Business.Entities.Personatge;
import net.infobosccoma.gameofthronesapp.R;

import java.util.ArrayList;

/**
 * Created by Kevin on 24/02/2016.
 */
class VistaDescripcio {
    public TextView descripcioPer;
}

public class DescripcioAdapter {
    public Activity context;
    public ArrayList<Personatge> dades;

    public DescripcioAdapter(Activity context, ArrayList<Personatge> dades) {
        this.context = context;
        this.dades = dades;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View element = convertView;
        VistaDescripcio vista;

        if (element == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            element = inflater.inflate(R.layout.content_third, null);

            vista = new VistaDescripcio();
            vista.descripcioPer = (TextView) element.findViewById(R.id.descripcio_large);

            element.setTag(vista);

        } else {
            vista = (VistaDescripcio) element.getTag();
        }

        vista.descripcioPer.setText(dades.get(position).getDescPersonatge());

        return element;
    }
}