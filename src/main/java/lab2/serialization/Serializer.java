package lab2.serialization;

import lab1.railwaystation.*;

import java.util.List;

public interface Serializer {
    List<Ticket> listFromFile(String filename);

    Ticket fromFile(String fileName);

    void toFile(Ticket ticket, String fileName);

    void listToFile(List<Ticket> Ticket, String fileName);
}

