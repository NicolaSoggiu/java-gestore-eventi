package org.lessons.java.events;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgramEvent {
     // ATTRIBUTI
    private String title;
    private List<Event> events;

    // COSTRUTTORE
    public ProgramEvent(String title) {
        this.title = title;
        this.events = new ArrayList<Event>();
    }

    // GETTERE E SETTER
    public String getTitle() {
        return title;
    }

    // METODI
    // METODO PER AGGIUNGERE UN EVENTO
    public void addEvent(Event event) {
        events.add(event);
    }

    // METODO PER RESITUIRE LISTA DI EVENTI IN UNA DATA
    List<Event> eventList(LocalDate date) {
        List<Event> eventOfTheDay = new ArrayList<>();
        for (Event event : events) {
            if (event.getDate().equals(date)) {
                eventOfTheDay.add(event);
            }
        }
        return eventOfTheDay;
    }

    // METODO CHE CALCOLA QUANTI EVENTI CI SONO NEL PROGRAMMA
    public int totalEvents() {
        return events.size();
    }

    // METODO CHE SVUOTA LA LISTA DEL PROGRAMMA
    public void clearList() {
        events.clear();
    }

    // METODO CHE RESTITUISCA UNA STRINGA CON IL TITOLO E GLI EVENTI ORDINATI PER DATA
    public void programList() {
        events.sort((event1, event2) -> event1.getDate().compareTo(event2.getDate()));
        System.out.println("Program: " + getTitle());
        for (Event event : events) {
            System.out.println(event);
        }
    }
}
