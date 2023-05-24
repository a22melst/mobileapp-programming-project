package com.example.mobileapp_programming_project;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22melst";
    private RecyclerViewAdapter adapter;
    private SharedPreferences prefShowImages, prefShowCityNames;
    private SharedPreferences.Editor prefEditorImg, prefEditorCity;
    private Gson gson = new Gson();
    private ArrayList<City> cities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefShowImages = getPreferences(MODE_PRIVATE);
        prefShowCityNames = getPreferences(MODE_PRIVATE);
        prefEditorImg = prefShowImages.edit();
        prefEditorCity = prefShowCityNames.edit();

        boolean showImages = prefShowImages.getBoolean("Images", true);
        boolean showCityNames = prefShowCityNames.getBoolean("CityNames", true);

        adapter = new RecyclerViewAdapter(this, cities, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(City city) {
                openDetailView(city);
            }
        },showImages, showCityNames);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                openAboutPage();
                return true;
            case R.id.toggleImages:
                adapter.toggleHideImages();
                adapter.notifyDataSetChanged();
                prefEditorImg.putBoolean("Images", adapter.getShowImages());
                prefEditorImg.apply();
                return true;
            case R.id.toggleCityNames:
                adapter.toggleHideCityNames();
                adapter.notifyDataSetChanged();
                prefEditorCity.putBoolean("CityNames", adapter.getShowCityNames());
                prefEditorCity.apply();
                return true;
            default: return super.onOptionsItemSelected(item);

        }


    }

    public void openDetailView(City city) {
        Intent intent = new Intent(this, DetailView.class);
        intent.putExtra("ImgURL", city.getImgURL());
        intent.putExtra("CityName", city.getName());
        intent.putExtra("Country", city.getCountry());
        intent.putExtra("Population", city.getPopulation());
        intent.putExtra("WikiURL", city.getWikiURL());
        startActivity(intent);
    }

    public void openAboutPage() {
        Intent intent = new Intent(this, AboutPage.class);
        startActivity(intent);
    }

}