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
        rooms=new ArrayList<>();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RoomBookingActivity.this,HotelDetailsActivity.class);
                startActivity(intent);
            }
        });

        {
            rooms.add(new Room(1, 1, "101", "Standard Room", 2, 50.0, "Available", "room_image1", "This is a cozy room with a comfortable bed."));

            rooms.add(new Room(2, 1, "102", "Deluxe Room", 2, 80.0, "Available", "room_image2", "Experience luxury and elegance in this spacious room."));

            rooms.add(new Room(3, 2, "201", "Suite Room", 4, 150.0, "Available", "room_image3", "Indulge yourself in this luxurious suite with stunning views."));

            rooms.add(new Room(4, 2, "202", "Superior Room", 2, 100.0, "Available", "room_image4", "Enjoy a comfortable stay in this modern and stylish room."));

            rooms.add(new Room(5, 3, "301", "Family Room", 4, 120.0, "Available", "room_image5", "Ideal for families, this room offers spacious accommodation."));

            rooms.add(new Room(6, 3, "302", "Executive Suite", 2, 200.0, "Available", "room_image6", "Experience the ultimate luxury in this exquisite suite."));

            rooms.add(new Room(7, 4, "401", "Penthouse Suite", 2, 500.0, "Available", "room_image7", "Indulge in the lavishness of the penthouse suite with panoramic views."));

            rooms.add(new Room(8, 4, "402", "Business Room", 2, 150.0, "Available", "room_image8", "Stay productive in this well-equipped business room."));

            rooms.add(new Room(9, 5, "501", "Garden View Room", 2, 90.0, "Available", "room_image9", "Enjoy the serene views of the hotel's lush garden from this room."));

            rooms.add(new Room(10, 5, "502", "Honeymoon Suite", 2, 250.0, "Available", "room_image10", "Celebrate your special moments in this romantic honeymoon suite."));
        }
        listView.setMinimumHeight(rooms.size()*150);
        RoomAdapter adapter = new RoomAdapter(this, rooms); // roomList is a List<Room> containing your data
        listView.setAdapter(adapter);

    }
}