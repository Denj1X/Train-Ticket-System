package Model;

import java.util.List;
import java.util.*;
public class Intercity extends Route {
    public Intercity(Station _startStation, Station _endStation, Double _distance, Date _departureTime,
                     Date _arrivalTime, Train _train, List<Station> _stations) {
        super(_startStation, _endStation, _distance, _departureTime, _arrivalTime, _train, _stations);
        this.filterStations();
    }

    private void filterStations() {
        List<Station> stations = getStations();
        List<Station> filteredStations = new ArrayList<>();

        for (Station station : stations) {
            if (station.getTownSize() >= 80000) {
                filteredStations.add(station);
            }
        }

        setStations(filteredStations);
    }
}
