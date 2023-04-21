package Model;

import java.util.ArrayList;
import java.util.List;

public class BookingHistory {
    private Passenger passenger;
    private List<Ticket> tickets;
    private String status;

    public BookingHistory(Passenger passenger, String _status) {
        this.passenger = passenger;
        this.tickets = new ArrayList<>();
        this.status = _status;
    }

    public Passenger getPassenger() {
        return this.passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public List<Ticket> getTickets() {
        return this.tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void viewBookingHistory() {
        if (this.tickets.isEmpty()) {
            System.out.println("Booking history is empty!");
        } else {
            System.out.println("Booking history for passenger " + this.passenger.getLastName() + ":");
            for (Ticket ticket : this.tickets) {
                System.out.println(ticket);
            }
        }
    }
}