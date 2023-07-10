package com.example.hotelhi.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.hotelhi.R;
import com.example.hotelhi.adapter.BookingsAdapter;
import com.example.hotelhi.entity.Booking;
import com.example.hotelhi.entity.Hotel;
import com.example.hotelhi.entity.Room;
import com.example.hotelhi.service.HotelService;

import java.util.List;

public class BookingManagementActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BookingsAdapter adapter;
    private List<Booking> bookings;
    private List<Room> rooms;
    private List<Hotel> hotels;
    ImageButton homeNavigationButton;
    ImageButton searchNavigationButton;
    ImageButton manageNavigationBookingButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_management);
        setNavigation();

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerViewBooking);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the lists of bookings, rooms, and hotels
        bookings = getBookingsFromDatabase();
        rooms = getRoomsFromDatabase();
        hotels = getHotelsFromDatabase();

        // Create and set the adapter
        adapter = new BookingsAdapter(bookings, rooms, hotels);
        recyclerView.setAdapter(adapter);

    }

    private List<Hotel> getHotelsFromDatabase() {
        // MOMEN -> Qashoo: return all hotels
        return HotelService.getHotels();
    }

    private List<Room> getRoomsFromDatabase() {
        // MOMEN -> Qashoo: you can return all rooms here
        return HotelService.getHotelRooms(0);
    }

    private List<Booking> getBookingsFromDatabase() {
        // MOMEN -> Qashoo: this should only get bookings of the user that is logged in
        return HotelService.getBookingsForUser(1);
    }

    public void setNavigation() {
        homeNavigationButton = findViewById(R.id.bookingHomeNavigationBtn);
        searchNavigationButton = findViewById(R.id.bookingSearchNavigationBtn);
        manageNavigationBookingButton = findViewById(R.id.bookingRegisterNavigationBtn);
        manageNavigationBookingButton.setImageResource(R.drawable.icons8_register_50);
        manageNavigationBookingButton.setBackgroundColor(Color.WHITE);


        searchNavigationButton.setOnClickListener(view -> {
            Intent intent = new Intent(BookingManagementActivity.this, SearchActivity.class);
            startActivity(intent);
        });
        homeNavigationButton.setOnClickListener(view -> {
            Intent intent = new Intent(BookingManagementActivity.this, HomeActivity.class);
            startActivity(intent);
        });


    }
}