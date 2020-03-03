package com.example.testlist;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainListActivity extends ListActivity {

    private static final int SHOW_SUBACTIVITY = 1;
    ListView list;
    public List<String> pointList = new ArrayList<>();
    ArrayAdapter<String> todoItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Creacion de la vista inicial

        list = this.getListView();
        initializeList(pointList);

        todoItemsAdapter = new ArrayAdapter<String>(    //Creacion de las vistas
                    this, R.layout.row_layout, R.id.listText, pointList);
        setListAdapter(todoItemsAdapter);
    }

    public void initializeList(List<String> aPointList) {
        for(int i=0; i<5; i++){
            aPointList.add(i,"mismo lugar");
        }
    }
}
