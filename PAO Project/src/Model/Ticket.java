package Model;

import java.time.LocalDateTime;
import java.util.*;
public class Ticket {

    private Integer ticketNumber;
    private String source;
    private String destination;
    private Coach coach;
    private Seat seat;
    private Passenger passenger;
    private Date dateOfJourney;
    private static Integer numOfTicket;

    public Ticket( String _source, String _destination, Coach _coach, Seat _seat, Passenger _passenger, Date _dateOfJourney) {
        super();
        this.ticketNumber = numOfTicket;
        numOfTicket++;
        this.source = _source;
        this.destination = _destination;
        this.coach = _coach;
        this.seat = _seat;
        this.passenger = _passenger;
        this.dateOfJourney = _dateOfJourney;
    }

    public Integer getTicketNumber() {
        return this.ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Coach getCoach() {
        return this.coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Seat getSeat() {
        return this.seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Passenger getPassenger() {
        return this.passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Date getDateOfJourney() {
        return this.dateOfJourney;
    }

    public void setDateOfJourney(Date dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + this.getTicketNumber() +
                ", source='" + this.getSource() + '\'' +
                ", destination='" + this.getDestination() + '\'' +
                ", coach=" + this.getCoach() +
                ", seat=" + this.getSeat() +
                ", passenger=" + this.getPassenger() +
                ", dateOfJourney=" + this.getDateOfJourney() +
                '}';
    }
}
