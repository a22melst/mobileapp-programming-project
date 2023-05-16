package com.example.mobileapp_programming_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<City> cities = new ArrayList<>(Arrays.asList(
        new City("hej", "hej", "hej", "hej", "hej"),
        new City("a", "b", "c", "d", "e")
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, cities, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(City item) {
                Toast.makeText(MainActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

    }
}