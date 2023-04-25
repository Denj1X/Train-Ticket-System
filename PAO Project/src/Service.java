import Model.*;

import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    // Method to check availability of seats
    public List<Seat> checkSeatAvailability(Train train) {
        List<Coach> coaches = train.getCoaches();
        List<Seat> availableSeats = new ArrayList<>();
        for (Coach coach : coaches) {
            for(Seat seat: coach.getSeats()){
                if(seat.isAvailable()) {
                    availableSeats.add(seat);
                }
            }
        }
        return availableSeats;
    }

    //Method to check all stations for each route of a train
    public List<List<Station>> StationsPerRoute(Train train) {
        List <Route> routes = train.getRoutes();
        List<List<Station>> stations = new ArrayList<>();
        for(Route route: routes) {
            List<Station> stations1 = route.getStations();
            stations.add(stations1);
        }
        return stations;
    }

    // Method to modify passenger information
    public void modifyPassengerInformation(Passenger passenger, String name, String email, String phone) {
        passenger.setLastName(name);
        passenger.setEmail(email);
        passenger.setContactNumber(phone);
    }

    ///Method to list all ticket fares for a train
    ///including sorting by the key of a pair
    public List<Pair<Double, Fare>> ticketFares(Train train) {
        List<Pair<Double, Fare>> fares = new ArrayList<>();
        List<Ticket> tickets = train.getTickets();

        for(Ticket ticket: tickets) {
            Fare fare = ticket.getFareTicket();
            Double price = fare.calculateFare(fare.getRoute(), fare.getCoach());
            fares.add(new Pair<>(price, fare));
            PairComparator<Double, Fare> comparator = new PairComparator<>();
            Collections.sort(fares, comparator);
        }

        return fares;
    }

    // Method to search for a specific train
    public List<Train> searchTrain(Integer id) {
        List<Train> result = new ArrayList<>();
        for (Train train : this.trains) {
            if (train.getTrainId().equals(id)) {
                result.add(train);
            }
        }
        return result;
    }

    // Method to get train route information
    public List<Route> getTrainRoute(Train train) {
        List<Route> trainRoutes = train.getRoutes();
        return trainRoutes;
    }

    public void printTrainTicket(Ticket ticket) {
        System.out.println(ticket.toString());
    }

    public void printTrainData(Train train) {
        List<Route> trainRoutes = train.getRoutes();
        for(Route route: trainRoutes) {
            System.out.println(route.toString());
        }

        this.coaches = train.getCoaches();
        for(Coach coach: this.coaches) {
            System.out.println(coach.toString());
        }
    }
}
