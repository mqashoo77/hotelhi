package com.example.hotelhi.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

    public void storePrefSort(String s) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("sort", s);
        editor.apply();
    }

    public void makeBold() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String sort = sharedPreferences.getString("sort", "");
        System.out.println(sort);
        if (sort.equals("distance_from_center")) {
            distanceFromCityCenter.setBackgroundResource(R.drawable.black_circler_selected);
        } else if (sort.equals("best_rated")) {
            bestRated.setBackgroundResource(R.drawable.black_circler_selected);
        } else if (sort.equals("lowest_price")) {
            lowestPrice.setBackgroundResource(R.drawable.black_circler_selected);
        } else if (sort.equals("highest_price")) {
            highestPrice.setBackgroundResource(R.drawable.black_circler_selected);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        backButton = findViewById(R.id.sortBckButton);
        lowestPrice = findViewById(R.id.sortLowestPrice);
        highestPrice = findViewById(R.id.sortHighestPrice);
        bestRated = findViewById(R.id.sortBestRated);
        distanceFromCityCenter = findViewById(R.id.sortDistanceFromCenter);
        makeBold();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SortActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        lowestPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storePrefSort("lowest_price");

                Intent intent = new Intent(SortActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        highestPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storePrefSort("highest_price");

                Intent intent = new Intent(SortActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        bestRated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storePrefSort("best_rated");

                Intent intent = new Intent(SortActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        distanceFromCityCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storePrefSort("distance_from_center");
                Intent intent = new Intent(SortActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

    }
}