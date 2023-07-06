package com.example.hotelhi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hotelhi.R;
import com.example.hotelhi.entity.Hotel;
import java.util.ArrayList;

public class Hotel_RecyclerViewAdapter extends RecyclerView.Adapter<Hotel_RecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<Hotel> hotels;

    public Hotel_RecyclerViewAdapter(Context context, ArrayList<Hotel> hotels) {
        this.context = context;
        this.hotels = hotels;
    }


    @NonNull
    @Override
    public Hotel_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new Hotel_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Hotel_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.name.setText(hotels.get(position).getName());
        holder.distance.setText(Integer.toString(hotels.get(position).getDistanceFromCenter()));
        holder.rating.setText(Double.toString(hotels.get(position).getRatings()));
        double rating = hotels.get(position).getRatings();
        String score = "Bad";
        if (rating >= 9) {
            score = "Suburb";
        } else if (rating >= 8) {
            score = "Fabulous";
        } else if (rating > 7) {
            score = "Very Good";
        } else if (rating > 6) {
            score = "Good";
        }
        holder.score.setText(score);
        holder.numberOfRatings.setText("("+Integer.toString(hotels.get(position).getNumOfRatings())+")");

    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        TextView rating;
        TextView score;
        TextView price;
        TextView distance;
        TextView numberOfRatings;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.hotelNameText);
            rating = itemView.findViewById(R.id.ratingText);
            score = itemView.findViewById(R.id.scoreText);
            price = itemView.findViewById(R.id.priceText);
            distance = itemView.findViewById(R.id.distanceFromCenterText);
            numberOfRatings = itemView.findViewById(R.id.reviewsNumberText);
        }
    }
}
