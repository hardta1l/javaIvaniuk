package service;

import lab1.railwaystation.*;
import lab1.railwaystation.Journey;
import lab1.railwaystation.Passenger;
import lab1.railwaystation.Ticket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Passenger passenger = new Passenger.Builder()
                .setFirstname("Ivan")
                .setLastname("Ivanuk")
                .setEmail("ivan@gmail.com")
                .setPhoneNumber("0992799034").build();
        Passenger passenger1 = new Passenger.Builder()
                .setFirstname("Katrin")
                .setLastname("White")
                .setEmail("katrin@gmail.com")
                .setPhoneNumber("0992799031").build();
        Passenger passenger2 = new Passenger.Builder()
                .setFirstname("Andrey")
                .setLastname("Weak")
                .setEmail("andrey@gmail.com")
                .setPhoneNumber("0662799034").build();
        Ticket ticket = new Ticket.Builder()
                .setPrice(150)
                .setPlace(1)
                .setBenefit(Ticket.Benefit.student)
                .setPassenger(passenger)
                .setPurchaseDate(LocalDate.of(2022, 12, 12))
                .setTrainCar(2).build();
        Ticket ticket1 = new Ticket.Builder()
                .setPrice(250)
                .setPlace(1)
                .setBenefit(Ticket.Benefit.full)
                .setPassenger(passenger2)
                .setPurchaseDate(LocalDate.of(2022, 11, 1))
                .setTrainCar(2).build();
        Ticket ticket2 = new Ticket.Builder()
                .setPrice(100)
                .setPlace(1)
                .setBenefit(Ticket.Benefit.special)
                .setPassenger(passenger1)
                .setPurchaseDate(LocalDate.of(2022, 12, 2))
                .setTrainCar(2).build();

        List<Ticket> tickets = List.of(ticket1, ticket2, ticket);

        Journey journey = new Journey.Builder()
                .setTickets(tickets)
                .setArrivalTime(LocalDateTime.of(2023, 1, 1, 20, 12, 00))
                .setDepartureTime(LocalDateTime.of(2023, 1, 1, 15, 00, 00))
                .setDeparture("Chernivtsi")
                .setDestination("Lviv")
                .setTrainNumber(123).build();

        RailwayStationService railwayStationService = new RailwayStationService(journey);

        System.out.println("Tickets sorted by full name of passengers:");
        System.out.println(railwayStationService.sortByFirstnameLastname());

        System.out.println("\nTickets sorted by full name og passengers (Stream):");
        System.out.println(railwayStationService.sortByFirstnameLastnameStream());

        System.out.println("\nTickets sorted bu purchase date: ");
        System.out.println(railwayStationService.sortByPurchaseDate());

        System.out.println("\nTickets sorted by purchase date (Stream): ");
        System.out.println(railwayStationService.sortByPurchaseDateStream());

        System.out.println("\nFind tickets with students benefits");
        System.out.println(railwayStationService.findByBenefit("student"));

        System.out.println("\nFind tickets with students benefits (Stream) ");
        System.out.println(railwayStationService.findByBenefitStream("student"));

        System.out.println("\nFilter tickets by price - less than 200 ");
        System.out.println(railwayStationService.filterPriceLessThan(200));

        System.out.println("\nFilter tickets by price - less than 200 (Stream)");
        System.out.println(railwayStationService.filterPriceLessThanStream(200));



    }

}
