package com.example.testlistsubactivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainListActivity extends ListActivity {

    private static final int SHOW_SUBACTIVITY = 1;
    private static final int NUMBER_ACTIVITIES = 5;

    ListView list;
    public List<String> pointList = new ArrayList<>();
    ArrayAdapter<String> todoItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeList(pointList);
        list = this.getListView();

        todoItemsAdapter = new ArrayAdapter<String>(this, R.layout.row_layout, R.id.listText, pointList);
        setListAdapter(todoItemsAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) list.getItemAtPosition(position);

                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                bundle.putString("name", item);

                Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
                intent.putExtras(bundle);

                startActivityForResult(intent, SHOW_SUBACTIVITY);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();

            int position = bundle.getInt("position");
            String name = bundle.getString("name");

            //String item = (String) list.getItemAtPosition(position);
            //item = name;

            pointList.set(position,name);
            todoItemsAdapter.notifyDataSetChanged();
        }
    }

    public void initializeList(List<String> aPointList) {
        for(int i=0; i<NUMBER_ACTIVITIES; i++){
            aPointList.add(i,"mismo lugar "+i);
        }
    }
}
