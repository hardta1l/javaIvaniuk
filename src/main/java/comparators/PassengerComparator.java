package comparators;

import lab1.railwaystation.*;

import java.util.Comparator;

public class PassengerComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket t1, Ticket t2){
        if (t1.getPassenger().getFirstname().compareTo(t2.getPassenger().getFirstname()) == 0) {
            return t1.getPassenger().getLastname().compareTo(t2.getPassenger().getLastname());
        }
        return t1.getPassenger().getFirstname().compareTo(t2.getPassenger().getFirstname());
    }
}
