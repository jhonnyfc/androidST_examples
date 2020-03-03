package com.example.testlistmvc;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.testlistmvc.Modelos.InterestPoint;

import java.util.List;

public class MainListActivity extends ListActivity {

    private static final int SHOW_SUBACTIVITY = 1;

    ListView list;
    TravelPointsApplication tpa;
    ArrayAdapter<InterestPoint> todoItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = this.getListView();
        tpa = (TravelPointsApplication)getApplicationContext(); //Obtencion de los datos del modelo
        initializeList(tpa.pointList);                          //Inicializacion de los datos del modelo

        todoItemsAdapter = new ArrayAdapter<InterestPoint>(
                        this, R.layout.row_layout, R.id.listText, tpa.pointList);   //Array de vistas
        setListAdapter(todoItemsAdapter);           //Entregamos los datos a las vistas
    }

    public void initializeList(List<InterestPoint> aPointList) {
        InterestPoint aInterestPoint;
        Double latitud = 43.34343;
        Double longitud = 2.34343;

        for(int i=0; i<5; i++){
            aInterestPoint = new InterestPoint();
            aInterestPoint.setNombre("mismo nombre");
            aInterestPoint.setLatitud(latitud+i);
            aInterestPoint.setLongitud(longitud+i);
            aPointList.add(i,aInterestPoint);
        }
    }

}
