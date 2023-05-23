package com.example.mobileapp_programming_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailView extends AppCompatActivity {

    private ImageView img;
    private TextView cityNameView, countryView, populationView, wikiURLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        img = findViewById(R.id.imageViewDetail);
        cityNameView = findViewById(R.id.cityName);
        countryView = findViewById(R.id.country);
        populationView = findViewById(R.id.population);
        wikiURLView = findViewById(R.id.wikiURL);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String imgURL = extras.getString("ImgURL");
            String cityName = extras.getString("CityName");
            String country = extras.getString("Country");
            String population = extras.getString("Population");
            String wikiURL = extras.getString("WikiURL");

            Picasso.get().load(imgURL).into(img);
            cityNameView.setText(cityName);
            countryView.setText("Country: " + country);
            populationView.setText("Population: " + population);
            wikiURLView.setText("Wikipedia: " + wikiURL);

        }
    }
}