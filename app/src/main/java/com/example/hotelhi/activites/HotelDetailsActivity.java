package com.example.hotelhi.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotelhi.R;
import com.example.hotelhi.entity.Hotel;
import com.example.hotelhi.service.HotelService;


public class HotelDetailsActivity extends AppCompatActivity {
    ImageView backHotel;
    TextView hotelName1;
    TextView hotelName2;
    TextView hotelCityText;
    TextView hotelRatingText;
    TextView hotelNumRatingText;
    TextView hotelPriceText;
    Button hotelChooseRoomBtn;

    Hotel hotel;

    void setItems() {
        backHotel = findViewById(R.id.hotelBackBtn);
        hotelName1 = findViewById(R.id.hotelNameText1);
        hotelName2 = findViewById(R.id.hotelNameText2);
        hotelCityText = findViewById(R.id.hotelCityText);
        hotelRatingText = findViewById(R.id.hotelRatingText);
        hotelNumRatingText = findViewById(R.id.hotelNumOfRatingsText);
        hotelPriceText = findViewById(R.id.priceHotelText);
        hotelChooseRoomBtn = findViewById(R.id.hotelRoomBtn);
        hotelName2.setText(hotel.getName());
        hotelName1.setText(hotel.getName());
        hotelCityText.setText(hotel.getCity());
        hotelRatingText.setText(Double.toString(hotel.getRatings()));
        hotelNumRatingText.setText(Integer.toString(hotel.getNumOfRatings()));

        hotelChooseRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HotelDetailsActivity.this, RoomBookingActivity.class);
                intent.putExtra("Hotel_id", hotel.getHotelId());
                startActivity(intent);
            }
        });
        backHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HotelDetailsActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);
        Intent intent=getIntent();
        int hotelId = intent.getIntExtra("Hotel_id", 1);
        hotel=HotelService.getHotelById(hotelId);
        setItems();


    }
}