package com.example.hotelhi.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.hotelhi.service.HotelService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

    public void clear() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("sort");
        editor.remove("stars");
        editor.remove("from_price");
        editor.remove("to_price");
        editor.apply();
    }

    public Date stringToDate(String date) {
        String[] dateArray = date.split("/");
        int year, month, day;
        year = Integer.parseInt(dateArray[2]);
        month = Integer.parseInt(dateArray[1]);
        day = Integer.parseInt(dateArray[0]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); // Subtract 1 from the month value to account for zero-based indexing

        Date returnDate = calendar.getTime();
        return returnDate;

    }

    public void setSearchBtn() {
        String cityName = city.getText().toString();
        int numberOfGuests = Integer.parseInt(numOfGuests.getText().toString());
        String chickInDate = chickInButton.getText().toString();
        String chickOut = chickOutButton.getText().toString();
        if (cityName.equals("") || numberOfGuests == 0 || chickOut.equals("Pick Date") || chickInDate.equals("Pick Date")) {
            return;
        }

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String nameOfCity = sharedPreferences.getString("city", null);
        if (cityName != null) {
            if (!cityName.equals(nameOfCity)) {
                clear();
            }
        } else {
            return;
        }
        Date in = stringToDate(chickInDate);
        Date out = stringToDate(chickOut);
        int comparisonResult = in.compareTo(out);
        if (!(comparisonResult < 0)) {
            return;
        }
        String sort = sharedPreferences.getString("sort", "");
        int priceFrom = sharedPreferences.getInt("from_price", 0);
        int toPrice = sharedPreferences.getInt("to_price", 10000);
        int stars = sharedPreferences.getInt("stars", 0);
        hotels = HotelService.filterHotel(in, out, cityName, numberOfGuests, stars, sort, priceFrom, toPrice);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("city", cityName);
        editor.putInt("num_of_guests", numberOfGuests);
        long dateInMillis = in.getTime();
        editor.putLong("in_date", dateInMillis);
        dateInMillis = out.getTime();
        editor.putLong("out_date", dateInMillis);
        editor.apply();


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
                setSearchBtn();

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
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("MyActivityPrefs", MODE_PRIVATE);
        numOfGuests.setText(sharedPreferences.getString("numOfGuests", "1"));
        chickInButton.setText(sharedPreferences.getString("dateIn", "Pick Date"));
        chickOutButton.setText(sharedPreferences.getString("dateOut", "Pick Date"));
        city.setText(sharedPreferences.getString("city", ""));
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getSharedPreferences("MyActivityPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("numOfGuests", numOfGuests.getText().toString());
        editor.putString("dateIn", chickInButton.getText().toString());
        editor.putString("dateOut", chickOutButton.getText().toString());
        editor.putString("city", city.getText().toString());
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewSearch);
        setItems();
        setNavigation();
        hotels = HotelService.getHotels();
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