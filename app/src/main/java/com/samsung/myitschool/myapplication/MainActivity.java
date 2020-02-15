package com.samsung.myitschool.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> states;
    MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        states = new ArrayList<>();
        states.add("США");
        states.add("Россия");
        states.add("Германия");
        states.add("Франция");
        states.add("Португалия");

        RecyclerView recyclerView = findViewById(R.id.recyclerStates);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyAdapter(this,states);
        recyclerView.setAdapter(mAdapter);

        ExtendedFloatingActionButton btn_add = findViewById(R.id.floatingActionButton);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> items = new ArrayList<>();
                items.add("ОАЭ");
                items.add("Египет");
                items.add("Марокко");
                states.addAll(items);
                mAdapter.notifyItemRangeInserted(states.size(),items.size());
            }
        });


    }

}
