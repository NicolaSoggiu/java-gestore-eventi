package org.lessons.java.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Event {
    // ATTRIBUTI
    private String title;
    private LocalDate date;
    private int totalSeats;
    private int reservedSeats;

    // COSTRUTTORE
    public Event(String title, LocalDate date, int totalSeats) throws IllegalArgumentException {
        validateTotalSeats(totalSeats);
        validateDate(date);

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

    // METODO PER VALIDARE LA DATA
    private static void validateDate(LocalDate date) {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The event date cannot have passed!");
        }
    }

    // METODO PER VALIDARE IL TOTALE DEI POSTI
    private static void validateTotalSeats(int totalSeats) {
        if (totalSeats <= 0) {
            throw new IllegalArgumentException("Something went wrong with the seats!");
        }
    }

    // METODO PER PRENOTARE I POSTI
    public void bookSeats(int seats) throws IllegalArgumentException {
        validateEventDate();
        if (reservedSeats + seats > totalSeats) {
            throw new IllegalArgumentException("Sold out!");
        }
        reservedSeats += seats;
    }


    // METODO PER CANCELLARE UNA PRENOTAZIONE
    public void cancelSeats(int seats) throws IllegalArgumentException {
        validateEventDate();
        if (reservedSeats < seats) {
            throw new IllegalArgumentException("There are no reserved seats to cancel!");
        }
        reservedSeats -= seats;
    }

    // METODO PER VALIDARE LA DATA DELL'EVENTO
    private void validateEventDate() {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The event has already passed! You cannot reserve seats.");
        }
    }

    // METODO PER FORMATTARE LA DATA
    public String formatDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
    public String getFormatDate() {
        return formatDate();
    }

    // METODO EQUALS CHE SERVE PER PARAGONARE L'EVENTO CON LA CLASSE PROGRAMEVENT
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) && Objects.equals(date, event.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date);
    }

    // TOSTRING
    @Override
    public String toString() {
        return "Date: " + getFormatDate() + " - " + "Title: " + title;
    }
}
