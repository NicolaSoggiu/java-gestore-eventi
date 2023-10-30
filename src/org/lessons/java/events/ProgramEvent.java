package org.lessons.java.events;

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
}
