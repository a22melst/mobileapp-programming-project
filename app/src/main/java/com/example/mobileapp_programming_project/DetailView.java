package com.example.mobileapp_programming_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailView extends AppCompatActivity {

    private ImageView img;
    private TextView cityNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        img = findViewById(R.id.imageViewDetail);
        cityNameView = findViewById(R.id.cityName);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String imgURL = extras.getString("ImgURL");
            String cityName = extras.getString("CityName");
            String population = extras.getString("Population");
            String wiki = extras.getString("WikiURL");

            Picasso.get().load(imgURL).into(img);
            cityNameView.setText(cityName);
        }
    }
}