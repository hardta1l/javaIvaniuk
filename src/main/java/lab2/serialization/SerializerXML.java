package lab2.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lab1.railwaystation.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SerializerXML implements Serializer{
    private ObjectMapper objectMapper;
    public SerializerXML(){
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    @Override
    public List<Ticket> listFromFile(String fileName) {
        try {
            return objectMapper.readValue(new File(fileName), new TypeReference<>() {
            });
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public Ticket fromFile(String fileName){
        try {
            return objectMapper.readValue(new File(fileName), Ticket.class);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void toFile(Ticket ticket, String fileName){
        try {
            objectMapper.writeValue(new File(fileName), ticket);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void listToFile(List<Ticket> footballers, String fileName) {
        try {
            objectMapper.writeValue(new File(fileName), footballers);
        } catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }


    public static void main(String args[]) {
        Passenger passenger = new Passenger.Builder()
                .setFirstname("Ivan")
                .setLastname("Ivanuk")
                .setEmail("ivan@gmail.com")
                .setPhoneNumber("0992799034").build();
        Ticket ticket = new Ticket();
        ticket.setPlace(1);
        ticket.setBenefit(Ticket.Benefit.student);
        ticket.setPrice(340);
        ticket.setPassenger(passenger);
        ticket.setTrainCar(2);
        ticket.setPurchaseDate(LocalDate.of(2022, 12, 15));

        Serializer serializer = new SerializerJSON();
        serializer.toFile(ticket, "ticketXML");

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        ticket = new Ticket();
        ticket.setPlace(2);
        ticket.setBenefit(Ticket.Benefit.student);
        ticket.setPrice(300);
        ticket.setPassenger(passenger);
        ticket.setTrainCar(1);
        ticket.setPurchaseDate(LocalDate.of(2021, 12, 15));
        tickets.add(ticket);
        serializer.listToFile(tickets, "ticketsXML");

        ticket = serializer.fromFile("ticketXML");
        System.out.println(ticket);
        tickets = serializer.listFromFile("ticketsXML");
        System.out.println(tickets);
    }

}
