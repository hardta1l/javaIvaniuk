package lab2.serialization;
import lab1.railwaystation.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class SerializerTXT implements Serializer{
    private String toString(Ticket t) {
        return
                "Price~" + t.getPrice() + "~" +
                        "Place~" + t.getPlace() + "~" +
                        "Train Car~" + t.getTrainCar() + "~" +
                        "Benefit~" + t.getBenefit() + "~" +
                        "Purchase date~" + t.getPurchaseDate() + "~" +
                        "Firstname~" + t.getPassenger().getFirstname() + "~" +
                        "Lastname~" + t.getPassenger().getLastname() + "~" +
                        "Phone number~" + t.getPassenger().getPhoneNumber() + "~" +
                        "Email~" + t.getPassenger().getEmail();
    }
    private String toString(List<Ticket> tickets) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < tickets.size(); i++) {
            res.append(toString(tickets.get(i)));
            if (i+1 < tickets.size()) {
                res.append(";");
            }
        }
        return res.toString();
    }
    private Ticket fromString(String s){
        String [] obj = s.split("~");
        Ticket res = new Ticket();
        Passenger passenger = new Passenger.Builder()
                .setFirstname(obj[11])
                .setLastname(obj[13])
                .setEmail(obj[17])
                .setPhoneNumber(obj[15]).build();
        res.setPrice(Integer.parseInt(obj[1]));
        res.setPlace(Integer.parseInt(obj[3]));
        res.setTrainCar(Integer.parseInt(obj[5]));
        res.setBenefit(Ticket.Benefit.valueOf(obj[7]));
        res.setPurchaseDate(LocalDate.parse(obj[9]));
        res.setPassenger(passenger);
        return res;
    }

    private  List<Ticket> fromStringList(String s){
        String [] obj = s.split(";");
        List<Ticket> res = new ArrayList<>();
        for(String item:obj){
            res.add(fromString(item));
        }
        return res;
    }

    @Override
    public List<Ticket> listFromFile(String fileName) {
        try (
                FileReader fw = new FileReader(new File(fileName));
                BufferedReader bw = new BufferedReader(fw)) {
            return fromStringList(bw.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Ticket fromFile(String fileName) {
        try (
                FileReader fw = new FileReader(new File(fileName));
                BufferedReader bw = new BufferedReader(fw)) {
            return fromString(bw.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void toFile(Ticket ticket, String fileName) {
        try (
                FileWriter fw = new FileWriter(new File(fileName));
                BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(toString(ticket));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void listToFile(List<Ticket> tickets, String fileName) {
        try(
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(toString(tickets));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) {
        Passenger passenger = new Passenger.Builder()
                .setFirstname("Ivan")
                .setLastname("Ivanuk")
                .setEmail("andrey@gmail.com")
                .setPhoneNumber("0992799034").build();
        Ticket ticket = new Ticket();
        ticket.setPlace(1);
        ticket.setBenefit(Ticket.Benefit.student);
        ticket.setPrice(340);
        ticket.setPassenger(passenger);
        ticket.setTrainCar(2);
        ticket.setPurchaseDate(LocalDate.of(2022, 12, 15));

        Serializer serializer = new SerializerTXT();
        serializer.toFile(ticket, "ticketTXT");

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
        serializer.listToFile(tickets, "ticketsTXT");

        ticket = serializer.fromFile("ticketTXT");
        System.out.println(ticket);
        tickets = serializer.listFromFile("ticketsTXT");
        System.out.println(tickets);
    }
}