package com.example.hotelhi.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.hotelhi.R;

public class SortActivity extends AppCompatActivity {

    ImageView backButton;
    LinearLayout lowestPrice;
    LinearLayout highestPrice;
    LinearLayout bestRated;
    LinearLayout distanceFromCityCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        backButton=findViewById(R.id.sortBckButton);
        lowestPrice=findViewById(R.id.sortLowestPrice);
        highestPrice=findViewById(R.id.sortHighestPrice);
        bestRated=findViewById(R.id.sortBestRated);
        distanceFromCityCenter=findViewById(R.id.sortDistanceFromCenter);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SortActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        lowestPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SortActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        highestPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SortActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        bestRated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SortActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        distanceFromCityCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SortActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });

    }
}