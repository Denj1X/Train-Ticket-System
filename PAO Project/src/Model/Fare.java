package Model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public class Fare {
    private Double baseFare;
    private Double distanceRate;
    private Double durationRate;
    private Double discountRate;
    private Double finalFare;

    private Route route;

    private Coach coach;

    public Fare(Double _baseFare, Double _distanceRate,
                Double _durationRate, Double _discountRate, Route _route, Coach _coach) {
        super();
        this.baseFare = _baseFare;
        this.distanceRate = _distanceRate;
        this.durationRate = _durationRate;
        this.discountRate = _discountRate;
        this.finalFare = 0.0;
        this.route = _route;
        this.coach = _coach;
    }

    public Double calculateFare(Route route, Coach coach) {
        Double distance = route.getDistance();
        Double duration = Duration.between((Temporal) route.getDepartureTime(), (Temporal) route.getArrivalTime()).toMinutes() / 60.0;
        Double classRate = coach.getClassRate();

        Double distanceCost = distance * this.distanceRate;
        Double durationCost = duration * this.durationRate;
        Double classCost = classRate * this.baseFare;

        Double totalCost = distanceCost + durationCost + classCost;

        if (this.discountRate > 0.0) {
            totalCost = totalCost - (totalCost * this.discountRate);
        }

        this.finalFare = totalCost;

        return this.finalFare;
    }

    public double getBaseFare() {
        return this.baseFare;
    }

    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }

    public Double getDistanceRate() {
        return this.distanceRate;
    }

    public void setDistanceRate(double distanceRate) {
        this.distanceRate = distanceRate;
    }

    public Double getDurationRate() {
        return this.durationRate;
    }

    public void setDurationRate(double durationRate) {
        this.durationRate = durationRate;
    }

    public Double getDiscountRate() {
        return this.discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public Double getFinalFare() {
        return this.finalFare;
    }

    public void setFinalFare(double finalFare) {
        this.finalFare = finalFare;
    }

    public Route getRoute() {
        return this.route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Coach getCoach() {
        return this.coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
