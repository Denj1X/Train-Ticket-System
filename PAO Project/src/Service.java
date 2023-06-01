import Model.*;

import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Service {
    private static List<Ticket> tickets = new ArrayList<>();
    private static List<BookingHistory> bookingHistories = new ArrayList<>();
    private static List<Route> routes = new ArrayList<>();
    private static List<Coach> coaches = new ArrayList<>();
    private static List<Station> stations = new ArrayList<>();
    private static List<Train> trains = new ArrayList<>();
    private static List<Passenger> passengers = new ArrayList<>();

    private Service() {}

    private static class Singleton {
        private static final Service instance = new Service();
    }

    public static Service getInstance() {
        return Singleton.instance;
    }
    // Method to book a train ticket
    public static Ticket bookTicket(String _source, String _destination, Coach _coach, Seat _seat, Passenger _passenger, Date _dateOfJourney, Route _route, Fare _fare) {
        Ticket ticket = new Ticket(_source, _destination, _coach, _seat, _passenger, _dateOfJourney, _route, _fare);
        tickets.add(ticket);
        System.out.println("obiect creat");
        return ticket;
    }

    //Method to create a new passenger
    public Passenger createPassenger(String _firstName, String _lastName, Integer _age, String _email, String _contactNumber, String _password) {
        Passenger passenger = new Passenger(_firstName, _lastName, _age, _email, _contactNumber, _password);
        passengers.add(passenger);
        System.out.println("obiect creat de tip pasager");
        return passenger;
    }



    public List<Passenger> getPassengers() {
        return passengers;
    }

    public static void setPassengers(List<Passenger> passengers) {
        Service.passengers = passengers;
    }

    ///method for train creation
    public void createTrain(Integer number) {
        if(number > trains.size() + 1) {
            System.out.println("Numar introdus gresit!");
        }

        else if(number.equals(trains.size() + 1)) {
            Train train = new Train();
            trains.add(train);
        }
    }

    public static Coach createCoach(Integer numOfSeats, String _class, Integer _seatNumbers) {
        Coach coach = new Coach(numOfSeats, _class, _seatNumbers);
        coaches.add(coach);
        return coach;
    }
    // Method to cancel a train ticket
    public static Boolean cancelTicket(Ticket ticket) {
        Boolean success = tickets.remove(ticket);
        if(success) {
            BookingHistory bookingHistory = new BookingHistory(ticket.getPassenger(), "Cancelled");
        }
        return success;
    }

    // Method to check availability of seats
    public List<Seat> checkSeatAvailability(Integer number) {
        if(number >= trains.size()) {
            System.out.println("Numar introdus gresit!");
            return null;
        }

        Train train = trains.get(number);
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
    public List<List<Station>> StationsPerRoute(Integer nr) {
        if(nr > getTrains().size()) {
            System.out.println("Numar introdus gresit!");
            return null;
        }

        Train trenulet = getTrains().get(nr);
        List <Route> routes = trenulet.getRoutes();
        List<List<Station>> stations = new ArrayList<>();
        for(Route route: routes) {
            List<Station> stations1 = route.getStations();
            stations.add(stations1);
        }
        return stations;
    }

    // Method to modify passenger information
    public void modifyPassengerInformation(String _nume, String name, String email, String phone) {
        List<Passenger> passengerList = getPassengers();
        for(Integer i = 0; i < passengerList.size(); i++) {
            Passenger pass = passengerList.get(i);
            if(pass.getLastName() == _nume) {
                pass.setLastName(name);
                pass.setEmail(email);
                pass.setContactNumber(phone);
            }
        }
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
        for (Train train : trains) {
            if (train.getTrainId().equals(id)) {
                result.add(train);
            }
        }
        return result;
    }

    // Method to get train route information
    public List<Route> getTrainRoute(Integer number) {
        if(number >= trains.size()) {
            System.out.println("Numar introdus gresit!");
        }

        Train train = trains.get(number);
        List<Route> trainRoutes = train.getRoutes();
        return trainRoutes;
    }

    public void printTrainTickets(Integer number) {
        if(number >= trains.size()) {
            System.out.println("Numar introdus gresit!");
        }

        Train train = trains.get(number);
        tickets = train.getTickets();

        for(Ticket ticket: tickets) {
            System.out.println(ticket.toString());
        }
    }

    public void printTrainData(Integer number) {
        if(number >= trains.size()) {
            System.out.println("Numar introdus gresit!");
        }

        Train train = trains.get(number);
        List<Route> trainRoutes = train.getRoutes();
        for(Route route: trainRoutes) {
            System.out.println(route.toString());
        }

        coaches = train.getCoaches();
        for(Coach coach: coaches) {
            System.out.println(coach.toString());
        }
    }

    ///method for finding a passenger based on a given ticket
    public void findPassengerInSeatNumber(Integer idTren, Integer idCoach, Integer idSeat) {
        if(idTren > trains.size()) {
            System.out.println("Numar introdus gresit!");
        }

        Train tren = trains.get(idTren);
        List<Coach> coaches1 = tren.getCoaches();

        if(idCoach > coaches1.size()) {
            System.out.println("Numar introdus gresit!");
        }

        Coach coach = coaches1.get(idCoach);
        List<Seat> seats = coach.getSeats();

        if(idSeat > seats.size()) {
            System.out.println("Numar introdus gresit!");
        }

        Seat seat = seats.get(idSeat);
        Passenger passenger = seat.getPassenger();
        System.out.println(passenger.toString());
    }

    public static List<Train> getTrains() {
        return trains;
    }
}
