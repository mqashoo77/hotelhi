package com.example.hotelhi.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.hotelhi.R;
import com.example.hotelhi.adapter.Hotel_RecyclerViewAdapter;
import com.example.hotelhi.adapter.RecyclerViewInterface;
import com.example.hotelhi.entity.Hotel;

import java.util.ArrayList;
import java.util.Calendar;

public class SearchActivity extends AppCompatActivity implements RecyclerViewInterface {

    public ArrayList<Hotel> hotels;
    ConstraintLayout filterLayout;
    ConstraintLayout sortLayout;
    Button search;
    Button plus;
    Button negative;
    Button chickInButton;
    Button chickOutButton;
    ImageView personalImage;
    AutoCompleteTextView city;
    TextView numOfGuests;
    Spinner businessSpinner;
    DatePickerDialog datePicker;

    ImageButton homeNavigationButton;
    ImageButton searchNavigationButton;
    ImageButton manageNavigationBookingButton;


    public void setNavigation() {
        homeNavigationButton = findViewById(R.id.searchHomeNavigationBtn);
        searchNavigationButton = findViewById(R.id.searchSearchNavigationBtn);
        manageNavigationBookingButton = findViewById(R.id.searchRegisterNavigationBtn);
        searchNavigationButton.setImageResource(R.drawable.icons8_search_50);
        searchNavigationButton.setBackgroundColor(Color.WHITE);


        homeNavigationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        manageNavigationBookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, BookingManagementActivity.class);
                startActivity(intent);
            }
        });


    }

    public void setChickOutButton() {
        final Calendar calendar = Calendar.getInstance();


        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        datePicker = new DatePickerDialog(SearchActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                // adding the selected date in the edittext
                if (chickInButton.getText().equals("Pick Date")) {
                    chickInButton.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    chickOutButton.setTextColor(Color.BLACK);
                } else {
                    chickOutButton.setTextColor(Color.BLACK);
                    chickOutButton.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                }

            }
        }, year, month, day);

        // set maximum date to be selected as today


        // show the dialog
        datePicker.show();

    }

    public void setChickInButton() {
        final Calendar calendar = Calendar.getInstance();


        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        datePicker = new DatePickerDialog(SearchActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                // adding the selected date in the edittext
                chickInButton.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                chickOutButton.setTextColor(Color.BLACK);


            }
        }, year, month, day);

        // set maximum date to be selected as today


        // show the dialog
        datePicker.show();

    }

    public void setButtons() {


        personalImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, ProfileActivity.class);
                startActivity(intent);

            }
        });
        chickOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChickOutButton();

            }
        });
        chickInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChickInButton();

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentNumberStr = numOfGuests.getText().toString();
                int currentNumber = Integer.parseInt(currentNumberStr);
                int newNumber = currentNumber + 1;
                numOfGuests.setText(String.valueOf(newNumber));

            }
        });
        negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentNumberStr = numOfGuests.getText().toString();
                int currentNumber = Integer.parseInt(currentNumberStr);
                if (currentNumber > 1) {
                    int newNumber = currentNumber - 1;
                    numOfGuests.setText(String.valueOf(newNumber));
                }
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        sortLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, SortActivity.class);
                startActivity(intent);
            }
        });

        filterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, FilterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setItems() {
        final Calendar calendar = Calendar.getInstance();
        datePicker = new DatePickerDialog(SearchActivity.this);


        filterLayout = findViewById(R.id.searchFilterLayout);
        sortLayout = findViewById(R.id.searchSortLayout);
        city = findViewById(R.id.cityAutoCompleteTextView);
        numOfGuests = findViewById(R.id.guestsNumber);
        businessSpinner = findViewById(R.id.businessSpinner);
        chickInButton = findViewById(R.id.idBtnPickDateChickIn);
        chickOutButton = findViewById(R.id.idBtnPickDateChickout);
        personalImage = findViewById(R.id.searchPesonalPhoto);
        search = findViewById(R.id.searchButton);
        plus = findViewById(R.id.btnPlus);
        negative = findViewById(R.id.btnMinus);

        String[] options = {"Yes", "No"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        businessSpinner.setAdapter(adapter);
        businessSpinner.setSelection(1);
        numOfGuests.setText("1");

        setButtons();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewSearch);
        setItems();
        setNavigation();

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

        Hotel_RecyclerViewAdapter adapter = new Hotel_RecyclerViewAdapter(this, hotels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(SearchActivity.this, HotelDetailsActivity.class);
        intent.putExtra("Hotel_id", hotels.get(position).getHotelId());
        startActivity(intent);

    }

}