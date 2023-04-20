package Model;

import java.util.*;

public class Train {
    private Integer TrainId;
    private List<Coach> coaches;
    private List<Route> routes;
    private static Integer nextId;
    public Train() {
        super();
        this.TrainId = nextId;
        nextId++;

        this.coaches = new ArrayList<>();
        this.routes = new ArrayList<>();
    }

    public Integer getTrainId() {
        return this.TrainId;
    }

    public void setTrainId(Integer trainId) {
        TrainId = trainId;
    }

    public List<Coach> getCoaches() {
        return this.coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<Route> getRoutes() {
        return this.routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public void removeCoach(Coach coach) {
        coaches.remove(coach);
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public void removeRoute(Route route) {
        routes.remove(route);
    }

    @Override
    public String toString() {
        return "Train{" +
                "TrainId=" + this.getTrainId() +
                ", coaches=" + this.getCoaches() +
                ", routes=" + this.getRoutes() +
                '}';
    }
}