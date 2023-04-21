package Model;

public class Station {
    private String stationName;
    private String location;

    private Integer townSize;

    public Station(String _stationName, String _location, Integer _townSize) {
        super();
        this.stationName = _stationName;
        this.location = _location;
        this.townSize = _townSize;
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

    public Integer getTownSize() {
        return this.townSize;
    }

    public void setTownSize(Integer townSize) {
        this.townSize = townSize;
    }
}
