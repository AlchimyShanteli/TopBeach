package com.topbeach.beachdetails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.topbeach.R;
import com.topbeach.adapters.BeachAdapter;

/**
 * Created by Alchimy on 6/11/2017.
 */

public class BeachDetails extends Activity {
    private TextView countryName;
    private TextView islandName;
    private TextView cityName;
    private TextView beachName;
    private  TextView beachDescription;
    private ImageView beachImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navagio_layout);

        countryName = (TextView) findViewById(R.id.countryName);
        islandName = (TextView) findViewById(R.id.islandName);
        cityName = (TextView) findViewById(R.id.cityName);
        beachName = (TextView) findViewById(R.id.beachName);
        beachDescription = (TextView) findViewById(R.id.beachDescription);
        beachImage = (ImageView) findViewById(R.id.beachImage);

        countryName.setText(getIntent().getStringExtra("country"));
        islandName.setText(getIntent().getStringExtra("island"));
        cityName.setText(getIntent().getStringExtra("city"));
        beachName.setText(getIntent().getStringExtra("beachName"));
        beachDescription.setText(getIntent().getStringExtra("beachDescription"));
        String imageUrl = getIntent().getStringExtra("image");

        Glide.with(this).load(imageUrl)
                .into(beachImage);

    }
    public void onBack(View v) {
        Intent intent = new Intent(this, BeachAdapter.class);
        startActivity(intent);
    }
}