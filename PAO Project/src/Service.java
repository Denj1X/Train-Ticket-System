import Model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.*;

public class Service {
    private static List<Ticket> tickets = new ArrayList<>();
    private static List<BookingHistory> bookingHistories = new ArrayList<>();
    private static List<Route> routes = new ArrayList<>();
    private static List<Coach> coaches = new ArrayList<>();
    private static List<Station> stations = new ArrayList<>();
    private static List<Train> trains = new ArrayList<>();
    private static List<Passenger> passengers = new ArrayList<>();

    File audit = new File("audit.csv");
    PrintWriter writer = null;
    Connection conn = null;

    private Service() {
        try {
            writer = new PrintWriter(audit);
            writer.flush();
        } catch (IOException ex){
            System.out.println("Can't create the audit file!");
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/paoproject", "root", "root");
            Statement statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static class Singleton {

        private static final Service instance = new Service();
    }

    public static Service getInstance() {
        return Singleton.instance;
    }

    private void makeAudit(String action){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        writer.print(timestamp + ", ");
        writer.println(action);
        writer.flush();
    }
    // Method to book a train ticket
    public Ticket bookTicket(String _source, String _destination, Integer idTren, Integer idCoach, Integer idSeat, Passenger _passenger, Date _dateOfJourney, Route _route) {
        if(idTren >= trains.size()) {
            System.out.println("Numar introdus gresit!");
            return null;
        }

        Train train = trains.get(idTren);
        List<Coach> coaches1 = train.getCoaches();

        if(idCoach > coaches1.size()) {
            System.out.println("Numar introdus gresit!");
        }

        Coach coach = coaches1.get(idCoach);
        List<Seat> seats = coach.getSeats();

        if(idSeat > seats.size()) {
            System.out.println("Numar introdus gresit!");
        }

        Seat seat = seats.get(idSeat);
        Fare fare = new Fare(10d, 1.25d, 0.85d, 0.15d, _route, coach);
        fare.calculateFare(_route, coach);
        Ticket ticket = new Ticket(_source, _destination, coach, seat, _passenger, _dateOfJourney, _route, fare);
        tickets.add(ticket);
        String audit = "Ticket created";
        makeAudit(audit);
        System.out.println("Ticket created");
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
            System.out.println("Cancelled ticket");
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

        String audit = "Available seats for a train";
        makeAudit(audit);
        return availableSeats;
    }

    //Method to check all stations for each route of a train
    public List<List<Station>> StationsPerRoute(Integer nr) {
        if(nr >= getTrains().size()) {
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

        String audit = "Stations for each route train";
        makeAudit(audit);
        return stations;
    }

    // Method to modify passenger information
    public void modifyPassengerInformation(String _nume, String name, String email, String phone) {
        List<Passenger> passengerList = getPassengers();
        for (Passenger pass : passengerList) {
            if (pass.getLastName().equals(_nume)) {
                pass.setLastName(name);
                pass.setEmail(email);
                pass.setContactNumber(phone);
            }
        }

        String audit = "Modify passenger information";
        makeAudit(audit);
    }

    ///Method to list all ticket fares for a train
    ///including sorting by the key of a pair
    public List<Pair<Double, Fare>> ticketFares(Integer nr) {
        if(nr >= trains.size()) {
            System.out.println("Numar introdus gresit!");
            return null;
        }

        Train train = trains.get(nr);
        List<Pair<Double, Fare>> fares = new ArrayList<>();
        List<Ticket> tickets = train.getTickets();

        for(Ticket ticket: tickets) {
            Fare fare = ticket.getFareTicket();
            Double price = fare.calculateFare(fare.getRoute(), fare.getCoach());
            fares.add(new Pair<>(price, fare));
            PairComparator<Double, Fare> comparator = new PairComparator<>();
            fares.sort(comparator);
        }

        String audit = "Sort and print fares";
        makeAudit(audit);
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

        String audit = "Search a train by id";
        makeAudit(audit);
        return result;
    }

    // Method to get train route information
    public List<Route> getTrainRoute(Integer number) {
        if(number >= trains.size()) {
            System.out.println("Numar introdus gresit!");
        }

        Train train = trains.get(number);
        List<Route> trainRoutes = train.getRoutes();

        String audit = "Route informations";
        makeAudit(audit);
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

        String audit = "Show tickets for a train";
        makeAudit(audit);
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

        String audit = "Show train statistics";
        makeAudit(audit);
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

        String audit = "Finding passenger";
        makeAudit(audit);
    }

    public static List<Train> getTrains() {
        return trains;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        Service.routes = routes;
    }
}
