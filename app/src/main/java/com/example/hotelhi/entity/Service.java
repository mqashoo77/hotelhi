package com.example.hotelhi.entity;

public class Service {
    private int serviceId;
    private int hotelId;
    private String name;
    private String description;
    private double price;

    public Service(int serviceId, int hotelId, String name, String description, double price) {
        this.serviceId = serviceId;
        this.hotelId = hotelId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
