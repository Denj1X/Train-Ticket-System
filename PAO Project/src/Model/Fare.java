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

    public Fare(Double _baseFare, Double _distanceRate, Double _durationRate, Double _discountRate) {
        super();
        this.baseFare = _baseFare;
        this.distanceRate = _distanceRate;
        this.durationRate = _durationRate;
        this.discountRate = _discountRate;
        this.finalFare = 0.0;
    }

    public double calculateFare(Route route, Coach coach, LocalDateTime travelTime) {
        double distance = route.getDistance();
        double duration = Duration.between((Temporal) route.getDepartureTime(), (Temporal) route.getArrivalTime()).toMinutes() / 60.0;
        double classRate = coach.getClassRate();

        double distanceCost = distance * this.distanceRate;
        double durationCost = duration * this.durationRate;
        double classCost = classRate * this.baseFare;

        double totalCost = distanceCost + durationCost + classCost;

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

    public double getDistanceRate() {
        return this.distanceRate;
    }

    public void setDistanceRate(double distanceRate) {
        this.distanceRate = distanceRate;
    }

    public double getDurationRate() {
        return this.durationRate;
    }

    public void setDurationRate(double durationRate) {
        this.durationRate = durationRate;
    }

    public double getDiscountRate() {
        return this.discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getFinalFare() {
        return this.finalFare;
    }

    public void setFinalFare(double finalFare) {
        this.finalFare = finalFare;
    }
}
