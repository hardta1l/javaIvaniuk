package comparators;


import lab1.railwaystation.*;

import java.util.Comparator;

public class PurchaseDateComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket t1, Ticket t2){
        return t1.getPurchaseDate().compareTo(t2.getPurchaseDate());
    }
}
