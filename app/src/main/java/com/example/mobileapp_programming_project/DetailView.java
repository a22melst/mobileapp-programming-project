package com.example.mobileapp_programming_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
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
            countryView.setText(getString(R.string.country) + ": " + country);
            populationView.setText(getString(R.string.population) + ": " + population);

            SpannableString spannableString = new SpannableString(wikiURL);
            ClickableSpan span = new ClickableSpan() {
                @Override
                public void onClick(@NonNull View widget) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(wikiURL));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                @Override
                public void updateDrawState(@NonNull TextPaint ds) {
                    ds.setColor(Color.BLUE);
                    ds.setUnderlineText(true);
                }
            };

            spannableString.setSpan(span, 0, wikiURL.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            wikiURLView.setText(spannableString);
            wikiURLView.setMovementMethod(LinkMovementMethod.getInstance());

        }






    }
}