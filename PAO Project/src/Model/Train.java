package Model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
public class Train {
    private final int trainNumber;
    private final Station departureStation;
    private final Station arrivalStation;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;
    private final int capacity;
    protected Set<Seat> seats;
    protected Set<Schedule> schedule;

    public Train(int trainNumber, Station departureStation, Station arrivalStation, LocalDateTime departureTime, LocalDateTime arrivalTime, int capacity) {
        this.trainNumber = trainNumber;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.capacity = capacity;
        this.seats = new HashSet<Seat>();
        this.schedule = new HashSet<Schedule>();
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public Set<Schedule> getSchedule() {
        return schedule;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public void addSchedule(Schedule schedule) {
        this.schedule.add(schedule);
    }
}
