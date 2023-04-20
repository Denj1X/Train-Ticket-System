package Model;

import java.util.ArrayList;
import java.util.List;
public class Coach {
    private Integer coachNumber;
    private List<Seat> seats;
    private static Integer nextCoachNumber = 1;

    public Coach(int numOfSeats) {
        super();
        this.coachNumber = nextCoachNumber;
        nextCoachNumber++;
        this.seats = new ArrayList<>();

        for(int i = 1; i <= numOfSeats; i++) {
            this.seats.add(new Seat(i, this.coachNumber));
        }
    }

    public Integer getCoachNumber() {
        return coachNumber;
    }

    public void setCoachNumber(Integer coachNumber) {
        this.coachNumber = coachNumber;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public static Integer getNextCoachNumber() {
        return nextCoachNumber;
    }

    public static void setNextCoachNumber(Integer nextCoachNumber) {
        Coach.nextCoachNumber = nextCoachNumber;
    }

    public Seat getSeat(int seatNumber) {
        for(Seat seat: seats) {
            if(seat.getSeatNumber() == seatNumber) {
                return seat;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "coachNumber=" + coachNumber +
                ", seats=" + seats +
                '}';
    }
}
