package service;

import comparators.PurchaseDateComparator;
import comparators.PassengerComparator;
import lab1.railwaystation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RailwayStationService {
    private Journey journey;

    public RailwayStationService(Journey jou) {
        journey = jou;
    }

    public List<Ticket> sortByFirstnameLastname() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.addAll(journey.getTickets());
        Collections.sort(tickets);
        tickets.sort(new PassengerComparator());
        return tickets;
    }

    public List<Ticket> sortByFirstnameLastnameStream() {
        return journey.getTickets().stream().sorted(new PassengerComparator()).collect(Collectors.toList());
    }

    public List<Ticket>sortByPurchaseDate(){
        List<Ticket> tickets = new ArrayList<>();
        tickets.addAll(journey.getTickets());
        Collections.sort(tickets);
        tickets.sort(new PurchaseDateComparator());
        return tickets;
    }

    public List<Ticket> sortByPurchaseDateStream(){
        return journey.getTickets().stream().sorted(new PurchaseDateComparator()).collect(Collectors.toList());
    }

    public List<Ticket> findByBenefit(String benefit){
        List<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : journey.getTickets()) {
            if (ticket.getBenefit().toString() == benefit) {
                tickets.add(ticket);
            }
        }
        return tickets;
    }
    public List<Ticket> findByBenefitStream(String b){
        return journey.getTickets().stream().filter(benefit -> benefit.getBenefit().toString().contains(b)).collect(Collectors.toList());
    }

    public List<Ticket> filterPriceLessThan(int price){
        List<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : journey.getTickets()) {
            if (ticket.getPrice() < price) {
                tickets.add(ticket);
            }
        }
        return tickets;
    }
    public List<Ticket> filterPriceLessThanStream(int p){
        return journey.getTickets().stream().filter(price -> price.getPrice() < p).collect(Collectors.toList());
    }
}