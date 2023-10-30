package org.lessons.java.events;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event{
    // ATTRIBUTI
    private LocalTime time;
    private BigDecimal price;


    // COSTRUTTORE
    public Concert(String title, LocalDate date, int totalSeats, LocalTime time, BigDecimal price) throws IllegalArgumentException {
        super(title, date, totalSeats);
        this.time = time;
        this.price = price;
    }

    // GETTER E SETTER
    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // METODO PER FORMATTARE L'ORARIO
    public String formatTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        return time.format(formatter);
    }

    // METODO PER FORMATTARE IL PREZZO
    public String formatPrice() {
        return String.format("%,.2f€", price);
    }

    // OVERRRIDE PER AGGIUNGERE IL METODO CHE FORMATTA L'ORARIO ALLA DATA
    @Override
    public String getFormatDate() {
        return super.getFormatDate() + formatTime();
    }

    @Override
    public String toString() {
        return "Title: " + super.getTitle() + " Date: " + getFormatDate() + " Price: " + formatPrice();
    }
}
