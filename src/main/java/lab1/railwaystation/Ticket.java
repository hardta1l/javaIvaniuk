package lab1.railwaystation;

import java.time.LocalDate;
import java.util.Objects;
/**
 * class "Ticket" with fields: price, place, trainCar, benefit, passenger, purchaseDate
 * @author User
 * @version 1.0
 */
public class Ticket implements Comparable <Ticket>{
    @Override
    public int compareTo(Ticket ticket) {
        return 0;
    }

    public enum Benefit {student, child, special, full}
    public int price;
    public int place;
    public int trainCar;
    public Benefit benefit;
    public Passenger passenger;
    public LocalDate purchaseDate;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getTrainCar() {
        return trainCar;
    }

    public void setTrainCar(int train_car) {
        this.trainCar = train_car;
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public void setBenefit(Benefit benefit) {
        this.benefit = benefit;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    /**
     * Overridden function of comparison an instance of
     * the class "Ticket" and an instance of the class "Object"
     * @return returns the boolean value of the comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return price == ticket.price && place == ticket.place && trainCar == ticket.trainCar && benefit == ticket.benefit && passenger.equals(ticket.passenger) && purchaseDate.equals(ticket.purchaseDate);
    }
    /**
     * Overridden function of obtaining the hash code
     * @return returns the numeric value of the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(price, place, trainCar, benefit, passenger, purchaseDate);
    }
    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Ticket"
     *  @return returns the string representation
     */
    @Override
    public String toString() {
        return "Ticket{" +
                "price=" + price +
                ", place=" + place +
                ", train_car=" + trainCar +
                ", benefit=" + benefit +
                ", passenger=" + passenger +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Ticket"
     *  @return returns the string representation
     */

    public static class Builder {
        private Ticket ticket;

        public Builder(){ ticket = new Ticket(); }
        /**
         * Setter type designation
         *
         * @param price - price
         * @return returns current object
         */
        public Builder setPrice(int price){
            ticket.price = price;
            return this;
        }

        /**
         * Setter type designation
         * @param place - place
         * @return returns current object
         */
        public Builder setPlace(int place){
            ticket.place = place;
            return this;
        }

        /**
         * Setter type designation
         * @param trainCar - train car
         * @return returns current object
         */
        public Builder setTrainCar(int trainCar){
            ticket.trainCar = trainCar;
            return this;
        }

        /**
         * Setter type designation
         * @param passenger - passenger
         * @return returns current object
         */
        public Builder setPassenger(Passenger passenger){
            ticket.passenger = passenger;
            return this;
        }
        /**
         * Setter type designation
         * @param benefit - benefit
         * @return returns current object
         */
        public Builder setBenefit(Benefit benefit){
            ticket.benefit = benefit;
            return this;
        }

        /**
         * Setter type designation
         * @param purchaseDate - date of purchase
         * @return returns current object
         */
        public Builder setPurchaseDate(LocalDate purchaseDate){
            ticket.purchaseDate = purchaseDate;
            return this;
        }

        /**
         * Function of creating an object of class "Ticket"
         * @return returns new object of class "Ticket"
         */
        public Ticket build(){
            return ticket;
        }
    }

}
