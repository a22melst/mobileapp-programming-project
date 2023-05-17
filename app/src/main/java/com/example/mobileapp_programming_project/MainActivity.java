package com.example.mobileapp_programming_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22melst";
    private RecyclerViewAdapter adapter;
    private Gson gson = new Gson();
    private ArrayList<City> cities = new ArrayList<>(Arrays.asList(
        new City("hej", "hej", 1, "hej", "hej"),
        new City("a", "b", 2, "d", "e")
    ));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar custombar = findViewById(R.id.custombar);
        setSupportActionBar(custombar);

        adapter = new RecyclerViewAdapter(this, cities, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(City item) {
                Toast.makeText(MainActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

        new JsonTask(this).execute(JSON_URL);

    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
        Type type = new TypeToken<ArrayList<City>>() {}.getType();
        cities = gson.fromJson(json, type);
        adapter.setItems(cities);
        adapter.notifyDataSetChanged();

    }
}