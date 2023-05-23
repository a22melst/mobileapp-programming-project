package com.example.mobileapp_programming_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22melst";
    private RecyclerViewAdapter adapter;
    private Gson gson = new Gson();
    private ArrayList<City> cities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar custombar = findViewById(R.id.custombar);
        setSupportActionBar(custombar);

        adapter = new RecyclerViewAdapter(this, cities, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(City city) {
                Toast.makeText(MainActivity.this, city.getName(), Toast.LENGTH_SHORT).show();
                openDetailView(city);
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

    public void openDetailView(City city) {
        Intent intent = new Intent(this, DetailView.class);
        intent.putExtra("ImgURL", city.getImgURL());
        intent.putExtra("CityName", city.getName());
        intent.putExtra("Population", city.getPopulation());
        intent.putExtra("Wiki", city.getWikiURL());
        intent.putExtra("Country", city.getCountry());
        startActivity(intent);
    }
}