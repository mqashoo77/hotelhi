package com.example.hotelhi.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotelhi.R;
import com.example.hotelhi.entity.User;
import com.example.hotelhi.service.HotelService;

public class ProfileActivity extends AppCompatActivity {
    User user;
    TextView name1,name2,number,email,country;
    ImageView image;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name1=findViewById(R.id.profileName1);
        name2=findViewById(R.id.profileName2);
        number=findViewById(R.id.profileNumber);
        email=findViewById(R.id.profileEmail);
        country=findViewById(R.id.profileCountry);
        image=findViewById(R.id.profilePicture);
        backBtn=findViewById(R.id.profileBackBtn);
        SharedPreferences sharedPreferences=getSharedPreferences("myPrefs",MODE_PRIVATE);
        int id=sharedPreferences.getInt("user_id",1);
        user= HotelService.getUserById(1);
        name2.setText(user.getFirstName()+" "+user.getLastName());
        name1.setText(user.getFirstName()+" "+user.getLastName());
        number.setText(user.getPhoneNumber());
        email.setText(user.getEmail());
        country.setText(user.getCountry());
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Invoke default back button behavior
            }
        });

    }
}