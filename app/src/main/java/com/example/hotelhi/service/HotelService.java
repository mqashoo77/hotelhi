package com.example.hotelhi.service;

import androidx.annotation.NonNull;

import com.example.hotelhi.entity.Booking;
import com.example.hotelhi.entity.Hotel;
import com.example.hotelhi.entity.Room;
import com.example.hotelhi.entity.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.concurrent.TimeUnit;

public class HotelService {

    public static User getUserById(int id){
        /**
         * easey please implement
         */
        User user=new User(1,"Mohammed","Buirat","Palestine","0594056401",
                "mohammadberat@yahoo.com","");
        return user;
    }

    public static ArrayList<Hotel> getHotels(){
        ArrayList<Hotel>hotels=new ArrayList<>();
//        {
//            hotels.add(new Hotel(1, "Hilton London Metropole", "225 Edgware Road", "London", "United Kingdom", "+44 20 7402 4141", "info@hiltonlondonmet.com", "main_image_a.jpg", 2, 500, 8.4));
//
//            hotels.add(new Hotel(2, "Marriott Marquis Times Square", "1535 Broadway", "New York", "United States", "+1 212-398-1900", "info@marriottmarquis.com", "main_image_b.jpg", 5, 200, 7.9));
//
//            hotels.add(new Hotel(3, "Ritz Paris", "15 Place Vendôme", "Paris", "France", "+33 1 43 16 30 30", "info@ritzparis.com", "main_image_c.jpg", 4, 150, 9.2));
//
//            hotels.add(new Hotel(4, "Burj Al Arab Jumeirah", "Jumeirah Beach Road", "Dubai", "United Arab Emirates", "+971 4 301 7777", "info@burjalarab.com", "main_image_d.jpg", 5, 180, 7.8));
//
//            hotels.add(new Hotel(5, "Tokyo Station Hotel", "1-9-1 Marunouchi", "Tokyo", "Japan", "+81 3-5220-1111", "info@tokyostationhotel.com", "main_image_e.jpg", 2, 120, 8.5));
//
//            hotels.add(new Hotel(6, "Hotel Adlon Kempinski", "Unter den Linden 77", "Berlin", "Germany", "+49 30 2261 0", "info@hoteladlon.com", "main_image_f.jpg", 3, 90, 7.2));
//
//            hotels.add(new Hotel(7, "Hotel del Coronado", "1500 Orange Ave", "Coronado", "United States", "+1 619-435-6611", "info@hoteldel.com", "main_image_g.jpg", 4, 200, 9.5));
//        }


        return hotels;
    }
    public static Hotel getHotelById(int id){
        Hotel h = new Hotel();
        DatabaseReference refrerence = FirebaseDatabase.getInstance().getReference().child("Hotels").child(Integer.toString(id));
        refrerence.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Hotel h = snapshot.getValue(Hotel.class);
                System.out.println(h.getName());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return h;
    }
    public static ArrayList<Room> getHotelRooms(int id){
        ArrayList<Room>rooms=new ArrayList<>();
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
        return rooms;
    }

    public static void bookRoom(Booking booking){
        /**easy insert a booking but need some modifiactions*/
        long timeDiff = booking.getCheckOutDate().getTime() - booking.getCheckOutDate().getTime();

        long daysDifference = TimeUnit.MILLISECONDS.toDays(timeDiff);
        booking.setTotalPrice(booking.getTotalPrice()*daysDifference);
        //insert booking
    }

