package com.example.hotelhi.adapter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotelhi.R;
import com.example.hotelhi.activites.RoomBookingActivity;
import com.example.hotelhi.activites.SearchActivity;
import com.example.hotelhi.entity.Booking;
import com.example.hotelhi.entity.Room;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class RoomAdapter extends BaseAdapter {
    private ArrayList<Room> rooms;
    private Context context;

    public RoomAdapter(Context context, ArrayList<Room> rooms) {
        this.context = context;
        this.rooms = rooms;
    }

    @Override
    public int getCount() {
        return rooms.size();
    }

    @Override
    public Object getItem(int position) {
        return rooms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.room_layout, null);
        }

        ImageView imageView = view.findViewById(R.id.roomViewImage);
        TextView typeTextView = view.findViewById(R.id.roomViewType);
        TextView descriptionTextView = view.findViewById(R.id.roomViewDescription);
        TextView priceTextView = view.findViewById(R.id.roomViewPrice);
        TextView priceBreakfastTextView = view.findViewById(R.id.roomViewPriceBreakfast);
        Button choose = view.findViewById(R.id.roomViewButton);
        Button chooseBreakfast = view.findViewById(R.id.roomViewBreakfastButton);
        double price = rooms.get(position).getPricePerNight();
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", MODE_PRIVATE);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int guestId = 1;
        Date checkInDate = new Date(sharedPreferences.getLong("in_date", 0));
        Date checkOutDate = new Date(sharedPreferences.getLong("out_date", 0));
        int numOfGuests = sharedPreferences.getInt("num_of_guests", 1);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Booking booking = new Booking(0, guestId, rooms.get(position).getRoomId(), checkInDate, checkOutDate, numOfGuests, price, "Done", "keep door open");
                Intent intent = new Intent(context, SearchActivity.class);
                context.startActivity(intent);
            }
        });
        chooseBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Booking booking = new Booking(0, guestId, rooms.get(position).getRoomId(), checkInDate, checkOutDate, numOfGuests, price * 1.20, "Done", "keep door open");
                Intent intent = new Intent(context, SearchActivity.class);
                context.startActivity(intent);
            }
        });


        chooseBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Booking booking = new Booking(0, guestId, rooms.get(position).getRoomId(), checkInDate, checkOutDate, numOfGuests, price * .2, "Done", "keep door open");

                Intent intent = new Intent(context, SearchActivity.class);
                context.startActivity(intent);
            }
        });
        // Set data for the views
        Room room = rooms.get(position);
        imageView.setImageResource(R.drawable.iyvyne9jloqdphuk3gcp);
        typeTextView.setText(room.getRoomType());
        descriptionTextView.setText(room.getDescription());
        priceTextView.setText(String.valueOf(room.getPricePerNight()));
        priceBreakfastTextView.setText(String.valueOf(room.getPricePerNight() * 1.2));

        return view;
    }
}
