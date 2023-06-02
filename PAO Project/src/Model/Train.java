package Model;

import java.util.*;

interface Locomotiva {
    final Integer numar_vagoane = 15;
    final Double overall_power = 1500d;
    Double putere(Integer panta);
}
public class Train implements Locomotiva {
    private Integer TrainId;
    private List<Coach> coaches;
    private List<Route> routes;
    private List<Ticket> tickets;
    private static Integer nextId;

    private Map<Seat, Ticket> asezare;

    public Train() {
        super();
        this.TrainId = nextId;
        nextId++;

        this.coaches = new ArrayList<>();
        this.routes = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.asezare = new HashMap<>();
    }

    public Integer getTrainId() {
        return this.TrainId;
    }

    public void setTrainId(Integer trainId) {
        this.TrainId = trainId;
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
        this.coaches.add(coach);
    }

    public void removeCoach(Coach coach) {
        this.coaches.remove(coach);
    }

    public void addRoute(Route route) {
        this.routes.add(route);
    }

    public void removeRoute(Route route) {
        this.routes.remove(route);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        this.tickets.remove(ticket);
    }

    public Map<Seat, Ticket> getAsezare() {
        return asezare;
    }

    public void setAsezare(Map<Seat, Ticket> asezare) {
        this.asezare = asezare;
    }

    public Double putere(Integer panta) {
        if(this.coaches.size() > 15) {
            return -1d;
        }

        if(panta < 0) {
            return overall_power - (this.coaches.size() + 1) * 25.15d * panta * 2.15d;
        }

        else if(panta == 0) {
            return overall_power - (this.coaches.size() + 1) * 13.13d;
        }

        else {
            return overall_power - (this.coaches.size() + 1) * 7.21d / panta * 2d;
        }
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
