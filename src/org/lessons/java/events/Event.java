package org.lessons.java.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {
    // ATTRIBUTI
    private String title;
    private LocalDate date;
    private int totalSeats;
    private int reservedSeats;

    // COSTRUTTORE
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

    // GETTER E SETTER
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

    // METODO PER PRENOTARE I POSTI
    public void bookSeats(int seats) throws IllegalArgumentException {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The event has already passed! You cannot reserve seats.");
        }

        if (reservedSeats + seats > totalSeats) {
            throw new IllegalArgumentException("Sold out!");
        }

        reservedSeats += seats;
    }

    // METODO PER CANCELLARE UNA PRENOTAZIONE
    public void cancelSeats(int seats) throws IllegalArgumentException {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The event has already passed! You cannot cancel seats.");
        }

        if (reservedSeats < seats) {
            throw new IllegalArgumentException("There are no reserved seats to cancel!");
        }

        reservedSeats -= seats;
    }

    // METODO PER FORMATTARE LA DATA
    public String formatDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
    public String getFormatDate() {
        return formatDate();
    }

    // TOSTRING
    @Override
    public String toString() {
        return "Date: " + getFormatDate() + " - " + "Title: " + title;
    }
}
