package net.infobosccoma.gameofthronesapp.Views.Impl.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import net.infobosccoma.gameofthronesapp.Models.Business.Entities.Personatge;
import net.infobosccoma.gameofthronesapp.R;

import java.util.ArrayList;

/**
 * Created by Kevin on 16/02/2016.
 */

class VistaPersonatge{
    private String nomPersonatge;
    private String descPersonatge;
}
public class PersonatgeAdapter extends ArrayAdapter{
    public Activity context;
    public ArrayList<Personatge> dades;

    public PersonatgeAdapter(Activity context, ArrayList<Personatge> dades){
        super(context, R.layout.activity_second_layout, dades);
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
        vista.casa.setText(dades.get(position).getNomPersonatge());
        vista.lema.setText(dades.get(position).getDescPersonatge());

        return element;
    }
}
