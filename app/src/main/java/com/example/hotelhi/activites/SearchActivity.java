package com.example.hotelhi.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.hotelhi.R;
import com.example.hotelhi.adapter.Hotel_RecyclerViewAdapter;
import com.example.hotelhi.adapter.RecyclerViewInterface;
import com.example.hotelhi.entity.Hotel;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<Hotel> hotels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        hotels = new ArrayList<>();

        {
            hotels.add(new Hotel(1, "Hilton London Metropole", "225 Edgware Road", "London", "United Kingdom", "+44 20 7402 4141", "info@hiltonlondonmet.com", "main_image_a.jpg", 2, 500, 8.4));

            hotels.add(new Hotel(2, "Marriott Marquis Times Square", "1535 Broadway", "New York", "United States", "+1 212-398-1900", "info@marriottmarquis.com", "main_image_b.jpg", 5, 200, 7.9));

            hotels.add(new Hotel(3, "Ritz Paris", "15 Place Vendôme", "Paris", "France", "+33 1 43 16 30 30", "info@ritzparis.com", "main_image_c.jpg", 4, 150, 9.2));

            hotels.add(new Hotel(4, "Burj Al Arab Jumeirah", "Jumeirah Beach Road", "Dubai", "United Arab Emirates", "+971 4 301 7777", "info@burjalarab.com", "main_image_d.jpg", 5, 180, 7.8));

            hotels.add(new Hotel(5, "Tokyo Station Hotel", "1-9-1 Marunouchi", "Tokyo", "Japan", "+81 3-5220-1111", "info@tokyostationhotel.com", "main_image_e.jpg", 2, 120, 8.5));

            hotels.add(new Hotel(6, "Hotel Adlon Kempinski", "Unter den Linden 77", "Berlin", "Germany", "+49 30 2261 0", "info@hoteladlon.com", "main_image_f.jpg", 3, 90, 7.2));

            hotels.add(new Hotel(7, "Hotel del Coronado", "1500 Orange Ave", "Coronado", "United States", "+1 619-435-6611", "info@hoteldel.com", "main_image_g.jpg", 4, 200, 9.5));
        }

        Hotel_RecyclerViewAdapter adapter=new Hotel_RecyclerViewAdapter(this,hotels,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(SearchActivity.this,HotelDetailsActivity.class);
        intent.putExtra("Hotel_id",hotels.get(position).getHotelId());
        startActivity(intent);

    }
}