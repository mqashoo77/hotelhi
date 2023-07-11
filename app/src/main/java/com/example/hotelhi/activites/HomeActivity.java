package com.example.hotelhi.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.hotelhi.R;
import com.example.hotelhi.adapter.Hotel_RecyclerViewAdapter;
import com.example.hotelhi.adapter.RecyclerViewInterface;
import com.example.hotelhi.entity.Hotel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<Hotel> hotels;
    ImageView personalImage;
    Button getLuckyButton;
    RecyclerView recyclerView;
    ImageButton homeNavigationButton;
    ImageButton searchNavigationButton;
    ImageButton manageNavigationBookingButton;

    public void setNavigation() {
        homeNavigationButton = findViewById(R.id.homehomeNavigationBtn);
        searchNavigationButton = findViewById(R.id.homesearchNavigationBtn);
        manageNavigationBookingButton = findViewById(R.id.homeregisterNavigationBtn);
        homeNavigationButton.setImageResource(R.drawable.icons8_home_50__1_);
        homeNavigationButton.setBackgroundColor(Color.WHITE);


        searchNavigationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        manageNavigationBookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, BookingManagementActivity.class);
                startActivity(intent);
            }
        });


    }

    public void setItems() {
        personalImage = findViewById(R.id.homePersonalPhoto);
        getLuckyButton = findViewById(R.id.homeGetLuckyBtn);

        personalImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        getLuckyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, HotelDetailsActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.highRatedRecycler);
        setItems();
        setNavigation();
        hotels = new ArrayList<>();
        Hotel_RecyclerViewAdapter adapter = new Hotel_RecyclerViewAdapter(this, hotels, this);
        DatabaseReference refrerence = FirebaseDatabase.getInstance().getReference().child("Hotels");
        refrerence.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()) {
                    Hotel h = data.getValue(Hotel.class);
                    hotels.add(h);
                    System.out.println(h.getAddress().toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(HomeActivity.this, HotelDetailsActivity.class);
        intent.putExtra("Hotel_id", hotels.get(position).getHotelId());
        startActivity(intent);


    }
}