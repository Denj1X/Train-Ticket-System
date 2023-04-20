package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Route {
    private Integer routeId;
    private Station startStation;
    private Station endStation;
    private Double distance;
    private Date departureTime;
    private Date arrivalTime;
    private Train train;
    private List<Station> stations;
    private static Integer nextId = 1;

    public Route(Station _startStation, Station _endStation, Double _distance, Date _departureTime,
                 Date _arrivalTime, Train _train, List<Station> _stations) {
        this.routeId = nextId;
        nextId++;

        this.startStation = _startStation;
        this.endStation = _endStation;
        this.distance = _distance;
        this.departureTime = _departureTime;
        this.arrivalTime = _arrivalTime;
        this.train = _train;
        this.stations = _stations;
    }

    public Integer getRouteId() {
        return this.routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Station getStartStation() {
        return this.startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public Station getEndStation() {
        return this.endStation;
    }

    public void setEndStation(Station endStation) {
        this.endStation = endStation;
    }

    public Double getDistance() {
        return this.distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Date getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Train getTrain() {
        return this.train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public List<Station> getStations() {
        return this.stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public void addStation(Station station) {
        this.stations.add(station);
    }

    public void removeStation(Station station) {
        this.stations.remove(station);
    }
}
