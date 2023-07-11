package com.example.hotelhi.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

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
    ImageView personalImage;
    private Thread databaseThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_management);
        setNavigation();
        personalImage = findViewById(R.id.homePersonalPhoto);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerViewBooking);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();

        // Start a new thread to retrieve the lists from the database
        databaseThread = new Thread(() -> {
            // Retrieve the lists of bookings, rooms, and hotels
            List<Booking> fetchedBookings = getBookingsFromDatabase();
            List<Room> fetchedRooms = getRoomsFromDatabase();
            List<Hotel> fetchedHotels = getHotelsFromDatabase();

            // Update the UI on the main thread
            runOnUiThread(() -> {
                // Update the member variables with the retrieved lists
                bookings = fetchedBookings;
                rooms = fetchedRooms;
                hotels = fetchedHotels;

                // Update the adapter with the retrieved lists
                adapter = new BookingsAdapter(bookings, rooms, hotels);
                recyclerView.setAdapter(adapter);
            });
        });

        // Start the database thread
        databaseThread.start();
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Interrupt and join the database thread to gracefully stop it
        if (databaseThread != null) {
            databaseThread.interrupt();
            try {
                databaseThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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