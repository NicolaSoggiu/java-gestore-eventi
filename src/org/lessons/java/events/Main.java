package org.lessons.java.events;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Insert event title: ");
            String eventName = scan.nextLine();

            System.out.print("Insert event date (yyyy-MM-dd): ");
            String eventDateString = scan.nextLine();
            LocalDate eventDate = LocalDate.parse(eventDateString);

            if (eventDate.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("The event date cannot have passed!");
            }

            System.out.print("Insert the total of the seats: ");
            int totalEventSeats = scan.nextInt();

            if (totalEventSeats <= 0) {
                throw new IllegalArgumentException("Something went wrong with the seats!");
            }

            Event prova = new Event(eventName, eventDate, totalEventSeats);

            System.out.println("How many seats do you want to book?");
            int reservedEventSeats = scan.nextInt();
            prova.bookSeats(reservedEventSeats);
            if (reservedEventSeats > totalEventSeats) {
                throw new IllegalArgumentException("There are not all these places to book");
            }
            System.out.println("Reserved places: " + prova.getReservedSeats());
            System.out.println("Available places: " + prova.getTotalSeats());

            System.out.print("Do you want to cancel a reservation? y/n : ");
            String cancelReservation = scan.next();
            if (cancelReservation.equals("y")) {
                System.out.print("how many places do you want to delete?");
                int cancelledSeats = scan.nextInt();
                if (cancelledSeats > prova.getReservedSeats()) {
                    System.out.println("You don't have booked all these places!");
                }

                prova.cancelSeats(cancelledSeats);
                System.out.println("Reserved places: " + prova.getReservedSeats());
                System.out.println("Available places: " + prova.getTotalSeats());
            }

            System.out.println(prova);
        } catch (IllegalArgumentException e) {
            System.out.println("Something went wrong! " + e.getMessage());
        }

        scan.close();
    }
}