import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.time.LocalTime;
import java.time.LocalDateTime;

import Model.Coach;
import Model.Fare;
import Model.Intercity;
import Model.BookingHistory;
import Model.Route;
import Model.Passenger;
import Model.Station;
import Model.Train;
import Model.Seat;
import Model.Ticket;

public class Service {
    private List<Ticket> tickets;
    private List<BookingHistory> bookingHistories;
    private List<Route> routes;
    private List<Coach> coaches;
    private List<Station> stations;
    private List<Train> trains;

    public Service() {
        super();
        this.tickets = new ArrayList<>();
        this.bookingHistories = new ArrayList<>();
        this.routes = new ArrayList<>();
        this.coaches = new ArrayList<>();
        this.stations = new ArrayList<>();
        this.trains = new ArrayList<>();
    }

    // Method to book a train ticket
    public Ticket bookTicket(String _source, String _destination, Coach _coach, Seat _seat, Passenger _passenger, Date _dateOfJourney, Route _route, Fare _fare) {
        Ticket ticket = new Ticket(_source, _destination, _coach, _seat, _passenger, _dateOfJourney, _route, _fare);
        this.tickets.add(ticket);
        return ticket;
    }

    // Method to cancel a train ticket
    public Boolean cancelTicket(Ticket ticket) {
        Boolean success = this.tickets.remove(ticket);
        if(success) {
            BookingHistory bookingHistory = new BookingHistory(ticket.getPassenger(), "Cancelled");
        }
        return success;
    }


}
