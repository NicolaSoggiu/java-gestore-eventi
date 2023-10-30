package org.lessons.java.events;

import java.time.LocalDate;

public class Event {
    private String title;
    private LocalDate date;
    private int totalSeats;
    private int reservedSeats;

    public Event(String title, LocalDate date, int totalSeats) throws IllegalArgumentException {
        if (totalSeats <= 0) {
            throw new IllegalArgumentException("Something went wrong with the seats!");
        }

        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The event date cannot have passed!");
        }

        this.title = title;
        this.date = date;
        this.totalSeats = totalSeats;
        reservedSeats = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }
}
