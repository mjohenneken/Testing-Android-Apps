package com.anderscore.frosconsample;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;

public class MainActivity extends ListActivity {


    private TextView steveCount;
    private Button addButton;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        steveCount = new TextView(this);
        steveCount.setTextAppearance(this, R.style.Base_TextAppearance_AppCompat_Display1);
        getListView().addHeaderView(steveCount);

        addButton = new Button(this);
        addButton.setTextAppearance(this, R.style.TextAppearance_AppCompat_Button);
        addButton.setText("Add Steve");
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model.getInstance().addItem("Steve");
                adapter.notifyDataSetChanged();
                updateSteveCount();
            }
        });
        getListView().addFooterView(addButton);

        updateSteveCount();

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, Model.getInstance().getData());
        setListAdapter(adapter);
    }

    private void updateSteveCount() {
        int count = Collections.frequency(Model.getInstance().getData(), "Steve");
        steveCount.setText("Steve kommt " + count + " mal vor!");
    }


}
