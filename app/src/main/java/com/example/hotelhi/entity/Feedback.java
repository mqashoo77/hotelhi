package com.example.hotelhi.entity;

public class Feedback {
    private int feedbackId;
    private int guestId;
    private int hotelId;
    private int rating;
    private String comments;

    public Feedback(int feedbackId, int guestId, int hotelId, int rating, String comments) {
        this.feedbackId = feedbackId;
        this.guestId = guestId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.comments = comments;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
