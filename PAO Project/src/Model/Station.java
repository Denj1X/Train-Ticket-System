package Model;

public class Station {
    private String stationName;
    private String location;

    public Station(String _stationName, String _location) {
        super();
        this.stationName = _stationName;
        this.location = _location;
    }

    public String getStationName() {
        return this.stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
