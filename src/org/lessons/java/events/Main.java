package org.lessons.java.events;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Insert event title: ");
        String eventName = scan.nextLine();

        System.out.print("Insert event date (yyyy-mm-dd): ");
        String eventDateString = scan.nextLine();
        LocalDate eventDate = LocalDate.parse(eventDateString);

        System.out.print("Insert the total of the seats: ");
        int totalEventSeats = scan.nextInt();

        System.out.print("Insert the reserved seats : ");
        int reservedEventSeats = scan.nextInt();

        Event prova = new Event(eventName, eventDate, totalEventSeats);
        System.out.println(prova);

        scan.close();
    }
}
