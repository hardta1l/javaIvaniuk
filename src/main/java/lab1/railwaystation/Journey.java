package lab1.railwaystation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
/**
 * class "Journey" with fields: trainNumber, departure, destination, departureTime, destinationTime, tickets
 * @author User
 * @version 1.0
 */
public class Journey {
    public int trainNumber;
    public LocalDateTime departureTime;
    public LocalDateTime arrivalTime;
    public String departure;
    public String destination;
    public List<Ticket> tickets;



    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    /**
     * Overridden function of comparison an instance of
     * the class "Journey" and an instance of the class "Object"
     * @return returns the boolean value of the comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Journey journey)) return false;
        return trainNumber == journey.trainNumber && departureTime.equals(journey.departureTime) && arrivalTime.equals(journey.arrivalTime) && departure.equals(journey.departure) && destination.equals(journey.destination) && tickets.equals(journey.tickets);
    }
    /**
     * Overridden function of obtaining the hash code
     * @return returns the numeric value of the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(trainNumber, departureTime, arrivalTime, departure, destination, tickets);
    }
    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Journey"
     *  @return returns the string representation
     */
    @Override
    public String toString() {
        return "Journey{" +
                "trainNumber=" + trainNumber +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", tickets=" + tickets +
                '}';
    }
    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Journey"
     *  @return returns the string representation
     */

    public static class Builder {
        private Journey journey;

        public Builder(){ journey = new Journey(); }
        /**
         * Setter type designation
         *
         * @param trainNumber
         * @return returns current object
         */
        public Builder setTrainNumber(int trainNumber){
            journey.trainNumber = trainNumber;
            return this;
        }

        /**
         * Setter type designation
         * @param departure - departure
         * @return returns current object
         */
        public Builder setDeparture(String departure){
            journey.departure = departure;
            return this;
        }
        /**
         * Setter type designation
         * @param destination - destination
         * @return returns current object
         */
        public Builder setDestination(String destination){
            journey.destination = destination;
            return this;
        }

        /**
         * Setter type designation
         * @param tickets - list of tickets
         * @return returns current object
         */
        public Builder setTickets(List<Ticket> tickets){
            journey.tickets = tickets;
            return this;
        }
        /**
         * Setter type designation
         * @param departureTime - departure date and time
         * @return returns current object
         */
        public Builder setDepartureTime(LocalDateTime departureTime){
            journey.departureTime = departureTime;
            return this;
        }

        /**
         * Setter type designation
         * @param arrivalTime = arrival date and time
         * @return returns current object
         */
        public Builder setArrivalTime(LocalDateTime arrivalTime){
            journey.arrivalTime = arrivalTime;
            return this;
        }

        /**
         * Function of creating an object of class "Journey"
         * @return returns new object of class "Journey"
         */
        public Journey build(){
            return journey;
        }
    }

}
