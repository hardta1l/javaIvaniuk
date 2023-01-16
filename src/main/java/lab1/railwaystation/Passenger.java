package lab1.railwaystation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

/**
 * class "Passenger" with fields: firstname, lastname, phoneNumber, email
 * @author User
 * @version 1.0
 */
public class Passenger implements Comparable<Passenger>{
    @Pattern(regexp = "[A-Z][a-z]{1,32}", message = "Firstname must consists only from letter and first letter must be UpperCase")
    public String firstname;
    @Pattern(regexp = "[A-Z][a-z]{1,32}", message = "Last name must consists only from letter and first letter must be UpperCase")
    public String lastname;

    public String phoneNumber;
    @Pattern(regexp = "^(.+)@(.+)$", message = "Incorrect email")

    public String email;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Overridden function of comparison an instance of
     * the class "Passenger" and an instance of the class "Object"
     * @return returns the boolean value of the comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger passenger)) return false;
        return firstname.equals(passenger.firstname) && lastname.equals(passenger.lastname) && phoneNumber.equals(passenger.phoneNumber) && email.equals(passenger.email);
    }
    /**
     * Overridden function of obtaining the hash code
     * @return returns the numeric value of the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, phoneNumber, email);
    }
    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Passenger"
     *  @return returns the string representation
     */
    @Override
    public String toString() {
        return "Passenger{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int compareTo(Passenger passenger) {
        return 0;
    }

    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Passenger"
     *  @return returns the string representation
     */

    public static class Builder {
        private Passenger passenger;

        public Builder(){ passenger = new Passenger(); }

        /**
         * Setter type designation
         *
         * @param firstname - name
         * @return returns current object
         */
        public Builder setFirstname(String firstname){
            passenger.firstname = firstname;
            return this;
        }

        /**
         * Setter type designation
         * @param lastname - surname
         * @return returns current object
         */
        public Builder setLastname(String lastname){
            passenger.lastname = lastname;
            return this;
        }

        /**
         * Setter type designation
         * @param phoneNumber - passenger phone number
         * @return returns current object
         */
        public Builder setPhoneNumber(String phoneNumber){
            passenger.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Setter type designation
         * @param email - passenger email
         * @return returns current object
         */
        public Builder setEmail(String email){
            passenger.email = email;
            return this;
        }

        /**
         * Function of creating an object of class "Passenger"
         * @return returns new object of class "Passenger"
         */
        public Passenger build(){
            validate(passenger);
            return passenger;
        }
    }
    private static void validate(Passenger passenger) throws IllegalArgumentException {

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


        Set<ConstraintViolation<Passenger>> check = validator.validate(passenger);

        StringBuilder sb = new StringBuilder();

        for(ConstraintViolation<Passenger> element : check){
            sb.append("Error value "+element.getInvalidValue() + " because " + element.getMessage());
            sb.append("\n");
        }

        if(sb.length() > 0){
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static void main(String args[]) {
        try{
            Passenger passenger = new Passenger.Builder()
                    .setFirstname("ivan")
                    .setLastname("icafjo4")
                    .setEmail("username")
                    .build();
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }


}
