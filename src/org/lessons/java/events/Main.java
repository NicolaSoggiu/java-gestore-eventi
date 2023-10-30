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

        Event prova = new Event(eventName, eventDate, totalEventSeats);

        System.out.println("How many seats do you want to book?");
        int reservedEventSeats = scan.nextInt();
        prova.bookSeats(reservedEventSeats);

        System.out.println("Do you want to cancel a reservation? y/n : ");
        String cancelReservation = scan.next();
        if (cancelReservation.equals("y")) {
            System.out.print("how many places do you want to delete?");
            int cancelledSeats = scan.nextInt();
            prova.cancelSeats(cancelledSeats);
            System.out.println("Reserved places: " + prova.getReservedSeats());
            System.out.println("Available places: " + prova.getTotalSeats());
        }

        System.out.println(prova);

        scan.close();
    }
}
