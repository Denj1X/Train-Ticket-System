package Model;

import java.util.ArrayList;
import java.util.List;
public class Coach {
    private Integer coachNumber;
    private List<Seat> seats;
    private static Integer nextCoachNumber = 1;
    private String classOfService;

    public Coach(int numOfSeats, String _class) {
        super();
        this.coachNumber = nextCoachNumber;
        nextCoachNumber++;
        this.seats = new ArrayList<>();

        for(int i = 1; i <= numOfSeats; i++) {
            this.seats.add(new Seat(i, this.coachNumber));
        }
        this.classOfService = _class;
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

    public String getClassOfService() {
        return classOfService;
    }

    public void setClassOfService(String classOfService) {
        this.classOfService = classOfService;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Double getClassRate() {
        switch(this.getClassOfService()) {
            case "firstClass":
                return 2.0;
            case "businessClass":
                return 1.5;
            case "economyClass":
                return 1.0;
            default:
                return 1.0;
        }
    }

    @Override
    public String toString() {
        return "Coach{" +
                "coachNumber=" + this.getCoachNumber() +
                ", seats=" + this.getSeats() +
                '}';
    }
}
