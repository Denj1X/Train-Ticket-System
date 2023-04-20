package Model;

public class Seat {
    private int seatNumber;
    private boolean available;
    private Passenger passenger;
    protected double fare;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.available = available;
        this.fare = fare;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public boolean reserveSeat() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }

    public boolean cancelSeat() {
        if (!available) {
            available = true;
            passenger = null;
            return true;
        }
        return false;
    }

    public Passenger getReservedPassenger() {
        return passenger;
    }
}