package org.lessons.java.events;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event{
    private LocalTime time;
    private BigDecimal price;

    public Concert(String title, LocalDate date, int totalSeats, LocalTime time, BigDecimal price) throws IllegalArgumentException {
        super(title, date, totalSeats);
        this.time = time;
        this.price = price;
    }

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

    @Override
    public String toString() {
        return super.toString() + " Price: " + price;
    }
}