    public static ArrayList<Hotel>filterHotel(Date chickIn,Date chickOut,String city,int numOfGuests,int stars,String sort,int priceFrom,int priceTo){
        /******
         *
         *
         * very complex if possible first get all the rooms that can take more than the number of guests
         * then where priceFrom pernight >=pricefrom and max <=to then city=city then
         * then take from that the rooms that are not booked in the dates from chick in to chick out day by day then we want if sort !=""
         * order by the sort
         */


        ArrayList<Hotel>hotels=new ArrayList<>();
//        {
//            hotels.add(new Hotel(1, "Hilton London Metropole", "225 Edgware Road", "London", "United Kingdom", "+44 20 7402 4141", "info@hiltonlondonmet.com", "main_image_a.jpg", 2, 500, 8.4));
//
//            hotels.add(new Hotel(2, "Marriott Marquis Times Square", "1535 Broadway", "New York", "United States", "+1 212-398-1900", "info@marriottmarquis.com", "main_image_b.jpg", 5, 200, 7.9));
//
//            hotels.add(new Hotel(3, "Ritz Paris", "15 Place Vendôme", "Paris", "France", "+33 1 43 16 30 30", "info@ritzparis.com", "main_image_c.jpg", 4, 150, 9.2));
//
//            hotels.add(new Hotel(4, "Burj Al Arab Jumeirah", "Jumeirah Beach Road", "Dubai", "United Arab Emirates", "+971 4 301 7777", "info@burjalarab.com", "main_image_d.jpg", 5, 180, 7.8));
//
//            hotels.add(new Hotel(5, "Tokyo Station Hotel", "1-9-1 Marunouchi", "Tokyo", "Japan", "+81 3-5220-1111", "info@tokyostationhotel.com", "main_image_e.jpg", 2, 120, 8.5));
//
//            hotels.add(new Hotel(6, "Hotel Adlon Kempinski", "Unter den Linden 77", "Berlin", "Germany", "+49 30 2261 0", "info@hoteladlon.com", "main_image_f.jpg", 3, 90, 7.2));
//
//            hotels.add(new Hotel(7, "Hotel del Coronado", "1500 Orange Ave", "Coronado", "United States", "+1 619-435-6611", "info@hoteldel.com", "main_image_g.jpg", 4, 200, 9.5));
//        }


        return hotels;

    }
    public static ArrayList<Hotel> getBestHotels(){

        /****************************
         *
         *
         * get the best 5 hotels in term of ratings (highest 5 rating hotels)
         */

        ArrayList<Hotel>hotels=new ArrayList<>();
//        {
//            hotels.add(new Hotel(1, "Hilton London Metropole", "225 Edgware Road", "London", "United Kingdom", "+44 20 7402 4141", "info@hiltonlondonmet.com", "main_image_a.jpg", 2, 500, 8.4));
//
//            hotels.add(new Hotel(2, "Marriott Marquis Times Square", "1535 Broadway", "New York", "United States", "+1 212-398-1900", "info@marriottmarquis.com", "main_image_b.jpg", 5, 200, 7.9));
//
//            hotels.add(new Hotel(3, "Ritz Paris", "15 Place Vendôme", "Paris", "France", "+33 1 43 16 30 30", "info@ritzparis.com", "main_image_c.jpg", 4, 150, 9.2));
//
//            hotels.add(new Hotel(4, "Burj Al Arab Jumeirah", "Jumeirah Beach Road", "Dubai", "United Arab Emirates", "+971 4 301 7777", "info@burjalarab.com", "main_image_d.jpg", 5, 180, 7.8));
//
//            hotels.add(new Hotel(5, "Tokyo Station Hotel", "1-9-1 Marunouchi", "Tokyo", "Japan", "+81 3-5220-1111", "info@tokyostationhotel.com", "main_image_e.jpg", 2, 120, 8.5));
//
//            hotels.add(new Hotel(6, "Hotel Adlon Kempinski", "Unter den Linden 77", "Berlin", "Germany", "+49 30 2261 0", "info@hoteladlon.com", "main_image_f.jpg", 3, 90, 7.2));
//
//            hotels.add(new Hotel(7, "Hotel del Coronado", "1500 Orange Ave", "Coronado", "United States", "+1 619-435-6611", "info@hoteldel.com", "main_image_g.jpg", 4, 200, 9.5));
//        }


        return hotels;
    }
    public static ArrayList<Hotel> getByCity(String s){


        /*************
         * get the hotel with the given city name
         */
        ArrayList<Hotel>hotels=new ArrayList<>();
//        {
//            hotels.add(new Hotel(1, "Hilton London Metropole", "225 Edgware Road", "London", "United Kingdom", "+44 20 7402 4141", "info@hiltonlondonmet.com", "main_image_a.jpg", 2, 500, 8.4));
//
//            hotels.add(new Hotel(2, "Marriott Marquis Times Square", "1535 Broadway", "New York", "United States", "+1 212-398-1900", "info@marriottmarquis.com", "main_image_b.jpg", 5, 200, 7.9));
//
//            hotels.add(new Hotel(3, "Ritz Paris", "15 Place Vendôme", "Paris", "France", "+33 1 43 16 30 30", "info@ritzparis.com", "main_image_c.jpg", 4, 150, 9.2));
//
//            hotels.add(new Hotel(4, "Burj Al Arab Jumeirah", "Jumeirah Beach Road", "Dubai", "United Arab Emirates", "+971 4 301 7777", "info@burjalarab.com", "main_image_d.jpg", 5, 180, 7.8));
//
//            hotels.add(new Hotel(5, "Tokyo Station Hotel", "1-9-1 Marunouchi", "Tokyo", "Japan", "+81 3-5220-1111", "info@tokyostationhotel.com", "main_image_e.jpg", 2, 120, 8.5));
//
//            hotels.add(new Hotel(6, "Hotel Adlon Kempinski", "Unter den Linden 77", "Berlin", "Germany", "+49 30 2261 0", "info@hoteladlon.com", "main_image_f.jpg", 3, 90, 7.2));
//
//            hotels.add(new Hotel(7, "Hotel del Coronado", "1500 Orange Ave", "Coronado", "United States", "+1 619-435-6611", "info@hoteldel.com", "main_image_g.jpg", 4, 200, 9.5));
//        }


        return hotels;
    }

