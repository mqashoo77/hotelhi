package com.example.hotelhi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelhi.R;
import com.example.hotelhi.entity.Booking;
import com.example.hotelhi.entity.Hotel;
import com.example.hotelhi.entity.Room;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

// BookingsAdapter.java
public class BookingsAdapter extends RecyclerView.Adapter<BookingsAdapter.ViewHolder> {
    private List<Booking> bookings;
    private List<Room> rooms;
    private List<Hotel> hotels;

    public BookingsAdapter(List<Booking> bookings, List<Room> rooms, List<Hotel> hotels) {
        this.bookings = bookings;
        this.rooms = rooms;
        this.hotels = hotels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Booking booking = bookings.get(position);

        // Get room details based on the roomId
        Room room = getRoomById(booking.getRoomId());
        if (room != null) {
            holder.txtHotelName.setText(getHotelName(room.getHotelId()));
            holder.txtRoomDescription.setText(room.getDescription());
        }

        // Set booking details
        holder.txtArriveDate.setText(formatDate(booking.getCheckInDate()));
        holder.txtLeaveDate.setText(formatDate(booking.getCheckOutDate()));
        holder.txtPrice.setText(String.format(Locale.getDefault(), "%.2f$", booking.getTotalPrice()));

        holder.btnCancel.setOnClickListener(v -> {
            int adapterPosition = holder.getAdapterPosition();
            if (adapterPosition != RecyclerView.NO_POSITION) {
                Booking booking1 = bookings.get(adapterPosition);
                removeBooking(booking1);
                bookings.remove(adapterPosition);
                notifyItemRemoved(adapterPosition);
            }
        });
    }

    private void removeBooking(Booking booking1) {
        //remove from database
    }

    @Override
    public int getItemCount() {
        return bookings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageRoom;
        public TextView txtHotelName;
        public TextView txtRoomDescription;
        public TextView txtArriveDate;
        public TextView txtLeaveDate;
        public TextView txtPrice;
        public Button btnCancel;

        public ViewHolder(View itemView) {
            super(itemView);
            imageRoom = itemView.findViewById(R.id.imageRoomBooking);
            txtHotelName = itemView.findViewById(R.id.txtHotelNameBooking);
            txtRoomDescription = itemView.findViewById(R.id.txtRoomDescriptionBooking);
            txtArriveDate = itemView.findViewById(R.id.txtArriveDateBooking);
            txtLeaveDate = itemView.findViewById(R.id.txtLeaveDateBooking);
            txtPrice = itemView.findViewById(R.id.txtPriceBooking);
            btnCancel = itemView.findViewById(R.id.btnCancelBooking);
        }
    }

    private Room getRoomById(int roomId) {
        for (Room room : rooms) {
            if (room.getRoomId() == roomId) {
                return room;
            }
        }
        return null;
    }

    private String getHotelName(int hotelId) {
        for (Hotel hotel : hotels) {
            if (hotel.getHotelId() == hotelId) {
                return hotel.getName();
            }
        }
        return "";
    }

    private String formatDate(Date date) {
        // Format the date as needed
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());
        return sdf.format(date);
    }
}
