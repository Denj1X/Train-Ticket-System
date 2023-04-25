package Model;

import java.util.*;
public class Ticket {

    private Integer ticketNumber;
    private String source;
    private String destination;
    private Coach coach;
    private Seat seat;
    private Passenger passenger;
    private Date dateOfJourney;
    private static Integer numOfTicket = 1;

    private Route route;
    private Double fare;

    private Fare fareTicket;

    public Ticket(String _source, String _destination, Coach _coach, Seat _seat, Passenger _passenger, Date _dateOfJourney, Route _route, Fare _fare) {
        super();
        this.ticketNumber = numOfTicket;
        numOfTicket++;

        this.source = _source;
        this.destination = _destination;
        this.coach = _coach;
        this.seat = _seat;
        this.passenger = _passenger;
        this.dateOfJourney = _dateOfJourney;
        this.route = _route;
        this.fare = _fare.calculateFare(_route, _coach);
        this.fareTicket = _fare;
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

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public Fare getFareTicket() {
        return fareTicket;
    }

    public void setFareTicket(Fare fareTicket) {
        this.fareTicket = fareTicket;
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
                ", route=" + route +
                ", fare=" + fare +
                ", fareTicket=" + fareTicket +
                '}';
    }
}
