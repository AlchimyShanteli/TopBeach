package com.topbeach.beachdetails;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
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
    private LinearLayout beachDetailContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach_details);

        countryName = (TextView) findViewById(R.id.countryName);
        islandName = (TextView) findViewById(R.id.islandName);
        cityName = (TextView) findViewById(R.id.cityName);
        beachName = (TextView) findViewById(R.id.beachName);
        beachDescription = (TextView) findViewById(R.id.beachDescription);
        beachImage = (ImageView) findViewById(R.id.beachImage);
        beachDetailContainer = (LinearLayout) findViewById(R.id.beachDetailContainer);

        countryName.setText(getIntent().getStringExtra("country"));
        islandName.setText(getIntent().getStringExtra("island"));
        cityName.setText(getIntent().getStringExtra("city"));
        beachName.setText(getIntent().getStringExtra("beachName"));
        beachDescription.setText(getIntent().getStringExtra("beachDescription"));
        String imageUrl = getIntent().getStringExtra("image");

        Glide.with(this).load(imageUrl)
                .into(beachImage);

        Glide.with(this).load(imageUrl)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        Palette palette = Palette.from(resource).generate();
                        beachDetailContainer.setBackgroundColor(palette
                                .getLightMutedColor(ContextCompat.getColor(BeachDetails.this, R.color.colorAccent)));
                    }
                });


    }
    public void onBack(View v) {
        Intent intent = new Intent(this, BeachAdapter.class);
        startActivity(intent);
    }
}
