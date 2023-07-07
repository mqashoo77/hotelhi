package com.example.hotelhi.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hotelhi.R;

public class FilterActivity extends AppCompatActivity {

    ImageView backButton;
    int stars=0;
    EditText fromPrice;
    EditText toPrice;
    LinearLayout tenStars;
    LinearLayout nineStars;
    LinearLayout eightStars;
    LinearLayout sevenStars;
    LinearLayout sixStars;
    LinearLayout wifiFilter;
    Boolean wifiSelected=false;
    LinearLayout breakfastFilter;
    Boolean breakfastSelected=false;

    LinearLayout barFilter;
    Boolean barSelected=false;

    LinearLayout luggageFilter;
    Boolean luggageSelected=false;

    LinearLayout airFilter;
    Boolean airSelected=false;

    LinearLayout swimmingFilter;
    Boolean swimmingSelected=false;

    LinearLayout lockersFilter;
    Boolean lockersSelected=false;

    TextView clearAll;
    Button applyFilter;
    public void setButtons(){
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FilterActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        sixStars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenStars.setBackgroundResource(R.drawable.black_circler_container);
                nineStars.setBackgroundResource(R.drawable.black_circler_container);
                eightStars.setBackgroundResource(R.drawable.black_circler_container);
                sevenStars.setBackgroundResource(R.drawable.black_circler_container);
                sixStars.setBackgroundResource(R.drawable.black_circler_selected);
                stars=6;
            }
        });
        sevenStars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenStars.setBackgroundResource(R.drawable.black_circler_container);
                nineStars.setBackgroundResource(R.drawable.black_circler_container);
                eightStars.setBackgroundResource(R.drawable.black_circler_container);
                sixStars.setBackgroundResource(R.drawable.black_circler_container);
                sevenStars.setBackgroundResource(R.drawable.black_circler_selected);
                stars=7;
            }
        });
        eightStars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenStars.setBackgroundResource(R.drawable.black_circler_container);
                nineStars.setBackgroundResource(R.drawable.black_circler_container);
                eightStars.setBackgroundResource(R.drawable.black_circler_container);
                sevenStars.setBackgroundResource(R.drawable.black_circler_container);
                sixStars.setBackgroundResource(R.drawable.black_circler_selected);
                stars=8;
            }
        });
        nineStars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenStars.setBackgroundResource(R.drawable.black_circler_container);
                sixStars.setBackgroundResource(R.drawable.black_circler_container);
                eightStars.setBackgroundResource(R.drawable.black_circler_container);
                sevenStars.setBackgroundResource(R.drawable.black_circler_container);
                nineStars.setBackgroundResource(R.drawable.black_circler_selected);
                stars=9;
            }
        });
        tenStars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sixStars.setBackgroundResource(R.drawable.black_circler_container);
                nineStars.setBackgroundResource(R.drawable.black_circler_container);
                eightStars.setBackgroundResource(R.drawable.black_circler_container);
                sevenStars.setBackgroundResource(R.drawable.black_circler_container);
                tenStars.setBackgroundResource(R.drawable.black_circler_selected);
                stars=10;
            }
        });
        lockersFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lockersSelected){
                    lockersSelected=false;
                    lockersFilter.setBackgroundResource(R.drawable.black_circler_container);

                }
                else{
                    lockersSelected=true;
                    lockersFilter.setBackgroundResource(R.drawable.black_circler_selected);
                }
            }
        });
        wifiFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wifiSelected){
                    wifiSelected=false;
                    wifiFilter.setBackgroundResource(R.drawable.black_circler_container);

                }
                else{
                    wifiSelected=true;
                    wifiFilter.setBackgroundResource(R.drawable.black_circler_selected);
                }
            }
        });
        breakfastFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(breakfastSelected){
                    breakfastSelected=false;
                    breakfastFilter.setBackgroundResource(R.drawable.black_circler_container);

                }
                else{
                    breakfastSelected=true;
                    breakfastFilter.setBackgroundResource(R.drawable.black_circler_selected);
                }
            }
        });
        barFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(barSelected){
                    barSelected=false;
                    barFilter.setBackgroundResource(R.drawable.black_circler_container);

                }
                else{
                    barSelected=true;
                    barFilter.setBackgroundResource(R.drawable.black_circler_selected);
                }
            }
        });
        luggageFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(luggageSelected){
                    luggageSelected=false;
                    luggageFilter.setBackgroundResource(R.drawable.black_circler_container);

                }
                else{
                    luggageSelected=true;
                    luggageFilter.setBackgroundResource(R.drawable.black_circler_selected);
                }
            }
        });
        airFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(airSelected){
                    airSelected=false;
                    airFilter.setBackgroundResource(R.drawable.black_circler_container);

                }
                else{
                    airSelected=true;
                    airFilter.setBackgroundResource(R.drawable.black_circler_selected);
                }
            }
        });
        swimmingFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(swimmingSelected){
                    swimmingSelected=false;
                    swimmingFilter.setBackgroundResource(R.drawable.black_circler_container);

                }
                else{
                    swimmingSelected=true;
                    swimmingFilter.setBackgroundResource(R.drawable.black_circler_selected);
                }
            }
        });
        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wifiFilter.setBackgroundResource(R.drawable.black_circler_container);
                breakfastFilter.setBackgroundResource(R.drawable.black_circler_container);
                barFilter.setBackgroundResource(R.drawable.black_circler_container);
                luggageFilter.setBackgroundResource(R.drawable.black_circler_container);
                airFilter.setBackgroundResource(R.drawable.black_circler_container);
                swimmingFilter.setBackgroundResource(R.drawable.black_circler_container);
                lockersFilter.setBackgroundResource(R.drawable.black_circler_container);
                tenStars.setBackgroundResource(R.drawable.black_circler_container);
                nineStars.setBackgroundResource(R.drawable.black_circler_container);
                eightStars.setBackgroundResource(R.drawable.black_circler_container);
                sevenStars.setBackgroundResource(R.drawable.black_circler_container);
                sixStars.setBackgroundResource(R.drawable.black_circler_container);
                stars=0;
                wifiSelected=false;
                breakfastSelected=false;
                barSelected=false;
                luggageSelected=false;
                airSelected=false;
                swimmingSelected=false;
                lockersSelected=false;
                toPrice.setText("10000");
                fromPrice.setText("0");


            }
        });
        applyFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FilterActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
    }
    public void setItems(){
        toPrice.setText("10000");
        fromPrice.setText("0");
        clearAll=findViewById(R.id.filterClearText);
        applyFilter=findViewById(R.id.filterApplyButton);
        wifiFilter=findViewById(R.id.filterWifi);
        breakfastFilter=findViewById(R.id.filterBreakfast);
        barFilter=findViewById(R.id.filterBar);
        luggageFilter=findViewById(R.id.filterLauggage);
        airFilter=findViewById(R.id.filterAir);
        swimmingFilter=findViewById(R.id.filterSwimming);
        lockersFilter=findViewById(R.id.filterLocker);
        tenStars=findViewById(R.id.filterTenStars);
        nineStars=findViewById(R.id.filterNineStars);
        eightStars=findViewById(R.id.filterEightStars);
        sevenStars=findViewById(R.id.filterSevenStars);
        sixStars=findViewById(R.id.filterSixStars);
        toPrice=findViewById(R.id.filterToPrice);
        fromPrice=findViewById(R.id.filterFromPrice);
        backButton=findViewById(R.id.filterBckButton);
        setButtons();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
    }
}