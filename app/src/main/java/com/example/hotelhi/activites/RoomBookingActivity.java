package com.example.hotelhi.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.hotelhi.R;
import com.example.hotelhi.adapter.RoomAdapter;
import com.example.hotelhi.entity.Room;
import com.example.hotelhi.service.HotelService;

import java.util.ArrayList;

public class RoomBookingActivity extends AppCompatActivity {
    ArrayList<Room> rooms;
    ImageView backButton;
    TextView hotelName;
    TextView hotelLocation;
    ListView listView;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_booking);
        backButton = findViewById(R.id.roomBackButton);
        hotelName = findViewById(R.id.roomHotelName);
        hotelLocation = findViewById(R.id.roomHotelLocation);
        listView = findViewById(R.id.roomListView);
        //ScrollView=findViewById(R.id.scrollChangeSize);
        rooms = new ArrayList<>();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomBookingActivity.this, HotelDetailsActivity.class);
                startActivity(intent);
            }
        });

        Intent intent=getIntent();
        int hotelId=intent.getIntExtra("hotel_id",1);
        rooms= HotelService.getHotelRooms(hotelId);
        listView.setMinimumHeight(rooms.size() * 150);
        RoomAdapter adapter = new RoomAdapter(this, rooms); // roomList is a List<Room> containing your data
        listView.setAdapter(adapter);

    }
}