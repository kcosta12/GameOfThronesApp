package net.infobosccoma.gameofthronesapp.Views.Impl.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.infobosccoma.gameofthronesapp.Models.Business.Entities.Casa;
import net.infobosccoma.gameofthronesapp.R;

import java.util.ArrayList;

/**
 * Created by Kevin on 15/02/2016.
 */

class Vista{
    public TextView casa;
    public TextView lema;
}
public class CasaAdapter extends ArrayAdapter {

    public Activity context;
    public ArrayList<Casa> dades;

    public CasaAdapter(Activity context, ArrayList<Casa> dades){
        super(context, R.layout.main_layout, dades);
        this.context = context;
        this.dades = dades;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View element = convertView;
        Vista vista;

        if (element == null){
            LayoutInflater inflater = context.getLayoutInflater();
            element = inflater.inflate(R.layout.main_layout, null);

            vista = new Vista();
            vista.casa = (TextView)element.findViewById(R.id.main_layout_nomCasa);
            vista.lema = (TextView)element.findViewById(R.id.main_layout_lema);

            element.setTag(vista);
        }
        else {
            vista = (Vista)element.getTag();
        }
        vista.casa.setText(dades.get(position).getNomCasa());
        vista.lema.setText(dades.get(position).getLema());

        return element;
    }
}