    public static List<User> getUsers() {
        List<User> userList = new ArrayList<>();

        userList.add(new User(1, "Mohammed", "Ali", "Egypt", "+20123456789", "mohammed@example.com", "image1"));
        userList.add(new User(2, "Fatima", "Ahmed", "Saudi Arabia", "+966987654321", "fatima@example.com", "image2"));
        userList.add(new User(3, "Yousef", "Khalid", "United Arab Emirates", "+971555555555", "yousef@example.com", "image3"));
        userList.add(new User(4, "Leila", "Rahman", "Qatar", "+97433333333", "leila@example.com", "image4"));
        userList.add(new User(5, "Omar", "Hassan", "Kuwait", "+96577777777", "omar@example.com", "image5"));

        return userList;
    }

    public static List<Booking> getBookingsForUser(int userId) {
        List<Booking> bookingList = new ArrayList<>();

        bookingList.add(new Booking(1, 1, 2, new Date(), addRandomDays(), 2, 200.0, "Paid", ""));
        bookingList.add(new Booking(2, 2, 4, new Date(), addRandomDays(), 1, 150.0, "Pending", "Early check-in requested"));
        bookingList.add(new Booking(3, 3, 1, new Date(), addRandomDays(), 3, 300.0, "Paid", ""));
        bookingList.add(new Booking(4, 1, 2, new Date(), addRandomDays(), 2, 220.0, "Paid", ""));
        bookingList.add(new Booking(5, 1, 5, new Date(), addRandomDays(), 1, 180.0, "Paid", ""));
        bookingList.add(new Booking(6, 5, 8, new Date(), addRandomDays(), 2, 200.0, "Paid", ""));
        bookingList.add(new Booking(7, 4, 10, new Date(), addRandomDays(), 1, 150.0, "Pending", "Early check-in requested"));
        bookingList.add(new Booking(8, 1, 7, new Date(), addRandomDays(), 3, 300.0, "Paid", ""));
        bookingList.add(new Booking(9, 2, 6, new Date(), addRandomDays(), 2, 220.0, "Paid", ""));
        bookingList.add(new Booking(10, 1, 9, new Date(), addRandomDays(), 1, 180.0, "Paid", ""));


        return bookingList.stream().filter(b -> b.getUserId() == userId).collect(Collectors.toList());
    }

    public static Date addRandomDays() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, getRandomNumber());
        return calendar.getTime();
    }

    private static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10000) + 1;
    }

}