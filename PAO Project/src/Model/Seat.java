package Model;

public class Seat {
    private Integer seatNumber;
    private Integer coach;
    private Passenger passenger;

    public Seat(Integer _seatNumber, Integer _coach, Passenger _passenger) {
        super();
        this.seatNumber = _seatNumber;
        this.coach = _coach;
        this.passenger = _passenger;
    }

    public Seat(Integer _seatNumber, Integer _coach) {
        super();
        this.seatNumber = _seatNumber;
        this.coach = _coach;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getCoach() {
        return coach;
    }

    public void setCoach(Integer coach) {
        this.coach = coach;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Boolean isAvailable() {
        return this.passenger == null;
    }
}