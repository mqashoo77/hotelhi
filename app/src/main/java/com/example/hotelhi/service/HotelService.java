package com.example.hotelhi.service;

import com.example.hotelhi.entity.Booking;
import com.example.hotelhi.entity.Hotel;
import com.example.hotelhi.entity.Room;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HotelService {

    public static ArrayList<Hotel> getHotels(){
        ArrayList<Hotel>hotels=new ArrayList<>();
        {
            hotels.add(new Hotel(1, "Hilton London Metropole", "225 Edgware Road", "London", "United Kingdom", "+44 20 7402 4141", "info@hiltonlondonmet.com", "main_image_a.jpg", 2, 500, 8.4));

            hotels.add(new Hotel(2, "Marriott Marquis Times Square", "1535 Broadway", "New York", "United States", "+1 212-398-1900", "info@marriottmarquis.com", "main_image_b.jpg", 5, 200, 7.9));

            hotels.add(new Hotel(3, "Ritz Paris", "15 Place Vendôme", "Paris", "France", "+33 1 43 16 30 30", "info@ritzparis.com", "main_image_c.jpg", 4, 150, 9.2));

            hotels.add(new Hotel(4, "Burj Al Arab Jumeirah", "Jumeirah Beach Road", "Dubai", "United Arab Emirates", "+971 4 301 7777", "info@burjalarab.com", "main_image_d.jpg", 5, 180, 7.8));

            hotels.add(new Hotel(5, "Tokyo Station Hotel", "1-9-1 Marunouchi", "Tokyo", "Japan", "+81 3-5220-1111", "info@tokyostationhotel.com", "main_image_e.jpg", 2, 120, 8.5));

            hotels.add(new Hotel(6, "Hotel Adlon Kempinski", "Unter den Linden 77", "Berlin", "Germany", "+49 30 2261 0", "info@hoteladlon.com", "main_image_f.jpg", 3, 90, 7.2));

            hotels.add(new Hotel(7, "Hotel del Coronado", "1500 Orange Ave", "Coronado", "United States", "+1 619-435-6611", "info@hoteldel.com", "main_image_g.jpg", 4, 200, 9.5));
        }


        return hotels;
    }
    public static Hotel getHotelById(int id){
        Hotel hotel=new Hotel(1, "Hilton London Metropole", "225 Edgware Road", "London", "United Kingdom", "+44 20 7402 4141", "info@hiltonlondonmet.com", "main_image_a.jpg", 2, 500, 8.4);
        return hotel;
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
        long timeDiff = booking.getCheckOutDate().getTime() - booking.getCheckOutDate().getTime();

        long daysDifference = TimeUnit.MILLISECONDS.toDays(timeDiff);
        booking.setTotalPrice(booking.getTotalPrice()*daysDifference);
        //insert booking
    }

    public static ArrayList<Hotel>filterHotel(Date chickIn,Date chickOut,String city,int numOfGuests,int stars,String sort,int priceFrom,int priceTo){
        ArrayList<Hotel>hotels=new ArrayList<>();
        {
            hotels.add(new Hotel(1, "Hilton London Metropole", "225 Edgware Road", "London", "United Kingdom", "+44 20 7402 4141", "info@hiltonlondonmet.com", "main_image_a.jpg", 2, 500, 8.4));

            hotels.add(new Hotel(2, "Marriott Marquis Times Square", "1535 Broadway", "New York", "United States", "+1 212-398-1900", "info@marriottmarquis.com", "main_image_b.jpg", 5, 200, 7.9));

            hotels.add(new Hotel(3, "Ritz Paris", "15 Place Vendôme", "Paris", "France", "+33 1 43 16 30 30", "info@ritzparis.com", "main_image_c.jpg", 4, 150, 9.2));

            hotels.add(new Hotel(4, "Burj Al Arab Jumeirah", "Jumeirah Beach Road", "Dubai", "United Arab Emirates", "+971 4 301 7777", "info@burjalarab.com", "main_image_d.jpg", 5, 180, 7.8));

            hotels.add(new Hotel(5, "Tokyo Station Hotel", "1-9-1 Marunouchi", "Tokyo", "Japan", "+81 3-5220-1111", "info@tokyostationhotel.com", "main_image_e.jpg", 2, 120, 8.5));

            hotels.add(new Hotel(6, "Hotel Adlon Kempinski", "Unter den Linden 77", "Berlin", "Germany", "+49 30 2261 0", "info@hoteladlon.com", "main_image_f.jpg", 3, 90, 7.2));

            hotels.add(new Hotel(7, "Hotel del Coronado", "1500 Orange Ave", "Coronado", "United States", "+1 619-435-6611", "info@hoteldel.com", "main_image_g.jpg", 4, 200, 9.5));
        }


        return hotels;

    }
    public static ArrayList<Hotel> getBestHotels(){
        ArrayList<Hotel>hotels=new ArrayList<>();
        {
            hotels.add(new Hotel(1, "Hilton London Metropole", "225 Edgware Road", "London", "United Kingdom", "+44 20 7402 4141", "info@hiltonlondonmet.com", "main_image_a.jpg", 2, 500, 8.4));

            hotels.add(new Hotel(2, "Marriott Marquis Times Square", "1535 Broadway", "New York", "United States", "+1 212-398-1900", "info@marriottmarquis.com", "main_image_b.jpg", 5, 200, 7.9));

            hotels.add(new Hotel(3, "Ritz Paris", "15 Place Vendôme", "Paris", "France", "+33 1 43 16 30 30", "info@ritzparis.com", "main_image_c.jpg", 4, 150, 9.2));

            hotels.add(new Hotel(4, "Burj Al Arab Jumeirah", "Jumeirah Beach Road", "Dubai", "United Arab Emirates", "+971 4 301 7777", "info@burjalarab.com", "main_image_d.jpg", 5, 180, 7.8));

            hotels.add(new Hotel(5, "Tokyo Station Hotel", "1-9-1 Marunouchi", "Tokyo", "Japan", "+81 3-5220-1111", "info@tokyostationhotel.com", "main_image_e.jpg", 2, 120, 8.5));

            hotels.add(new Hotel(6, "Hotel Adlon Kempinski", "Unter den Linden 77", "Berlin", "Germany", "+49 30 2261 0", "info@hoteladlon.com", "main_image_f.jpg", 3, 90, 7.2));

            hotels.add(new Hotel(7, "Hotel del Coronado", "1500 Orange Ave", "Coronado", "United States", "+1 619-435-6611", "info@hoteldel.com", "main_image_g.jpg", 4, 200, 9.5));
        }


        return hotels;
    }
    public static ArrayList<Hotel> getByCity(String s){
        ArrayList<Hotel>hotels=new ArrayList<>();
        {
            hotels.add(new Hotel(1, "Hilton London Metropole", "225 Edgware Road", "London", "United Kingdom", "+44 20 7402 4141", "info@hiltonlondonmet.com", "main_image_a.jpg", 2, 500, 8.4));

            hotels.add(new Hotel(2, "Marriott Marquis Times Square", "1535 Broadway", "New York", "United States", "+1 212-398-1900", "info@marriottmarquis.com", "main_image_b.jpg", 5, 200, 7.9));

            hotels.add(new Hotel(3, "Ritz Paris", "15 Place Vendôme", "Paris", "France", "+33 1 43 16 30 30", "info@ritzparis.com", "main_image_c.jpg", 4, 150, 9.2));

            hotels.add(new Hotel(4, "Burj Al Arab Jumeirah", "Jumeirah Beach Road", "Dubai", "United Arab Emirates", "+971 4 301 7777", "info@burjalarab.com", "main_image_d.jpg", 5, 180, 7.8));

            hotels.add(new Hotel(5, "Tokyo Station Hotel", "1-9-1 Marunouchi", "Tokyo", "Japan", "+81 3-5220-1111", "info@tokyostationhotel.com", "main_image_e.jpg", 2, 120, 8.5));

            hotels.add(new Hotel(6, "Hotel Adlon Kempinski", "Unter den Linden 77", "Berlin", "Germany", "+49 30 2261 0", "info@hoteladlon.com", "main_image_f.jpg", 3, 90, 7.2));

            hotels.add(new Hotel(7, "Hotel del Coronado", "1500 Orange Ave", "Coronado", "United States", "+1 619-435-6611", "info@hoteldel.com", "main_image_g.jpg", 4, 200, 9.5));
        }


        return hotels;
    }

}
