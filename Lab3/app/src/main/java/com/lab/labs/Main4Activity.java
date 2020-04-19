package com.lab.labs;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main4Activity extends AppCompatActivity {
    private String[] names = new String[]
            {"One","Two","Three","Four","Five","Six"};
    private int imgId = R.drawable.ic_launcher_background;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        List<Map<String,Object>> listItems = new ArrayList<>();
        for (int i = 0;i < names.length;i++){
            Map<String,Object> listItem = new HashMap<>();
            listItem.put("img",imgId);
            listItem.put("name",names[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,
                R.layout.t4_content,
                new String[] {"name","img"},
                new int[] {R.id.name,R.id.img1});
        ListView list = findViewById(R.id.list_view);
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(Main4Activity.this,names[position],Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        ListView listView = findViewById(R.id.list_view);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {

            }
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.t4_menu, menu);
                return true;
            }
            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // Here you can perform updates to the CAB due to
                // an <code><a href="/reference/android/view/ActionMode.html#invalidate()">invalidate()</a></code> request
                return false;
            }
        });
    }
}