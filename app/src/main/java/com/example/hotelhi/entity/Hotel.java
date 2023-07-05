package com.example.hotelhi.entity;

public class Hotel {
    private int hotelId;
    private String name;
    private String address;
    private String city;
    private String country;
    private String phoneNumber;
    private String email;
    private String mainImage;
    private int distanceFromCenter;

    public Hotel(int distanceFromCenter,int hotelId, String name, String address, String city, String country, String phoneNumber, String email, String mainImage) {
        this.hotelId = hotelId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.mainImage = mainImage;
        this.distanceFromCenter=distanceFromCenter;
    }

    public int getDistanceFromCenter() {
        return distanceFromCenter;
    }

    public void setDistanceFromCenter(int distanceFromCenter) {
        this.distanceFromCenter = distanceFromCenter;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }
}
