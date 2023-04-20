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
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Date getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(Date dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", coach=" + coach +
                ", seat=" + seat +
                ", passenger=" + passenger +
                ", dateOfJourney=" + dateOfJourney +
                '}';
    }
}
