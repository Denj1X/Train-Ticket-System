package Model;

import java.util.List;
import java.util.*;
import java.time.LocalTime;

public class Schedule {

    private List<TrainSchedule> trainSchedules;
    private Map<Route, List<TrainSchedule>> routeScheduleMap;

    public Schedule() {
        this.trainSchedules = new ArrayList<>();
        this.routeScheduleMap = new HashMap<>();
    }

    public void addTrainSchedule(Route route, LocalTime departureTime, LocalTime arrivalTime, int availableSeats) {
        TrainSchedule trainSchedule = new TrainSchedule(route, departureTime, arrivalTime, availableSeats);
        this.trainSchedules.add(trainSchedule);

        // Update the route-schedule map
        List<TrainSchedule> schedules = routeScheduleMap.getOrDefault(route, new ArrayList<>());
        schedules.add(trainSchedule);
        this.routeScheduleMap.put(route, schedules);
    }

    public void updateTrainSchedule(TrainSchedule trainSchedule, LocalTime departureTime, LocalTime arrivalTime, int availableSeats) {
        trainSchedule.setDepartureTime(departureTime);
        trainSchedule.setArrivalTime(arrivalTime);
        trainSchedule.setAvailableSeats(availableSeats);
    }

    public void deleteTrainSchedule(TrainSchedule trainSchedule) {
        this.trainSchedules.remove(trainSchedule);

        // Update the route-schedule map
        List<TrainSchedule> schedules = routeScheduleMap.get(trainSchedule.getRoute());
        schedules.remove(trainSchedule);
    }

    public List<TrainSchedule> getTrainSchedules() {
        return this.trainSchedules;
    }

    public List<TrainSchedule> getTrainSchedulesForRoute(Route route) {
        return this.routeScheduleMap.getOrDefault(route, Collections.emptyList());
    }
    public class TrainSchedule implements Comparable<TrainSchedule> {
        private Route route;
        private LocalTime departureTime;
        private LocalTime arrivalTime;
        private int availableSeats;

        public TrainSchedule(Route route, LocalTime departureTime, LocalTime arrivalTime, int availableSeats) {
            this.route = route;
            this.departureTime = departureTime;
            this.arrivalTime = arrivalTime;
            this.availableSeats = availableSeats;
        }

        public Route getRoute() {
            return this.route;
        }

        public void setRoute(Route route) {
            this.route = route;
        }

        public LocalTime getDepartureTime() {
            return this.departureTime;
        }

        public void setDepartureTime(LocalTime departureTime) {
            this.departureTime = departureTime;
        }

        public LocalTime getArrivalTime() {
            return this.arrivalTime;
        }

        public void setArrivalTime(LocalTime arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        public int getAvailableSeats() {
            return this.availableSeats;
        }

        public void setAvailableSeats(int availableSeats) {
            this.availableSeats = availableSeats;
        }

        @Override
        public int compareTo(TrainSchedule other) {
            return this.departureTime.compareTo(other.departureTime);
        }
    }
}
